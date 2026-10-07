package il.guyrob.foodsdictionary.Playwright.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import il.guyrob.foodsdictionary.Playwright.base;

/**
 * Searching in all types
 *  חיפוש באתר
 */
public class SearchAllPage extends base {

    /**
     * Constructor
     * פותר את שגיאת ה-Default constructor. מקבל את ה-page מהדף הקודם.
     */
    public SearchAllPage(Page page) {
        this.page = page;
    }

    /*public SearchAllPage(Page page) {
        super();
    }*/

    // Selectors - מחליפים את ה-By ב-String פשוט
    private final String list_Products = "//div[@class='media-body']//a";
    private final String inp_searchedResult = "//form[@id='searchFormMain']//input";
    private final String btn_showMoreProducts = "//a[contains(text(),'הצג מוצרים נוספים')]";
    private final String list_recipesItems = "//div[@class='row']//li[@class='media']//a";




    // Functions
    public boolean clickShowMoreProducts() {
        int resultAmountBefore =         page.locator(list_Products).count();
        page.locator(btn_showMoreProducts).click();
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("הצג מוצרים נוספים")).click();

        closePopupIfExists();
        closePopupIfExists(); // two popups appears
        System.out.println(resultAmountBefore);
        System.out.println(page.locator(list_Products).count());
        return resultAmountBefore ==       page.locator(list_Products).count();
    }


    public void filterBy_Calories() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("קלוריות").setExact(true)).click();
        closePopupIfExists();
    }

    public String getSearchInputValue() {
        return page.locator(inp_searchedResult).inputValue();
    }

    public RecipeProductPage selectItem_ByIndex(int i) {
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
}
