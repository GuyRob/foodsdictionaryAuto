package il.guyrob.foodsdictionary.Pages;

import il.guyrob.foodsdictionary.Pages.DifferentProductPages.DownloadAppProductPage;
import il.guyrob.foodsdictionary.Pages.DifferentProductPages.ArticleProductPage;
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
    private final String hotTopics = "//a[@href=\"/channel/\"]//h3[contains(text(), 'נושאים חמים')]";
    public By btn_hotTopics = By.xpath(hotTopics);
    By btn_hotTopics_next = By.xpath(hotTopics + "/following::span[@class='horz-prev-icon']");
    By list_hotTopics = By.xpath(hotTopics + "/following::div[@class = 'd-flex'][1]//a");
    public By btn_mobileAppSection = By.xpath("//div[@class='col-12']//a[@href=\"/mobile-app/foods/\"]");



    // functions
    public RecipeProductPage mainBanner_click() {
        driver.findElement(img_banner).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new RecipeProductPage();
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


    public RecipeProductPage subBanner_click(List<WebElement> availableProducts, int subBannerProduct) {
        availableProducts.get(subBannerProduct).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new RecipeProductPage();
    }

    public List<WebElement> hotTopics_next() {
        driver.findElement(btn_hotTopics_next).click();
        sleep(2);

        List<WebElement> availableProducts = new ArrayList<>(); // Initialize the list

        for (WebElement e : driver.findElements(list_hotTopics)) {
            if (e.isDisplayed()) {
                availableProducts.add(e); // Add displayed elements to the list
            }
        }
        return availableProducts;
    }

    public ArticleProductPage hotTopics_click(List<WebElement> availableProducts, int hotTopicProduct) {
        availableProducts.get(hotTopicProduct).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new ArticleProductPage();
    }

    public DownloadAppProductPage clickAppDownload() {
        scroll_Element(btn_mobileAppSection);
        driver.findElement(btn_mobileAppSection).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new DownloadAppProductPage();
    }
}
