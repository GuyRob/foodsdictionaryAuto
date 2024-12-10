package il.guyrob.foodsdictionary.Pages;

import il.guyrob.foodsdictionary.base;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class HomePage extends base {
    // locators
    By img_banner = By.xpath("//div[@class='row']//div[@class='col-12 col-full']//a");


    public ProductPage clickBanner() {
        driver.findElement(img_banner).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        return new ProductPage();
    }
}
