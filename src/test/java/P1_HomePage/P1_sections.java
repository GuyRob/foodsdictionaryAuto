package P1_HomePage;

import il.guyrob.foodsdictionary.Pages.HomePage;
import il.guyrob.foodsdictionary.Pages.ProductPage;
import il.guyrob.foodsdictionary.base;
import org.testng.Assert;
import org.testng.annotations.*;

public class P1_sections extends base {

    HomePage homepage;

    // Data

    @BeforeMethod
    public void before(){
        initialDriver();
        allure_Log("Loading homepage");
        homepage = new HomePage();
        screenShot("HomePage\\P1", "before");
    }

    @AfterMethod
    public void after() {
        allure_Log("Closing driver");
        quitDriver();
    }

        @Test
    public void P1_banner(){
            allure_Log("Clicking main banner");
            ProductPage productPage = homepage.clickBanner();
            screenShot("HomePage\\P1", "P1_banner");
            Assert.assertTrue(productPage.isBreadcrumbAppears(), "ERROR: Not showing the banner product page");
        }

}
