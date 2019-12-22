package Tests;

import PageObjects.HomePage;
import Settings.WebDriverSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAbilityToLogin extends WebDriverSettings {

    @Test
    public void login()
    {
        HomePage checkLogin = new HomePage(chromeDriver);

        //Первый тест - проверка логина
        checkLogin.login(chromeDriver);
    }
}
