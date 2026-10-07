import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import il.guyrob.foodsdictionary.Playwright.base;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example extends base {
    @Test
    public void example(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            page.getByLabel("המצרכים של המתכון").click();
            page.getByLabel("המצרכים של המתכון").fill("אורז\nחזה עוף");
            page.getByTitle("סגור").nth(2).click();
            page.getByLabel("המצרכים של המתכון").click();
            page.getByLabel("המצרכים של המתכון").fill("אורז\nחזה עוף\nבצל\nרוטב סויה");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ניתוח מתכון")).click();
            page.getByText("תוצאת ניתוח סימון תזונתילכל המתכוןל-100 גרםקלוריות (אנרגיה)1,042145").click();
        }
    }
}