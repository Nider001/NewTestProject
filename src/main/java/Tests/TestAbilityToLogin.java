package Tests;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAbilityToLogin {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        HomePage checkLogin = new HomePage(driver);

        //Первый тест - проверка логина
        checkLogin.login(driver);

        driver.quit();
    }
}
