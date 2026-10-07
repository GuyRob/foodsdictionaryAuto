package P2_E2E;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import il.guyrob.foodsdictionary.Playwright.Pages.CategoryPage;
import il.guyrob.foodsdictionary.Playwright.Pages.HomePage;
import il.guyrob.foodsdictionary.Playwright.Pages.RecipeProductPage;
import il.guyrob.foodsdictionary.Playwright.base; // וודא שזה השם הנכון של המחלקה
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class P1_EthnicFoodsTest extends base {
    // Pages
    HomePage homePage;
    CategoryPage categoryPage;
    RecipeProductPage recipeProductPage;

    // Data
    String recipeCategoryItem = "מאכלי עדות";
    String ethnicCategoryTitle = "מתכונים ואוכל לפי מטבחים";
    String ethnicFoodIndian = "אוכל הודי";
    String ethnicFoodIndianTitle = "מתכונים הודים, אוכל הודי";
    int indianFoodIndex = 3;


    @BeforeClass
    public void before() {
        allure_Log("Loading driver...");
        initialDriver(); // כאן ה-page מאותחל בתוך מחלקת הבסיס
        homePage = new HomePage(page);
        allure_LogAttachment("Before Test", "E2E\\P1", "before");
    }

    @AfterClass
    public void after() {
        allure_Log("Closing driver");
        quitDriver();
    }

    @Test
    public void P1_selectEthnicFoods(){
        allure_Log("Clicking recipes button");
        homePage.recipesOpenMenu();
        allure_LogAttachment("Recipe Menu is open", "E2E\\P1", "P1_recipeMenu");
        allure_Log("Clicking " + recipeCategoryItem + " item");
        categoryPage = homePage.recipesMenuSelect(recipeCategoryItem);
        allure_LogAttachment("Recipe search page is displayed", "E2E\\P1", "P1_recipeSearchPage");
        closePopupIfExists();
        Assert.assertTrue(categoryPage.isTitleEquals(ethnicCategoryTitle), "ERROR: Not showing the recipes search page of " + recipeCategoryItem);
    }


    @Test
    public void P2_selectTypeIndianFood(){
        allure_Log("Clicking on " + ethnicFoodIndian);
        categoryPage = categoryPage.selectEthnicFood_ByName(ethnicFoodIndian); // Leading to new categoryPage
        closePopupIfExists();
        allure_LogAttachment("Indian recipes appears", "E2E\\P1", "P2_indianFoodItems");
        Assert.assertTrue(categoryPage.isTitleEquals(ethnicFoodIndianTitle), "ERROR: Not showing the recipes search page of " + ethnicFoodIndianTitle);
    }


    @Test
    public void P3_selectItem(){
        allure_Log("Clicking on " + indianFoodIndex + " item");
        recipeProductPage = categoryPage.selectEthnicFood_ByIndex(indianFoodIndex);
        closePopupIfExists();
        allure_LogAttachment("Indian recipes appears", "E2E\\P1", "P3_indianFoodProduct");
        Assert.assertTrue(recipeProductPage.isGroceriesAppears(), "ERROR: Not showing the recipe product page");
    }

    @Test
    public void P4_getGroceries(){
        allure_Log("Getting groceries list items: ");
        String groceries;
        allure_Log(groceries = recipeProductPage.getGroceries());
        System.out.println(groceries);
        closePopupIfExists();
        allure_LogAttachment("Indian item nutritional value", "E2E\\P1", "P4_FoodGroceries");
        Assert.assertTrue(groceries.length()>1);
    }

    @Test
    public void P5_getNutritionalvalue(){
        allure_Log("Getting nutritional value list items: ");
        String nuritionalvalue;
        allure_Log(nuritionalvalue = recipeProductPage.getNutritionalValue());
        System.out.println(nuritionalvalue);
        closePopupIfExists();
        allure_LogAttachment("Indian item nutritional value", "E2E\\P1", "P5_nutritionalValue");
        Assert.assertTrue(nuritionalvalue.length()>1);
    }

}