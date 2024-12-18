package il.guyrob.foodsdictionary.Pages;

import il.guyrob.foodsdictionary.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage extends base {
    // locators
    By img_banner = By.xpath("//div[@class='col-12 col-full']//a"); //remove from start: div[@class='row']
    public By btn_subBanner_next = By.xpath("//div[@class = 'col-12-horz']//a[@class='horz-prev']");
    By list_subBanners = By.xpath("(//div[@class = 'col-12-horz']//div[@class = 'd-flex'])[1]//a");


    // functions
    public ProductPage mainBanner_click() {
        driver.findElement(img_banner).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        return new ProductPage();
    }


    public List<WebElement> subBanner_next() {
        driver.findElement(btn_subBanner_next).click();
        sleep(2);

        List<WebElement> availableProducts = new ArrayList<>(); // Initialize the list

        for (WebElement e : driver.findElements(list_subBanners)) {
            if (e.isDisplayed()) {
                availableProducts.add(e); // Add displayed elements to the list
            }
        }
        return availableProducts;
    }


    public ProductPage subBanner_click(List<WebElement> availableProducts, int subBannerProduct) {
        availableProducts.get(subBannerProduct).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        return new ProductPage();
    }
}
