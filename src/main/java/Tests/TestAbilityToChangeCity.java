package Tests;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAbilityToChangeCity {

    public static String array[] = new String[] {
            "Хвалынск", "Хабаровск", "Москва", "Волгоград" };

    public static void main(String[] args)
    {
        for (String a: array)
        {
            test(a);
        }
    }

    //@Test(dataProvider = "Authentication")
    public static void test(String city)
    {
        //System.setProperty("webdriver.chrome.driver","C:\\ProgramData\\chocolatey\\lib\\chromedriver\\tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        HomePage checkChangeCity = new HomePage(driver);

        checkChangeCity.changeCity(driver, city);

        driver.quit();
    }

    /*@DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{
                {"Хвалынск"},
                {"Хабаровск"},
                {"Москва"},
                {"Волгоград"}
        };
    }*/
}
