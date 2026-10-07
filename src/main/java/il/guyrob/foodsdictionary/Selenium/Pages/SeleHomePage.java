package il.guyrob.foodsdictionary.Selenium.Pages;

import il.guyrob.foodsdictionary.Selenium.Pages.DifferentProductPages.BooksListProductPage;
import il.guyrob.foodsdictionary.Selenium.Pages.DifferentProductPages.DownloadAppProductPage;
import il.guyrob.foodsdictionary.Selenium.Pages.DifferentProductPages.ArticleProductPage;
import il.guyrob.foodsdictionary.Selenium.SelenBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleHomePage extends SelenBase {
    // locators
    By img_banner = By.xpath("//div[@class='col-12 col-full']//a");
    public By btn_subBanner_next = By.xpath("//div[@class = 'col-12-horz']//a[@class='horz-prev']");
    By list_subBanners = By.xpath("(//div[@class = 'col-12-horz']//div[@class = 'd-flex'])[1]//a");
    private final String hotTopics = "//a[@href=\"/channel/\"]//h3[contains(text(), 'נושאים חמים')]";
    public By btn_hotTopics = By.xpath(hotTopics);
    By btn_hotTopics_next = By.xpath(hotTopics + "/following::span[@class='horz-prev-icon']");
    By list_hotTopics = By.xpath(hotTopics + "/following::div[@class = 'd-flex'][1]//a");
    public By btn_mobileAppSection = By.xpath("//div[@class='col-12']//a[@href=\"/mobile-app/foods/\"]");
    public By btn_books = By.xpath("//div[@class='col-12']//a[@href=\"/Recipes/Books/\"]//h3");

    public String btn_search2 = "//a[@class='nav-link-search']";
    public By btn_search = By.xpath("//div[@class='collapse navbar-collapse navbar-search']//a | " + btn_search2);
    public By btn_recipesMenu = By.xpath("//a[@id='navbarCategories']");
    public By list_recipesMenu = By.xpath("//div[@aria-labelledby='navbarCategories']//a");

    // functions
    public SeleSearchPage searchbar_click() {
        driver.findElement(btn_search).click();
        return new SeleSearchPage();
    }

//    public void recipesOpenMenu(){
//        clickElement(driver.findElement(btn_recipesMenu));
//    }

    public SeleCategoryPage recipesMenuSelect(String byText){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> elements = driver.findElements(list_recipesMenu);
        for (WebElement el : elements){
//             @DEBUG System.out.println(el.getText());
            if (el.getText().equalsIgnoreCase(byText)) {
                scrollUntilVisible(el);
                clickElement(el);
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new SeleCategoryPage();
    }

    public SeleRecipeProductPage mainBanner_click() {
        driver.findElement(img_banner).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new SeleRecipeProductPage();
    }

    public List<WebElement> subBanner_next() {
        driver.findElement(btn_subBanner_next).click();
        sleep(2);

        List<WebElement> availableProducts = new ArrayList<>();
        for (WebElement e : driver.findElements(list_subBanners)) {
            if (e.isDisplayed()) {
                availableProducts.add(e);
            }
        }
        return availableProducts;
    }

    public SeleRecipeProductPage subBanner_click(List<WebElement> availableProducts, int subBannerProduct) {
        availableProducts.get(subBannerProduct).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new SeleRecipeProductPage();
    }

    public List<WebElement> hotTopics_next() {
        driver.findElement(btn_hotTopics_next).click();
        sleep(2);

        List<WebElement> availableProducts = new ArrayList<>();
        for (WebElement e : driver.findElements(list_hotTopics)) {
            if (e.isDisplayed()) {
                availableProducts.add(e);
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
        scroll_By(btn_mobileAppSection);
        closePopupIfExists();
        driver.findElement(btn_mobileAppSection).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new DownloadAppProductPage();
    }

    public BooksListProductPage clickBooks() {
        driver.findElement(btn_books).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new BooksListProductPage();
    }
}
