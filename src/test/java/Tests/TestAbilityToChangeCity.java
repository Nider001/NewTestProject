package Tests;

import PageObjects.HomePage;
import Settings.WebDriverSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAbilityToChangeCity extends WebDriverSettings {

    @Test(dataProvider = "Authentication")
    public void changeCity(String city)
    {
        HomePage checkChangeCity = new HomePage(chromeDriver);

        checkChangeCity.changeCity(chromeDriver, city);
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{
                {"Хвалынск"},
                {"Хабаровск"},
                {"Москва"},
                {"Волгоград"}
        };
    }
}
