package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import pageobjects.LoginPageOR;
import testbase.BaseClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class CommonSeleniumUtils {

    public void waitForElementPresent(By locator, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void wait(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public void moveToElement(String elementName, By locator) {
        try {
            waitForElementPresent(locator, 5);
            WebElement element = BaseClass.getDriver().findElement(locator);
            Actions actions = new Actions(BaseClass.getDriver());
            actions.moveToElement(element).build().perform();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public boolean alertIsPresent(int sec) {
        try {
            WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(sec));
            if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
                System.out.println("alert was not present");
                return true;
            } else {
                System.out.println("alert was present");
                return false;
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return true;
    }

    public String getAlertText() {
        String text = "";
        try {
            text = BaseClass.getDriver().switchTo().alert().getText();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return text;
    }

    public void dismissAlert() {
        try {
            BaseClass.getDriver().switchTo().alert().dismiss();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void acceptOKAlert() {
        try {
            BaseClass.getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void openPage(String url) {
        if (url.contains("http"))
            BaseClass.getDriver().get(url);
        else
            BaseClass.getDriver().get(ConfigFileReader.getInstance().getProperty("url"));
    }

    public void verifyTitle(String pageName, String expectedTitle) {
        String actualTitle;
        if (!expectedTitle.isEmpty()) {
            actualTitle = BaseClass.getDriver().getTitle();
            if (expectedTitle.equals(actualTitle))
                ReportManager.reportInformation(pageName,pageName + " page is loaded successfully");
            else
                ReportManager.reportInformation(pageName,pageName + " page is not loaded successfully");
        } else
            ReportManager.reportInformation(pageName,pageName + " given page name is empty");

    }
    public void verifyElementText(String elementName, By locator, String expectedText) {
        String actualText;
        if (!expectedText.isEmpty()) {
            actualText = BaseClass.getDriver().findElement(locator).getText().trim();
            if (expectedText.equals(actualText))
                ReportManager.reportInformation(elementName, elementName + " Element is loaded successfully");
            else
                ReportManager.reportInformation(elementName,elementName + " Element is not loaded successfully");
        } else
            ReportManager.reportInformation(elementName,elementName + " Text is empty");

    }

    public void clickOnElement(String btnLinkName, By locator) {
        BaseClass.getDriver().findElement(locator).click();
    }
    public void submitElement(String btnLinkName, By locator) {
        BaseClass.getDriver().findElement(locator).submit();
    }

    public void enterTextBox(String fieldName, By locator, String value) {
        BaseClass.getDriver().findElement(locator).clear();
        BaseClass.getDriver().findElement(locator).sendKeys(value);
        Log.info(fieldName + " entered with " + value);
        ReportManager.reportInformation(fieldName, fieldName + " entered with " + value);
    }

    public void driverWait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    public String getTitle() {
        try {
            return BaseClass.getDriver().getTitle();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    public String getText(String xpath_identifier) {
        try {
            return BaseClass.getDriver().findElement(By.xpath(xpath_identifier)).getText();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    public String getText(By identifier) {
        try {
            return BaseClass.getDriver().findElement(identifier).getText();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

}
