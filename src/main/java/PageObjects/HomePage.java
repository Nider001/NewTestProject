package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class HomePage
{
    //final Wait<WebDriver> Waiter;
    WebElement loginButton;
    WebElement cityButton;
    WebElement searchField;

    public HomePage(WebDriver driver)
    {
        driver.manage().window().maximize();

        driver.get("https://beru.ru");


        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (d.findElement(By.className("_1FEpprw_Km")).isDisplayed()
                        && d.findElement(By.className("_1hOJdjk4Dx")).isDisplayed()
                        && d.findElement(By.className("_1Y0RowdhI9")).isDisplayed());
            }
        });

        loginButton = driver.findElement(By.className("pFhTbV17qj"));
        cityButton = driver.findElement(By.className("_1hOJdjk4Dx"));
        searchField = driver.findElement(By.cssSelector("[class='_1Y0RowdhI9'] input"));
    }

    public void login(WebDriver driver)
    {
        WebElement loginField;
        WebElement confirmButton;
        WebElement passwordField;

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return loginButton.isDisplayed();
            }
        });

        loginButton.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("passp-field-login")).isDisplayed();
            }
        });

        loginField = driver.findElement(By.id("passp-field-login"));
        confirmButton = driver.findElement(By.className("passp-sign-in-button"));


        loginField.sendKeys("testcasesorokin");
        confirmButton.click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("passp-field-passwd")).isDisplayed();
            }
        });

        passwordField = driver.findElement(By.id("passp-field-passwd"));

        passwordField.sendKeys("123qwe456asd");

        confirmButton = driver.findElement(By.className("passp-sign-in-button"));
        confirmButton.click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.className("_1FEpprw_Km")).isDisplayed();
            }
        });
    }

    public void changeCity(WebDriver driver, final String cityName)
    {
        cityButton.click();

        WebElement textField = driver.findElement(By.cssSelector("[class='_3GSqwWiCh0'] input"));

        textField.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);

        final String[] temp = cityName.split("");

        for (String s: temp) {
            textField.sendKeys(s);
            driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        }

        final WebElement suggestion = driver.findElement(By.id("react-autowhatever-region--item-0"));

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return suggestion.getText().contains(cityName);
            }
        });

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(suggestion));

        suggestion.click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector("button[class = \"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u\"] span[class = \"_2w0qPDYwej\"]")).isDisplayed();
            }
        });

        WebElement confirmButton = driver.findElement(By.cssSelector("button[class = \"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u\"] span[class = \"_2w0qPDYwej\"]"));
        confirmButton.click();


        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("//div[text()=\"" + cityName + "\"]")).isDisplayed();
            }
        });
    }

    public void goToBrushes(WebDriver driver)
    {
        searchField.sendKeys("электрические зубные щетки" + Keys.ENTER);

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector("[data-auto='filter-range-glprice'] input")).isDisplayed();
            }
        });
    }
}
