package Tests;

import PageObjects.CartPage;
import PageObjects.CatalogPage;
import PageObjects.HomePage;
import Settings.WebDriverSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAbilityToBuyABrush extends WebDriverSettings {

    @Test
    public void buyABrush()
    {
        HomePage homePage = new HomePage(chromeDriver);

        homePage.goToBrushes(chromeDriver);
        CatalogPage catalogPage = new CatalogPage(chromeDriver);
        catalogPage.setCostRange(999, 1999);
        catalogPage.scrollAndClick(chromeDriver);
        catalogPage.goToCart(chromeDriver);

        CartPage cartPage = new CartPage();
        cartPage.CheckDeliveryNotFree(chromeDriver);
        cartPage.CheckFinalCost(chromeDriver);
        cartPage.goBackToCart(chromeDriver);
        cartPage.IncreaseCount(2999, chromeDriver);
        cartPage.CheckFinalCost(chromeDriver);
    }
}
