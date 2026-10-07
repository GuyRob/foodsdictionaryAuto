package il.guyrob.foodsdictionary.Selenium.Pages;

import il.guyrob.foodsdictionary.Selenium.SelenBase;
import org.openqa.selenium.By;

public class SeleRecipeProductPage extends SelenBase {
    // locators
    By list_breadcrumb = By.id("breadcrumb");
    public By list_actions = By.xpath("//div[@class = 'fd-top-tools d-print-none']//a");
    public By list_groceries = By.xpath("//ul[@class='list-group']");
    public By list_nutrtionalValue = By.xpath("//div[@id='fdChart']//span");


    By btn_author = By.xpath("//p[@class = 'fd-info']");
    By txt_header = By.id("pageHeader");
    By img_Product = By.xpath("//div[@class = 'item__third']//img");

    public boolean isBreadcrumbAppears() {
        return driver.findElement(list_breadcrumb).isDisplayed();
    }


    public boolean isGroceriesAppears() {
        return driver.findElement(list_groceries).isDisplayed();
    }

    public String getGroceries() {
        scroll_By(list_groceries);
        return "to string: " + driver.findElement(list_groceries).toString() + " getText: " + driver.findElement(list_groceries).getText() ;
    }

    public String getNutritionalValue() {
        scroll_By(list_nutrtionalValue);
        return "to string: " + driver.findElement(list_nutrtionalValue).toString() + " getText: " + driver.findElement(list_nutrtionalValue).getText() ;
    }
}
