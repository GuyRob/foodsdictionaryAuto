package P1_SanityHomePage;

import il.guyrob.foodsdictionary.Pages.HomePage;
import il.guyrob.foodsdictionary.Pages.CategoryPage;
import il.guyrob.foodsdictionary.Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import il.guyrob.foodsdictionary.base;

public class P2_searchRice extends base{
    HomePage homepage;
    SearchPage searchPage;
    CategoryPage categoryPage;

    // Data
    String searchRiceStr = "אורז";

    @BeforeMethod
    public void before() {
        allure_Log("Loading driver");
        initialDriver();
        allure_Log("Loading homepage");
        homepage = new HomePage();
        allure_LogAttachment("Before Test", "HomePage\\P2", "before");
    }

    @AfterMethod
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
