package Tests;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAbilityToBuyABrush {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        //Первый тест - проверка логина
        homePage.goToBrushes(driver);

        //driver.quit();
    }
}
