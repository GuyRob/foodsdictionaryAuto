package il.guyrob.foodsdictionary.Playwright.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import il.guyrob.foodsdictionary.Playwright.base;

public class CategoryPage extends base {

    // Locators
    private final String titleSelector = "//div[@id='pageHeader']//h1";
    private final String list_recipesItems = "//h4[@class='card-title']";
    private final String textbox_analyzeRecipes = "//textarea[@id='ingredients']";
    private final String inp_analyzeCalculate = "//input[@id='btnAnalyzer']";
    private final String btn_premiumClose = "//div[@class='sweet-alert showSweetAlert visible']//button[@class='cancel']";

    private final String table_analysisResult = "//table[@id='analyzerTableResult']";
    /**
     * Constructor
     */
    public CategoryPage(Page page) {
        this.page = page;
    }

    // --- Functions ---

    public boolean isTitleEquals(String ethnicCategoryTitle) {
        // Playwright מחכה אוטומטית שהאלמנט יופיע, אין צורך ב-implicitlyWait
        String actualTitle = page.locator(titleSelector).innerText().trim();
        return actualTitle.equalsIgnoreCase(ethnicCategoryTitle);
    }





    // --- More Functions ---



    // Ethnic

    public CategoryPage selectEthnicFood_ByName(String ethnicItem) {
        // איתור כל האלמנטים ברשימה
        Locator elements = page.locator(list_recipesItems);

        // מעבר על הרשימה ומציאת הטקסט המתאים
        int count = elements.count();
        for (int i = 0; i < count; i++) {
            Locator el = elements.nth(i);
            String text = el.innerText();
            System.out.println(text);

            if (text.equalsIgnoreCase(ethnicItem)) {
                el.scrollIntoViewIfNeeded();
                allure_Log("Checking if popup appears");

                closePopupIfExists(); // פונקציה מה-base

                // לחיצה ב-Playwright היא הרבה יותר יציבה
                el.click();
                break;
            }
        }
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return this; // מחזיר את הדף הנוכחי
    }

    public RecipeProductPage selectEthnicFood_ByIndex(int i) {
        Locator elements = page.locator(list_recipesItems);

        // בדיקה שהאינדקס תקין
        if (i < 0 || i >= elements.count()) {
            throw new IndexOutOfBoundsException(
                    "ERROR: Index " + i + " is out of bounds. Total items: " + elements.count()
            );
        }

        Locator el = elements.nth(i);
        System.out.println("Selecting by index: " + i + " → " + el.innerText());

        el.scrollIntoViewIfNeeded();
        allure_Log("Checking if popup appears");

        closePopupIfExists();
        el.click();

        // מעבר לדף המוצר (RecipeProductPage)
        return new RecipeProductPage(page);
    }

    // Analyzed Recipes (כלי באתר: מנתח המתכונים)
    public boolean anaylzedRecipes_getResults() {
        // הגדרת הלוקייטורים
        Locator premiumClose = page.locator(btn_premiumClose);
        Locator resultsContainer = page.locator(table_analysisResult); // בהנחה שזה Y

        try {
            // נמתין זמן קצר (למשל 5 שניות) כדי לראות מי מהם מופיע ראשון
            // אנחנו משתמשים ב- race condition או פשוט בודקים נוכחות

            // אפשרות ראשונה: הופיע חלון פרימיום (X)
            if (premiumClose.isVisible()) {
                System.out.println("Passed: No results since need premium");
                allure_Log("Passed: No results since need premium");
                premiumClose.click(); // אופציונלי: סגירת החלון כדי שלא יפריע להמשך
                return true;
            }

            // אפשרות שנייה: הופיעו תוצאות (Y)
            if (resultsContainer.isVisible()) {
                resultsContainer.scrollIntoViewIfNeeded();
                String content = resultsContainer.innerText();
                System.out.println("Passed: Results found. Content: " + content);
                allure_Log("Passed: Results found. Content: " + content);
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error: Neither Premium popup nor Results appeared.");
            allure_Log("Error: Neither Premium popup nor Results appeared.");
        }

        return false; // אם אף אחד מהם לא הופיע
    }

    public void analyzeRecipesCalculate_click() {
        Locator textbox = page.locator(inp_analyzeCalculate).first();
        textbox.scrollIntoViewIfNeeded();
        textbox.click();

    }

    public void analyzeRecipesTextbox_click(){
        Locator textbox = page.locator(textbox_analyzeRecipes).first();
        textbox.scrollIntoViewIfNeeded();
        textbox.click();
    }

    public void analyzeRecipesTextbox_fill(String analyzedProducts) {
        page.locator(textbox_analyzeRecipes).first().clear(); // חשוב כדי למנוע שרשור טקסט
        page.locator(textbox_analyzeRecipes).first().fill(analyzedProducts);
    }

    public String getText_analyzeRecipes() {
        return page.locator(textbox_analyzeRecipes).first().inputValue();
    }

}