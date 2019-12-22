package Settings;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;


public class WebDriverSettings {

    public static ChromeDriver chromeDriver;
    public static EventFiringWebDriver driver;
    public static SeleniumListener listener;
    @BeforeMethod
    public void beforeClass() {
        chromeDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(chromeDriver);
        listener = new SeleniumListener();
        driver.register(listener);
        driver.manage().window().maximize();
    }

    @AfterMethod
    protected void finish()
    {
        chromeDriver.quit();
    }

    @AfterMethod
    public void catchFailure(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            takeScreenshot(result.getName().toString());
        }
    }

    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot(String name) throws IOException
    {
        File screenShotFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(".\\target\\screenshots\\" + name + ".png"));
        return ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot(WebElement webElement, String name)
    {
        JavascriptExecutor jse = (JavascriptExecutor) chromeDriver;
        //jse.executeScript("arguments[0].style.border='3px solid red'", webElement);
        // added sleep to give little time for browser to respond
        try
        {
            Thread.sleep(100);
        }
        catch (Exception ignored) {}
        File screenShotFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(screenShotFile, new File(".\\target\\screenshots\\" + name + ".png"));
        }
        catch (Exception ignored) {}
        return ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
    }
}