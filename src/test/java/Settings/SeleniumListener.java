package Settings;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;


public class SeleniumListener implements WebDriverEventListener {

    @Attachment(value = "Screenshot")
    public static byte[] takeScreenshot(By by, WebDriver driver, String name) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(by));

        try {
            Thread.sleep(100);
        }catch (Exception ignored) {
        }
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(".\\target\\screenshots\\" + name + ".png"));
        } catch (Exception ignored) {
        }

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        jse.executeScript("arguments[0].style.border=''", driver.findElement(by));
        return screenshot;
    }

    public void beforeAlertAccept(WebDriver webDriver) {}

    public void afterAlertAccept(WebDriver webDriver) {}

    public void afterAlertDismiss(WebDriver webDriver) {}

    public void beforeAlertDismiss(WebDriver webDriver) {}

    public void beforeNavigateTo(String s, WebDriver webDriver) {}

    public void afterNavigateTo(String s, WebDriver webDriver) {}

    public void beforeNavigateBack(WebDriver webDriver) {}

    public void afterNavigateBack(WebDriver webDriver) {}

    public void beforeNavigateForward(WebDriver webDriver) {}

    public void afterNavigateForward(WebDriver webDriver) {}

    public void beforeNavigateRefresh(WebDriver webDriver) {}

    public void afterNavigateRefresh(WebDriver webDriver) {}

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        try{
            takeScreenshot(by, webDriver, webDriver.findElement(by).getText());
        } catch (Exception ignored) {
        }
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {}

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {}

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {}

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {}

    public void beforeScript(String s, WebDriver webDriver) {}

    public void afterScript(String s, WebDriver webDriver) {}

    public void onException(Throwable throwable, WebDriver webDriver) {}
}