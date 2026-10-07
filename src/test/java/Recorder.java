import com.microsoft.playwright.*;

public class Recorder {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)); // חייב להיות false כדי לראות את הדפדפן
            Page page = browser.newPage();
            page.navigate("https://www.foodsdictionary.co.il/");

            // השורה הזו פותחת את ה-Inspector ואת הדפדפן להקלטה
            page.pause();




        }
    }


}