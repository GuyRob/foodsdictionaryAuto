package P2_E2E;

import il.guyrob.foodsdictionary.Playwright.Pages.CategoryPage;
import il.guyrob.foodsdictionary.Playwright.Pages.HomePage;
import il.guyrob.foodsdictionary.Playwright.Pages.SearchAllPage;
import il.guyrob.foodsdictionary.Playwright.Pages.SearchPopPage;
import il.guyrob.foodsdictionary.Playwright.base;
import il.guyrob.foodsdictionary.Playwright.Pages.RecipeProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class P3_PeaSoupCalorieTest extends base {
    // Pages
    HomePage homePage;
    SearchPopPage searchPopPage;
    SearchAllPage searchAllPage;
    CategoryPage categoryPage;
    RecipeProductPage recipeProductPage;


    // Data
    String PeaSoupText = "מרק אפונה";
    int lessCalorieItem = 1;


    @BeforeClass
    public void before() {
        allure_Log("Loading driver...");
        initialDriver(); // כאן ה-page מאותחל בתוך מחלקת הבסיס
        homePage = new HomePage(page);
        allure_LogAttachment("Before Test", "E2E\\P3", "before");
    }

    @AfterClass
    public void after() {
        allure_Log("Closing driver");
        quitDriver();
    }

    @Test
    public void P1_clickOnSearch(){
        allure_Log("Clicking popups");
        homePage.closePopupIfExists();
        allure_Log("Clicking search button");
        searchPopPage = homePage.searchbar_click();
        Assert.assertTrue(searchPopPage.isSearchPageAppears());

    }

    @Test
    public void P2_searchingItem() {
        allure_Log("Entering search: " + PeaSoupText);
        searchPopPage.txtSearch(PeaSoupText);
        allure_LogAttachment("Searched results", "E2E\\P3", "P2_searchingItem");
        allure_Log("Clicking on search button");
        searchAllPage = searchPopPage.submitSearch();
        String actualSearchedResult = searchAllPage.getSearchInputValue();
        closePopupIfExists();
        Assert.assertEquals(PeaSoupText, actualSearchedResult, "ERROR: Searched text is not matched to searchbox text!");
    }

    @Test
    public void P3_showMoreItems() {
        allure_Log("Selecting show more button");
        Assert.assertFalse(searchAllPage.clickShowMoreProducts()); // Should not be the same match
    }

    @Test
    public void P4_filterByCalories() {
        allure_Log("Filtering by calories");
        searchAllPage.filterBy_Calories();
        allure_LogAttachment("Products filtered by calories", "E2E\\P3", "P4_filterByCalories");
    }

    @Test
    public void P5_selectItem_LessCalorie(){
        allure_Log("Clicking on " + lessCalorieItem + " item");
        recipeProductPage = searchAllPage.selectItem_ByIndex(lessCalorieItem);
        closePopupIfExists();
        allure_LogAttachment("Less calorie item page appears", "E2E\\P3", "P5_selectItem_LessCalorie");
        Assert.assertTrue(recipeProductPage.isGroceriesAppears(), "ERROR: Not showing the recipe product page");
    }

    @Test
    public void P6_getNutritionalvalue(){
        allure_Log("Getting nutritional value list items: ");
        String nuritionalvalue;
        allure_Log(nuritionalvalue = recipeProductPage.getNutritionalValue());
        System.out.println(nuritionalvalue);
        closePopupIfExists();
        allure_LogAttachment("less calories item nutritional value", "E2E\\P3", "P6_getNutritionalvalue");
        Assert.assertTrue(nuritionalvalue.length()>1);
    }

}
