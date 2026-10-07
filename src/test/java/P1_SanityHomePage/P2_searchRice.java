package P1_SanityHomePage;

import il.guyrob.foodsdictionary.Selenium.Pages.SeleHomePage;
import il.guyrob.foodsdictionary.Selenium.Pages.SeleCategoryPage;
import il.guyrob.foodsdictionary.Selenium.Pages.SeleSearchPage;
import org.testng.Assert;
import org.testng.annotations.*;

import il.guyrob.foodsdictionary.Selenium.SelenBase;

public class P2_searchRice extends SelenBase {
    SeleHomePage homepage;
    SeleSearchPage searchPage;
    SeleCategoryPage categoryPage;

    // Data
    String searchRiceStr = "אורז";

    @BeforeClass
    public void before() {
        allure_Log("Loading driver");
        initialDriver();
        allure_Log("Loading homepage");
        homepage = new SeleHomePage();
        allure_LogAttachment("Before Test", "HomePage\\P2", "before");
    }

    @AfterClass
    public void after() {
        allure_Log("Closing driver");
        quitDriver();
    }

    @Test
    public void P1_clickOnSearch() {
        allure_Log("Clicking on search bar");
        searchPage = homepage.searchbar_click();
        Assert.assertTrue(searchPage.isSearchPageAppears());
    }

    @Test
    public void P2_searchingItem() {
        allure_Log("Entering search: " + searchRiceStr);
        searchPage.txtSearch(searchRiceStr);
        allure_LogAttachment("Search Page", "HomePage\\P2", "SearchPage");
        allure_Log("Clicking on search button");
        categoryPage = searchPage.submitSearch();

    }
}
