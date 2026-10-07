package P2_E2E;

import il.guyrob.foodsdictionary.Playwright.Pages.CategoryPage;
import il.guyrob.foodsdictionary.Playwright.Pages.HomePage;
import il.guyrob.foodsdictionary.Playwright.Pages.RecipeProductPage;
import il.guyrob.foodsdictionary.Playwright.base;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class P2_AnalysisRecipeItemsTest extends base {

    // Pages
    HomePage homePage;
    CategoryPage categoryPage;
    RecipeProductPage recipeProductPage;

    // Data
    String recipeCategoryItem = "מנתח המתכונים";
    String analysisRecipesCategoryTitle = "אנלייזר למתכון: ניתוח ערך תזונתי אוטומטי";
    String analyzedProducts = "אורז\nחזה עוף\nבצל\nרוטב סויה";



    @BeforeClass
    public void before() {
        allure_Log("Loading driver...");
        initialDriver(); // כאן ה-page מאותחל בתוך מחלקת הבסיס
        homePage = new HomePage(page);
        allure_LogAttachment("Before Test", "E2E\\P2", "before");
    }

    @AfterClass
    public void after() {
        allure_Log("Closing driver");
        quitDriver();
    }

    @Test
    public void P1_selectAnalysisRecipesCategory(){
        allure_Log("Clicking recipes button");
        homePage.recipesOpenMenu();
        allure_LogAttachment("Recipe Menu is open", "E2E\\P2", "P1_recipeMenu");
        allure_Log("Clicking " + recipeCategoryItem + " item");
        categoryPage = homePage.recipesMenuSelect(recipeCategoryItem);
        allure_LogAttachment("Analysis recipes is displayed", "E2E\\P2", "P1_recipeAnalysis");
        closePopupIfExists();
        Assert.assertTrue(categoryPage.isTitleEquals(analysisRecipesCategoryTitle), "ERROR: Not showing the recipes analysis page of " + recipeCategoryItem);
    }

    @Test
    public void P2_fillProducts(){
        allure_Log("Clicking analyze recipes textbox");
        categoryPage.analyzeRecipesTextbox_click();
        closePopupIfExists();
        allure_Log("Filling " + analyzedProducts + " items");
        categoryPage.analyzeRecipesTextbox_fill(analyzedProducts);
        allure_LogAttachment("Analysis recipes is displayed", "E2E\\P2", "P2_recipeAnalysisProducts");
        closePopupIfExists();
        String actual = categoryPage.getText_analyzeRecipes().trim().toLowerCase();
        String expected = analyzedProducts.trim().toLowerCase();
        Assert.assertTrue(actual.equals(expected), "ERROR: Products that entered and actual products list is not the same");
    }

    @Test
    public void P3_calculateProducts(){
        allure_Log("Clicking calculate button");
        categoryPage.analyzeRecipesCalculate_click();
//        page.pause();
        closePopupIfExists();
        allure_LogAttachment("Calculate Results", "E2E\\P2", "P2_calculateResult");
        Assert.assertTrue(categoryPage.anaylzedRecipes_getResults()); // Notice: Premium popup is also a valid result
    }

}
