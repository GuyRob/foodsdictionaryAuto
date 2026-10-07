package il.guyrob.foodsdictionary.Selenium.Pages;

import il.guyrob.foodsdictionary.Selenium.SelenBase;

public class SeleCategoryPage extends SelenBase {
//    // locators
//    By title = By.xpath("//div[@id='pageHeader']//h1");
//    public By list_recipesItems = By.xpath("//h4[@class='card-title']");
//

//
//    // @TODO in progress
//    public boolean isTitleEquals(String ethnicCategoryTitle) {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        return driver.findElement(title).getText().equalsIgnoreCase(ethnicCategoryTitle);
//    }
//
//    public SeleCategoryPage selectEthnicFood_ByName(String ethnicItem) {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        List<WebElement> elements = driver.findElements(list_recipesItems);
//        for (WebElement el : elements) {
//            System.out.println(el.getText());
//            if (el.getText().equalsIgnoreCase(ethnicItem)) {
//                scrollUntilVisible(el);
//                allure_Log("Checking if popup appears");
//                scroll_Element(el);
//                closePopupIfExists();
//                clickElement(el);
//                el.click();
//                break;
//            }
//        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        return new SeleCategoryPage();
//    }
//
//    public SeleRecipeProductPage selectEthnicFood_ByIndex(int i) {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        List<WebElement> elements = driver.findElements(list_recipesItems);
//
//        // בדיקה שאין חריגה מהאינדקס
//        if (i < 0 || i >= elements.size()) {
//            throw new IndexOutOfBoundsException(
//                    "ERROR: Index " + i + " is out of bounds. Total items: " + elements.size()
//            );
//        }
//
//        WebElement el = elements.get(i);
//
//        System.out.println("Selecting by index: " + i + " → " + el.getText());
//        scroll_Element(el);
//        allure_Log("Checking if popup appears");
//        closePopupIfExists();
//        clickElement(el);
//        return new SeleRecipeProductPage();
//    }

}
