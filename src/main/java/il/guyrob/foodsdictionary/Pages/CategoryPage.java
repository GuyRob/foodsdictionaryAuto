package il.guyrob.foodsdictionary.Pages;

import il.guyrob.foodsdictionary.base;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class CategoryPage extends base {
    // locators
    By title = By.xpath("//div[@id='pageHeader']//h1");


    // @TODO in progress
    public boolean isTitleEquals(String ethnicCategoryTitle) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(title).getText().equalsIgnoreCase(ethnicCategoryTitle);
    }
}
