package il.guyrob.foodsdictionary.Selenium.Pages.DifferentProductPages;

import il.guyrob.foodsdictionary.Selenium.Pages.SeleRecipeProductPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class DownloadAppProductPage extends SeleRecipeProductPage {

    By btn_androidDownload = By.xpath("//div[@class='col-6']//a[contains(@href, 'play.google')]");

    public void clickDownloadAndroid() {
        scroll_By(btn_androidDownload);
//        clickElement(btn_androidDownload);
        driver.findElement(btn_androidDownload).click();
        switchTab(1);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }
}
