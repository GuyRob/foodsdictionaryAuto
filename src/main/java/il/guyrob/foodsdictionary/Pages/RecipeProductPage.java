package il.guyrob.foodsdictionary.Pages;

import il.guyrob.foodsdictionary.base;
import org.openqa.selenium.By;

public class RecipeProductPage extends base {
    By list_breadcrumb = By.id("breadcrumb");
    public By list_actions = By.xpath("//div[@class = 'fd-top-tools d-print-none']//a");

    By btn_author = By.xpath("//p[@class = 'fd-info']");
    By txt_header = By.id("pageHeader");
    By img_Product = By.xpath("//div[@class = 'item__third']//img");

    public boolean isBreadcrumbAppears() {
        return driver.findElement(list_breadcrumb).isDisplayed();
    }


}
