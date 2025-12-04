package P2_E2E;

import il.guyrob.foodsdictionary.Pages.CategoryPage;
import il.guyrob.foodsdictionary.Pages.HomePage;
import il.guyrob.foodsdictionary.Pages.SearchPage;
import il.guyrob.foodsdictionary.base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P1EthnicFoodsCategoryTest extends base {
    HomePage homepage;
    SearchPage searchPage;
    CategoryPage categoryPage;

    // Data
    String recipeCategoryItem = "מאכלי עדות";
    String ethnicCategoryTitle = "מתכונים ואוכל לפי מטבחים";


    @BeforeMethod
    public void before() {
        allure_Log("Loading driver...");
        initialDriver();
        allure_Log("Loading homepage...");
        homepage = new HomePage();
        allure_LogAttachment("Before Test", "HomePage\\P1", "before");
    }

    @AfterMethod
    public void after() {
        allure_Log("Closing driver");
        quitDriver();
    }

    @Test
    public void P1_openRecipesSection(){
        allure_Log("Clicking recipes button");
        homepage.recipesOpenMenu();
        allure_LogAttachment("Recipe Menu is open", "HomePage\\P1", "P1_recipeMenu");
        allure_Log("Clicking " + recipeCategoryItem + " item");
        categoryPage = homepage.recipesMenuSelect(recipeCategoryItem);
        allure_LogAttachment("Recipe search page is displayed", "HomePage\\P1", "P1_recipeSearchPage");

        Assert.assertTrue(categoryPage.isTitleEquals(ethnicCategoryTitle), "ERROR: Not showing the recipes search page of " + recipeCategoryItem);
    }



}
