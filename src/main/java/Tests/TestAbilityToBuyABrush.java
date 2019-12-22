package Tests;

import PageObjects.CartPage;
import PageObjects.CatalogPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TestAbilityToBuyABrush {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.goToBrushes(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.setCostRange(999, 1999);
        catalogPage.scrollAndClick(driver);
        catalogPage.goToCart(driver);

        CartPage cartPage = new CartPage();
        cartPage.CheckDeliveryNotFree(driver);
        cartPage.CheckFinalCost(driver);
        cartPage.goBackToCart(driver);
        cartPage.IncreaseCount(2999, driver);
        cartPage.CheckFinalCost(driver);

        driver.quit();
    }
}
