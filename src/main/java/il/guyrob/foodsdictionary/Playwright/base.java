package il.guyrob.foodsdictionary.Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import java.util.Arrays;

public class base {
    // Playwright Core Objects
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    public String url = "https://www.foodsdictionary.co.il/";

    public void initialDriver() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        page = browser.newPage(
                new Browser.NewPageOptions()
                        .setViewportSize(null)
        );

        page.navigate(url);
    }

    public void quitDriver() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    /** General */
    public String getCurrentURL() {
        return page.url().toLowerCase();
    }

    public void sleep(int time) {
        page.waitForTimeout(time);
    }

    /** Debugging: סימון אלמנט באדום */
    public void markOverlapElement(Locator locator) {
        locator.evaluate("el => el.style.border='3px solid red'");
    }

    /** Switch Tab: ב-Playwright עוברים בין דפים (Pages) בקלות */
    public Page switchTab(int tabID) {
        List<Page> pages = context.pages();
        Page targetPage = pages.get(tabID);
        targetPage.bringToFront();
        return targetPage;
    }


    /** Close Tab: סוגר את הטאב הנוכחי בדפדפן */
    public void closeTab(Page page) {
        page.close();
    }

    /** Visibility Wait: בדר"כ מיותר ב-Playwright כי הפעולות מחכות לבד */
    public void waitVisibility(String selector, int timeoutMs) {
        page.waitForSelector(selector, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(timeoutMs));
    }

    /** Screenshots */
    private void screenShot(String folder, String name) {
        Path path = Paths.get("src/ExtFiles/screenShots", folder, name + ".png");
        try {
            Files.createDirectories(path.getParent());
            page.screenshot(new Page.ScreenshotOptions().setPath(path));
        } catch (IOException e) {
            System.err.println("Screenshot failed: " + e.getMessage());
        }
    }

    public void fullPageScreenshot(String folder, String name) {
        Path path = Paths.get("src/ExtFiles/fullScreenshots", folder, name + "_FULL.png");
        try {
            Files.createDirectories(path.getParent());
            // Playwright עושה זאת בצעד אחד בלי לשנות גודל חלון ידנית!
            page.screenshot(new Page.ScreenshotOptions().setPath(path).setFullPage(true));
        } catch (IOException e) {
            System.err.println("Full page screenshot failed: " + e.getMessage());
        }
    }

    /** Actions */
    public void scrollUntilVisible(Locator locator) {
        // Playwright גולל אוטומטית לפני לחיצה, אבל אם רוצים גלילה מפורשת:
        locator.scrollIntoViewIfNeeded();
    }

    public void hoverElement(Locator locator) {
        locator.hover();
    }

    public void clickElement(Locator locator) {
        locator.click();
    }

    /** Allure Logs */
    public void allure_Log(String message) {
        String timestamp = LocalTime.now().withNano(0).toString();
        Allure.step("[" + timestamp + "] " + message);
    }

    public void allure_LogAttachment(String info, String folder, String name) {
        screenShot(folder, name);
        byte[] screenshot = page.screenshot();
        Allure.addAttachment(info, new ByteArrayInputStream(screenshot));
    }

    public static void allure_FailLog(String message) {
        Allure.step(message, Status.FAILED);
    }

    public void closePopupIfExists() {
        try {
            // בדיקה מהירה על העמוד הראשי קודם
            String combinedSelector = "button[id*='cookie-accept'], .close, #dismiss-button, .fancybox-close";
            Locator popup = page.locator(combinedSelector).first();
            if (popup.isVisible()) {
                popup.click();
                System.out.println("Popup/Cookie closed");
            }

            // טיפול בפרסומות גוגל - רק אם יש צורך
            for (Frame frame : page.frames()) {
                try {
                    Locator dismissBtn = frame.locator("#dismiss-button");
                    // הוספת timeout קצר מאוד כדי לא לתקוע את הטסט
                    if (dismissBtn.isVisible()) {
                        dismissBtn.click();
                        System.out.println("Ad closed inside iframe");
                    }
                } catch (Exception e) {
                    // מתעלמים משגיאות בתוך פריימים של פרסומות
                }
            }
        } catch (Exception e) {
            System.out.println("Navigation/Page issue during popup check: " + e.getMessage());
        }
    }

    public static String randStr(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}