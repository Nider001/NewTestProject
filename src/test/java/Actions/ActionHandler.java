package Actions;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;


public class ActionHandler
{
    public static ChromeDriver chromeDriver;

    @BeforeMethod
    public void initDriver()
    {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.isSuccess())
        {
            chromeDriver.quit();
        }
        else
        {
            takeScreenshot(result.getName());
            chromeDriver.quit();
        }
    }

    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot(String name)
    {
        File screenShotFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(screenShotFile, new File(".\\target\\screenshots\\" + name + ".png"));
        }
        catch (Exception ignored) {}
        return ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
    }
}