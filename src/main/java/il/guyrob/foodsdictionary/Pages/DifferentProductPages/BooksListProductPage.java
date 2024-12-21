package il.guyrob.foodsdictionary.Pages.DifferentProductPages;

import il.guyrob.foodsdictionary.Pages.RecipeProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BooksListProductPage extends RecipeProductPage {
    public By list_books = By.xpath("//div[@class=\"col-4\"]");

    public BookProductPage selectByName(String bookName) { // @TODO check if working
        List<WebElement> books = driver.findElements(list_books);
        for (WebElement e : books){
            if (e.findElement(By.xpath("//img[contains(@alt, '" + bookName + "')]")).isDisplayed()){
                e.click();
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            }
        }
        return new BookProductPage();
    }
}
