package testbase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import utils.CommonSeleniumUtils;
import utils.ConfigFileReader;
import utils.Log;
import utils.ReportManager;

public class BaseClass extends CommonSeleniumUtils {
    Logger logger = Logger.getLogger(BaseClass.class);
    public static WebDriver driver;


    /*To Store data between class - Static Container*/
    public static String globalURL = "";
    public static List<Map<String, String>> credentials = new ArrayList<>();

    String browserType = ConfigFileReader.getInstance().getProperty("browser");
    String driverPath = System.getProperty("user.dir") + ConfigFileReader.getInstance().getProperty("chromePath");
    public static String screenshotsPath = System.getProperty("user.dir") + ConfigFileReader.getInstance().getProperty("screenshotsPath");
    String log4jPath = System.getProperty("user.dir") + ConfigFileReader.getInstance().getProperty("log4jPath");


    public List<Map<String, String>> getCredentials() {
        return credentials;
    }


    @BeforeSuite
    public void initURL(){
        ReportManager.screenPrintSetup(screenshotsPath);
        logSetup(log4jPath);
        Log.info("Log4j initiated");
        globalURL = ConfigFileReader.getInstance().getProperty("url");
        logger.info("url "+ globalURL);
    }

    public void setUpDriver() {
        if (driver == null)
            driver = initiateDriver(browserType, driverPath);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver initiateDriver(String browserType, String driverPath) {
        if (browserType.equalsIgnoreCase("chrome")) {
            System.out.println("Launching Chrome browser");
            Log.info("Test Chrome initiated ");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("enable-automation");
            options.addArguments("-remote-allow-origins=*");
            options.addArguments("start-maximized");
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } else if (browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        return driver;
    }



    public void logSetup(String log4jPath) {
        PropertyConfigurator.configure(log4jPath);
    }

    public String getMappedCredentials(String key) {
        List<Map<String, String>> data = getCredentials();
        for (Map<String, String> data1 : data) {
            for (Map.Entry<String, String> pair : data1.entrySet()) {
                if (key.contains("username")) {
                    logger.info(String.format("Key (name) is: " +pair.getKey()));
                    return pair.getKey();
                }
                else if (key.contains("password")) {
                    logger.info(String.format("Value (password) is : %s", pair.getValue()));
                    return pair.getValue();
                }
            }
        }
        return "";
    }

}