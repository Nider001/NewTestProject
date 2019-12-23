package Tests;

import PageObjects.HomePage;
import Actions.ActionHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAbilityToChangeCity extends ActionHandler {

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
