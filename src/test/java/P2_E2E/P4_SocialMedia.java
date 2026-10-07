package P2_E2E;

import il.guyrob.foodsdictionary.Playwright.Pages.*;
import il.guyrob.foodsdictionary.Playwright.base;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class P4_SocialMedia extends base
{


    // Pages
    HomePage homePage;
    SearchPopPage searchPopPage;
    SearchAllPage searchAllPage;
    CategoryPage categoryPage;
    RecipeProductPage recipeProductPage;
    ExternalPages externalPages;


    // Data
    String expectedInstagramURL = "https://www.instagram.com/foodsdictionary_recipes/";
    String expectedInstagramUserName = "foodsdictionary_recipes";

    String expectedTwitterURL = "https://x.com/foodsdictionary";
    String expectedFacebookURL = "https://www.facebook.com/foodsdictionary";
    String expectedFacebookUserName = "FoodsDictionary";

    String expectedYoutubeURL = "https://www.youtube.com/foodsdictionary";
    String expectedPinterestURL = "https://www.Pinterest.com/foodsdictionary";
    String expectedTikTokURL = "https://www.TikTok.com/foodsdictionary";






    @BeforeClass
    public void before() {
        allure_Log("Loading driver...");
        initialDriver(); // כאן ה-page מאותחל בתוך מחלקת הבסיס
        homePage = new HomePage(page);
        allure_LogAttachment("Before Test", "E2E\\P4", "before");
    }

    @AfterClass
    public void after() {
        allure_Log("Closing driver");
        quitDriver();
    }

    @Test
    public void P1_clickOnInstagram(){
        allure_Log("Clicking on Instagram Icon");
        externalPages = homePage.clickSocial("Instagram");
        allure_Log("Validating foodsdictionary Instagram URL");
        Assert.assertEquals(expectedInstagramURL, externalPages.getCurrentURL(), "ERROR: Instagram URL is not match!");
    }

//    @Test
//    public void P2_closeRegisterInstagram(){
//        allure_Log("Closing Instagram register popup");
//        externalPages.Instagram_closeRegisterPopup();
//        allure_LogAttachment("foodsdictionary Instagram page", "E2E\\P4", "P2_closeRegisterInstagram");
//        allure_Log("Validate foodsdictionary username");
//        Assert.assertEquals(expectedInstagramUserName, externalPages.Instagram_getUserName(), "ERROR: Instagram Username is not match!");
//    }

    @Test
    public void P2_closeRegisterInstagram(){

        allure_Log("Closing Instagram register popup");

        externalPages.Instagram_closeRegisterPopup();

        System.out.println("URL: " + page.url());
        System.out.println("Page closed: " + page.isClosed());

        externalPages.allure_LogAttachment(
                "foodsdictionary Instagram page",
                "E2E\\P4",
                "P2_closeRegisterInstagram"
        );

        allure_Log("Validate foodsdictionary username");



        Assert.assertEquals(
                expectedInstagramUserName,
                externalPages.Instagram_getUserName(),
                "ERROR: Instagram Username is not match!"
        );

    }

    @Test
    public void P3_clickOnTwitter(){
        allure_Log("Closing Tab - Back to foodsdictionary Homepage..");
        homePage = externalPages.closeTab();
        allure_LogAttachment("foodsdictionary home page", "E2E\\P4", "P3_backToFDHomepage");
        closePopupIfExists();
        allure_Log("Clicking on Twitter Icon");
        externalPages = homePage.clickSocial("Twitter");
        externalPages.allure_LogAttachment("foodsdictionary Twitter page", "E2E\\P4", "P3_clickOnTwitter");
        allure_Log("Validating foodsdictionary Twitter URL");
        Assert.assertEquals(externalPages.getCurrentURL(), expectedTwitterURL , "ERROR: Twitter URL is not match!");
        //        page.pause();
    }

    @Test
    public void P4_clickOnFacebook(){
        allure_Log("Closing Tab - to foodsdictionary Homepage..");
        homePage = externalPages.closeTab();
        allure_LogAttachment("foodsdictionary home page", "E2E\\P4", "P4_backToFDHomepage");
        closePopupIfExists();
        allure_Log("Clicking on Facebook Icon");
        externalPages = homePage.clickSocial("Facebook");
        externalPages.allure_LogAttachment("foodsdictionary Facebook page", "E2E\\P4", "P4_clickOnFacebook");
        allure_Log("Validating foodsdictionary Facebook URL"); // @todo to update URL
        Assert.assertEquals(externalPages.getCurrentURL(), expectedFacebookURL , "ERROR: Facebook URL is not match!");
    }

    @Test
    public void P5_closeRegisterFacebook(){

        allure_Log("Closing Facebook register popup");

        externalPages.Facebook_closeRegisterPopup();

        System.out.println("URL: " + page.url());
        System.out.println("Page closed: " + page.isClosed());

        externalPages.allure_LogAttachment(
                "foodsdictionary Instagram page",
                "E2E\\P4",
                "P5_closeRegisterFacebbook"
        );

        allure_Log("Validate foodsdictionary username");

//                page.pause();


        Assert.assertEquals(
                externalPages.Facebook_getUserName(), expectedFacebookUserName,
                "ERROR: Facebook Username is not match!"
        );

    }

    @Test
    public void P6_clickOnYouTube(){
        allure_Log("Closing Tab - Back to foodsdictionary Homepage..");
        homePage = externalPages.closeTab();
        allure_LogAttachment("foodsdictionary home page", "E2E\\P4", "P5_backToFDHomepage");
        closePopupIfExists();
        allure_Log("Clicking on YouTube Icon");
        externalPages = homePage.clickSocial("YouTube");
        externalPages.allure_LogAttachment("foodsdictionary YouTube page", "E2E\\P4", "P5_clickOnYouTube");
        allure_Log("Validating foodsdictionary YouTube URL");
        Assert.assertEquals(externalPages.getCurrentURL(), expectedYoutubeURL , "ERROR: YouTube URL is not match!");
        //        page.pause();
    }

    @Test
    public void P7_clickOnPinterest(){
        allure_Log("Closing Tab - Back to foodsdictionary Homepage..");
        homePage = externalPages.closeTab();
        allure_LogAttachment("foodsdictionary home page", "E2E\\P4", "P7_backToFDHomepage");

        sleep(10);
        closePopupIfExists();
        allure_Log("Clicking on Pinterest Icon");
        externalPages = homePage.clickSocial("Pinterest");
        externalPages.allure_LogAttachment("foodsdictionary Pinterest page", "E2E\\P4", "P7_clickOnPinterest");
        allure_Log("Validating foodsdictionary Pinterest URL");
        Assert.assertEquals(externalPages.getCurrentURL(), expectedPinterestURL , "ERROR: Pinterest URL is not match!");
        //        page.pause();
    }

    @Test
    public void P8_clickOnTikTok(){
        allure_Log("Closing Tab - Back to foodsdictionary Homepage..");
        homePage = externalPages.closeTab();
        allure_LogAttachment("foodsdictionary home page", "E2E\\P4", "P8_backToFDHomepage");

        closePopupIfExists();
        allure_Log("Clicking on TikTok Icon");
        externalPages = homePage.clickSocial("TikTok");
        externalPages.allure_LogAttachment("foodsdictionary TikTok page", "E2E\\P4", "P8_clickOnTikTok");
        allure_Log("Validating foodsdictionary TikTok URL"); // @todo to update URL
        Assert.assertEquals(expectedTikTokURL, externalPages.getCurrentURL(), "ERROR: TikTok URL is not match!");
        //        page.pause();
        allure_Log("Back to foodsdictionary Homepage..");
        homePage = externalPages.closeTab();
        allure_LogAttachment("foodsdictionary home page", "E2E\\P4", "P7_backToFDHomepageAgain");
    }




    }

