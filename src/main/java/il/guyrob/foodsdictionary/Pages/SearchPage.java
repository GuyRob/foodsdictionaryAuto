package il.guyrob.foodsdictionary.Pages;

import il.guyrob.foodsdictionary.base;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class SearchPage extends base {
    // locators
    By page_search = By.id("searchDiv");
    By inp_searchbar = By.xpath("//form[@id='searchForm']//input[@type='search']");
    By btn_searchbar = By.xpath("//form[@id='searchForm']//button[@type='submit']//i");

    public boolean isSearchPageAppears() {
        return driver.findElement(page_search).isDisplayed();
    }

    public void txtSearch(String searchStr) {
        driver.findElement(inp_searchbar).sendKeys(searchStr);
    }

    public ResultsPage submitSearch() {
        driver.findElement(btn_searchbar).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new ResultsPage();
    }
}
