package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CatalogPage
{
    WebElement lowestPrise;
    WebElement highestPrise;

    public CatalogPage(WebDriver driver)
    {
        //driver.manage().window().maximize();
        //driver.get("https://beru.ru/catalog/elektricheskie-zubnye-shchetki/79832/list?hid=278374");

        lowestPrise = driver.findElement(By.cssSelector("[data-auto='filter-range-glprice'] input"));
        highestPrise = driver.findElement(By.cssSelector("[data-auto='filter-range-max'] input"));
    }

    public void setCostRange(int low, int high)
    {
        lowestPrise.sendKeys(String.valueOf(low));
        highestPrise.sendKeys(String.valueOf(high));


    }

    public void scrollAndClick(WebDriver driver)
    {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("//*[text() = 'Показать ещё']")).isDisplayed();
            }
        });

        final WebElement neededBrush = driver.findElement(By.xpath("(//button[contains(@class,'_4qhIn2-ESi _3OWdR9kZRH THqSbzx07u')])[last()-1]"));


        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return neededBrush.isDisplayed();
            }
        });

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", neededBrush);

        (new WebDriverWait(driver, 10)).until(elementToBeClickable(neededBrush));

        neededBrush.click();
    }

    public void goToCart(WebDriver driver)
    {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector("[data-auto='executed-cart-button']")).isDisplayed();
            }
        });

        WebElement cartButton = driver.findElement(By.cssSelector("[data-auto='executed-cart-button']"));

        cartButton.click();
    }
}
