package il.guyrob.foodsdictionary.Playwright.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import il.guyrob.foodsdictionary.Playwright.base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends base {

    // Selectors (String base for flexibility)
    private final String img_banner = "//div[@class='col-12 col-full']//a";
    private final String btn_subBanner_next = "//div[@class = 'col-12-horz']//a[@class='horz-prev']";
    private final String list_subBanners = "(//div[@class = 'col-12-horz']//div[@class = 'd-flex'])[1]//a";
    private final String hotTopicsTitle = "//a[@href='/channel/']//h3[contains(text(), 'נושאים חמים')]";
    private final String btn_hotTopics_next = hotTopicsTitle + "/following::span[@class='horz-prev-icon']";
    private final String list_hotTopics = hotTopicsTitle + "/following::div[@class = 'd-flex'][1]//a";
    private final String btn_mobileAppSection = "//div[@class='col-12']//a[@href='/mobile-app/foods/']";
    private final String btn_books = "//div[@class='col-12']//a[@href='/Recipes/Books/']//h3";
    private final String btn_search = "//div[@class='collapse navbar-collapse navbar-search']//a | //a[@class='nav-link-search']";
    private final String btn_recipesMenu = "#navbarCategories"; // CSS Selector is faster
    private final String list_recipesMenu = "//div[@aria-labelledby='navbarCategories']//a";

    // Socials
    private final String btn_Instagram = "//nav[@id='fdNavbar']//a[@title='האינסטגרם שלנו']";
    private final String btn_Twitter = "//nav[@id='fdNavbar']//a[@title='הטוויטר שלנו']";
    private final String btn_Facebook = "//nav[@id='fdNavbar']//a[@title='הפייסבוק שלנו']";
    private final String btn_Youtube = "//nav[@id='fdNavbar']//a[@title='ערוץ היוטיוב שלנו']";
    private final String btn_Pinterest = "//nav[@id='fdNavbar']//a[@title='הפינטרסט שלנו']";
    private final String btn_TikTok = "//nav[@id='fdNavbar']//a[@title='הטיקטוק שלנו']";




    /**
     * Constructor
     * ב-Playwright חשוב להעביר את האובייקט page אם המחלקה לא יורשת אותו בצורה סטטית
     */
    public HomePage(Page page) {
        this.page = page;
    }

    // --- Functions ---



    public SearchPopPage searchbar_click() {
        page.locator(btn_search).first().click();
        return new SearchPopPage(page);
    }

    public void recipesOpenMenu() {
        page.locator(btn_recipesMenu).click();
    }

    public CategoryPage recipesMenuSelect(String byText) {
        // Playwright יודע לסנן אלמנטים לפי טקסט בצורה מובנית
        Locator menuItems = page.locator(list_recipesMenu);
        Locator target = menuItems.filter(new Locator.FilterOptions().setHasText(byText));

        target.scrollIntoViewIfNeeded();
        target.click();

        return new CategoryPage(page);
    }

    public RecipeProductPage mainBanner_click() {
        page.locator(img_banner).click();
        return new RecipeProductPage(page);
    }

    public List<Locator> subBanner_next() {
        page.locator(btn_subBanner_next).click();
        page.waitForTimeout(1000); // המתנה קצרה לאנימציה

        // מחזיר רק אלמנטים שגלויים כרגע למשתמש
        return page.locator(list_subBanners).all().stream()
                .filter(Locator::isVisible)
                .collect(Collectors.toList());
    }

    public RecipeProductPage subBanner_click(List<Locator> availableProducts, int index) {
        availableProducts.get(index).click();
        return new RecipeProductPage(page);
    }

    public List<Locator> hotTopics_next() {
        page.locator(btn_hotTopics_next).click();
        page.waitForTimeout(1000);

        return page.locator(list_hotTopics).all().stream()
                .filter(Locator::isVisible)
                .collect(Collectors.toList());
    }

    public ExternalPages clickSocial(String socialMedia) {

        String locator;

        switch (socialMedia) {

            case "Instagram":
                locator = btn_Instagram;
                break;

            case "Twitter":
                locator = btn_Twitter;
                break;

            case "Facebook":
                locator = btn_Facebook;
                break;

            case "YouTube":
                locator = btn_Youtube;
                break;

            case "Pinterest":
                locator = btn_Pinterest;
                break;

            case "TikTok":
                locator = btn_TikTok;
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported social media: " + socialMedia
                );
        }

        Page socialPage = page.waitForPopup(() -> {
            page.locator(locator).click();
        });

        socialPage.waitForLoadState(LoadState.DOMCONTENTLOADED);

        socialPage.bringToFront();

        System.out.println("Social media URL: " + socialPage.url());

        return new ExternalPages(socialPage);
    }

}