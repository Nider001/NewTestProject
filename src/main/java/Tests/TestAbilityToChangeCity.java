package Tests;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAbilityToChangeCity {

    @Test(dataProvider = "Authentication")
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        HomePage checkChangeCity = new HomePage(driver);



        //Первый тест - проверка логина
        checkChangeCity.changeCity(driver, "Хвалынск");

        driver.quit();
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
