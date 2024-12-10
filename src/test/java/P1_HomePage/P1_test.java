package P1_HomePage;

import il.guyrob.foodsdictionary.ProductPages.HomePage;
import il.guyrob.foodsdictionary.base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P1_test extends base {

    HomePage homepage;

    // Data

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        homepage = new HomePage();

        driver.manage().window().maximize();
        driver.get("https://www.foodsdictionary.co.il/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sleep(1000);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void P1_trendingCategories(){
        // BUG - LA-5
        allure_Log("Enter");

        screenShot("HomePage\\P1", "P1_trendingCategories"); // TODO fix screenshot issue on this class
        allure_LogAttachment("Showing Top Trending Category Page", "HomePage\\P1", "P1_trendingCategories");

        boolean isUrlChanged = !(getCurrentURL()).equals("https://www.foodsdictionary.co.il/Recipes/12437");
        if (isUrlChanged){
            driver.navigate().back();
        }

        allure_Log("TEST: Index display and navigated to trending category successfully");
        Assert.assertTrue( isUrlChanged, "ERROR: Selecting index or top category failed");
    }

}
