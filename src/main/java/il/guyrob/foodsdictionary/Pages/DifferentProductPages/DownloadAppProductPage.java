package il.guyrob.foodsdictionary.Pages.DifferentProductPages;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class DownloadAppProductPage extends RecipeProductPage {

    By btn_androidDownload = By.xpath("//div[@class='col-6']//a[contains(@href, 'play.google')]");

    public void clickDownloadAndroid() {
        scroll_Element(btn_androidDownload);
//        clickElement(btn_androidDownload);
        driver.findElement(btn_androidDownload).click();
        switchTab(1);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }
}
