package P1_HomePage;

import il.guyrob.foodsdictionary.Pages.HomePage;
import il.guyrob.foodsdictionary.Pages.ProductPage;
import il.guyrob.foodsdictionary.base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class P1_sections extends base {

    HomePage homepage;

    // Data
    int subBannerProduct = 2;

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
        ProductPage productPage = homepage.mainBanner_click();
        allure_Log("Scrolling down");
        scroll_Element(productPage.list_actions);
        sleep(1);
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
        ProductPage productPage = homepage.subBanner_click(availableFoods , subBannerProduct);
        allure_Log("Scrolling down");
        scroll_Element(productPage.list_actions);
        sleep(1);
        allure_LogAttachment("Sub Banner Selected Product", "HomePage\\P1", "P2_subBannerProducts_product");
        Assert.assertTrue(productPage.isBreadcrumbAppears(), "ERROR: Not showing the sub banner product page");
    }

    public void P3_hotTopics() {

    }

    public void P4_appDownload(){

    }

    public void P5_books(){

    }

}
