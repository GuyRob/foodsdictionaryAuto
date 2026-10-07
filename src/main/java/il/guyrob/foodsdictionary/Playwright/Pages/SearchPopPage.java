package il.guyrob.foodsdictionary.Playwright.Pages;

import com.microsoft.playwright.Page;
import il.guyrob.foodsdictionary.Playwright.base;

/**
 * When clicking on search button this page pop on
 */
public class SearchPopPage extends base {

    // Selectors - מחליפים את ה-By ב-String פשוט
    private final String page_search = "#searchDiv";
    private final String inp_searchbar = "//form[@id='searchForm']//input[@type='search']";
    private final String btn_searchIcon = "//form[@id='searchForm']//button[@type='submit']";


    /**
     * Constructor
     * פותר את שגיאת ה-Default constructor. מקבל את ה-page מהדף הקודם.
     */
    public SearchPopPage(Page page) {
        this.page = page;
    }

    // --- Functions ---

    public boolean isSearchPageAppears() {
        // ב-Playwright isVisible() מחזיר בוליאני ולא זורק שגיאה אם האלמנט לא קיים לרגע
        return page.locator(page_search).isVisible();
    }

    public SearchAllPage submitSearch() {
        page.locator(btn_searchIcon).click();

        // אין צורך ב-implicitlyWait, ה-Page הבא יחכה לאלמנטים שלו אוטומטית
        return new SearchAllPage(page);
    }

    public void txtSearch(String searchStr) {
        // scrollIntoViewIfNeeded() מובנה בתוך ה-Locator
        page.locator(inp_searchbar).scrollIntoViewIfNeeded();
        // fill() עדיפה על sendKeys כי היא מנקה את השדה קודם
        page.locator(inp_searchbar).fill(searchStr);
    }


}