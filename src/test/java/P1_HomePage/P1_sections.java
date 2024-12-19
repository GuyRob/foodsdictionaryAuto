package P1_HomePage;

import il.guyrob.foodsdictionary.Pages.DifferentProductPages.DownloadAppProductPage;
import il.guyrob.foodsdictionary.Pages.DifferentProductPages.ArticleProductPage;
import il.guyrob.foodsdictionary.Pages.HomePage;
import il.guyrob.foodsdictionary.Pages.RecipeProductPage;
import il.guyrob.foodsdictionary.base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class P1_sections extends base {

    HomePage homepage;

    // Data
    int subBannerProduct = 2;
    int hotTopicProduct = 1;

    String googlePlayURL = "play.google";
    String googlePlayName = "foodsdictionary";

    @BeforeMethod
    public void before() {
        initialDriver();
        allure_Log("Loading homepage");
        homepage = new HomePage();
        allure_LogAttachment("Before Test", "HomePage\\P1", "before");
    }

    @AfterMethod
    public void after() {
        allure_Log("Closing driver");
        quitDriver();
    }

    @Test
    public void P1_banner() {
        allure_Log("Clicking main banner");
        RecipeProductPage productPage = homepage.mainBanner_click();
        allure_Log("Scrolling down to title");
        scroll_Element(productPage.list_actions);
        allure_LogAttachment("Banner", "HomePage\\P1", "P1_banner");
        Assert.assertTrue(productPage.isBreadcrumbAppears(), "ERROR: Not showing the banner product page");
    }

    @Test
    public void P2_subBannerProducts() {
        allure_Log("Scrolling to sub banners");
        homepage.scroll_Element(homepage.btn_subBanner_next);
        allure_Log("On sub banners clicking next button");
        homepage.subBanner_next();
        List<WebElement> availableFoods =  homepage.subBanner_next();
        allure_LogAttachment("Sub Banner Clicked Next Button", "HomePage\\P1", "P2_subBannerProducts_nextBtn");
        allure_Log("Clicking on "+ subBannerProduct +" sub banner food");
        RecipeProductPage productPage = homepage.subBanner_click(availableFoods , subBannerProduct);
        allure_Log("Scrolling down to title");
        scroll_Element(productPage.list_actions);
        allure_LogAttachment("Sub Banner Selected Product", "HomePage\\P1", "P2_subBannerProducts_product");
        Assert.assertTrue(productPage.isBreadcrumbAppears(), "ERROR: Not showing the sub banner product page");
    }

    @Test
    public void P3_hotTopics() {
        allure_Log("Scrolling to hot topics");
        homepage.scroll_Element(homepage.btn_hotTopics);
        allure_Log("On hot topics clicking next button");
        List<WebElement> availableArticles = homepage.hotTopics_next();
        allure_LogAttachment("Hot Topics Clicked Next Button", "HomePage\\P1", "P3_hotTopics_nextBtn");
        allure_Log("Clicking on "+ hotTopicProduct +" topic");
        ArticleProductPage articleProductPage = homepage.hotTopics_click(availableArticles, hotTopicProduct);
        allure_Log("Scrolling down to title");
        scroll_Element(articleProductPage.list_actions);
        allure_LogAttachment("Hot Topic Selected Product", "HomePage\\P1", "P3_hotTopics_article");
        String actualURL = getCurrentURL();
        Assert.assertTrue(actualURL.contains("articles"), "ERROR: Not Showing An Article! (Topic)");
    }

    @Test
    public void P4_appDownload(){
        allure_Log("Scrolling to mobile app download and clicking on it");
        DownloadAppProductPage downloadAppProductPage = homepage.clickAppDownload();
        allure_LogAttachment("App Download Page", "HomePage\\P1", "P4_appDownload");
        downloadAppProductPage.clickDownloadAndroid();
        allure_LogAttachment("Google Play Store - Foods Download Page", "HomePage\\P1", "P4_appDownload_googlePlay");
        Assert.assertTrue(getCurrentURL().contains(googlePlayURL) && getCurrentURL().contains(googlePlayName), "ERROR: Not Showing The Correct Google Play Page");
    }

    public void P5_books(){

    }

}
