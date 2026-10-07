package il.guyrob.foodsdictionary.Selenium.Pages;

import il.guyrob.foodsdictionary.Selenium.SelenBase;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class SeleSearchPage extends SelenBase {
    // locators
    By page_search = By.id("searchDiv");
    By inp_searchbar = By.xpath("//form[@id='searchForm']//input[@type='search']");
    By btn_searchbar = By.xpath("//form[@id='searchForm']//button[@type='submit']//i");

    public boolean isSearchPageAppears() {
        return driver.findElement(page_search).isDisplayed();
    }

    public void txtSearch(String searchStr) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        scroll_By(inp_searchbar);
        driver.findElement(inp_searchbar).sendKeys(searchStr);
    }

    public SeleCategoryPage submitSearch() {
        driver.findElement(btn_searchbar).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new SeleCategoryPage();
    }
}
