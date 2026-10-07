package il.guyrob.foodsdictionary.Playwright.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import il.guyrob.foodsdictionary.Playwright.base;

public class ExternalPages extends base {

    private final String text_InstagramUserName =
            "//h2[@dir='auto']";

    private final String text_FacebookUserName =
            "//span[@dir='auto']//h1";

    private final String btn_InstagramCloseRegister =
            "svg[aria-label='Close']";


    /**
     * Constructor
     */
    public ExternalPages(Page page) {
        this.page = page;
    }


    // --- Functions ---

    // Instagram
    public String Instagram_getUserName() {
        return page.locator(text_InstagramUserName).innerText();
    }

    /** Close Popup: סוגר את חלון ה-Popup באמצעות כפתור Close */
    public void Instagram_closeRegisterPopup() {

        Locator closeButton = page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Close")
        );

        closeButton.waitFor();

        closeButton.click(
                new Locator.ClickOptions()
                        .setForce(true)
        );
    }

    /** Close Tab: סוגר את הטאב הנוכחי וחוזר ל-HomePage */
    public HomePage closeTab() {
        page.close();

        for (Page openPage : page.context().pages()) {
            if (openPage.url().contains("foodsdictionary.co.il")) {
                return new HomePage(openPage);
            }
        }

        throw new RuntimeException("Homepage tab was not found!");
    }

    /** Back: חוזר לעמוד הקודם באמצעות כפתור Back של הדפדפן */
    public HomePage goBack() {
        page.goBack();
        return new HomePage(page);
    }


    public void Facebook_closeRegisterPopup() {
        Locator closeButton = page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Close")
        );

        closeButton.waitFor();

        closeButton.click(
                new Locator.ClickOptions()
                        .setForce(true)
        );

        // //div[@role='button' and @aria-label='Close']
    }

    public String Facebook_getUserName() {
        return page.locator(text_FacebookUserName).innerText().strip();
    }
}