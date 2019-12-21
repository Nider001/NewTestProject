package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrushCatalog
{
    WebElement lowestPrise;
    WebElement highestPrise;

    BrushCatalog(WebDriver driver)
    {
        lowestPrise = driver.findElement(By.cssSelector("[data-auto='filter-range-glprice']"));
        highestPrise = driver.findElement(By.cssSelector("[data-auto='filter-range-max']"));
    }
}
