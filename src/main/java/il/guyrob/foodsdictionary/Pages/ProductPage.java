package il.guyrob.foodsdictionary.Pages;

import il.guyrob.foodsdictionary.base;
import org.openqa.selenium.By;

public class ProductPage extends base {
    By list_breadcrumb = By.id("breadcrumb");

    public boolean isBreadcrumbAppears() {
        return driver.findElement(list_breadcrumb).isDisplayed();
    }


}
