package il.guyrob.foodsdictionary.Playwright.Pages;

import com.microsoft.playwright.Page;
import il.guyrob.foodsdictionary.Playwright.base;

public class RecipeProductPage extends base {

    // Selectors
    private final String list_breadcrumb = "#breadcrumb";
    private final String list_actions = "//div[@class = 'fd-top-tools d-print-none']//a";
    private final String list_groceries = "//h3[normalize-space()='רכיבים']/following-sibling::p | //ul[@class='list-group']";
    private final String list_nutrtionalValue = "//div[@class='col-12']//table";

    private final String btn_author = "//p[@class = 'fd-info']";
    private final String txt_header = "#pageHeader";
    private final String img_Product = "//div[@class = 'item__third']//img";

    /**
     * Constructor
     */
    public RecipeProductPage(Page page) {
        this.page = page;
    }

    // --- Functions ---

    public boolean isBreadcrumbAppears() {
        // מחכה שהאלמנט יהיה גלוי (Visible)
        return page.locator(list_breadcrumb).isVisible();
    }

    public boolean isGroceriesAppears() {
        return page.locator(list_groceries).count() > 0;
    }

    public String getGroceries() {
        // גלילה אוטומטית במידת הצורך
        page.locator(list_groceries).scrollIntoViewIfNeeded();

        // ב-Playwright toString() על לוקייטור מחזיר את הסלקטור עצמו,
        // בדרך כלל נרצה רק את ה-innerText או allInnerTexts אם יש כמה פריטים
        String text = page.locator(list_groceries).innerText();
        return "Selector: " + list_groceries + " | getText: " + text;
    }

    public String getNutritionalValue() {
        page.locator(list_nutrtionalValue).scrollIntoViewIfNeeded();

        // אם מדובר בכמה אלמנטים (כמו שמות התבלינים או הערכים),
        // Playwright מאפשר לקבל רשימת טקסטים בקלות:
        String text = page.locator(list_nutrtionalValue).innerText();
        return "Nutritional values: " + text;
    }

    /**
     * פונקציה להשגת שם הכותב/מחבר המתכון
     */
    public String getAuthorName() {
        return page.locator(btn_author).innerText();
    }
}