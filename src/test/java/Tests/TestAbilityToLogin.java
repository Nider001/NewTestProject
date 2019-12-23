package Tests;

import PageObjects.HomePage;
import Actions.ActionHandler;
import org.testng.annotations.Test;

public class TestAbilityToLogin extends ActionHandler {

    @Test
    public void login()
    {
        HomePage checkLogin = new HomePage(chromeDriver);

        checkLogin.login(chromeDriver);
    }
}
