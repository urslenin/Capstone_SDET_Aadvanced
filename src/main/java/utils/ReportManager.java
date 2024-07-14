package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import testbase.BaseClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ReportManager {

    public static String latestScreenshotPath;

    public static void screenPrintSetup(String screenShotPath) {
        try {
            File screenshotFile = new File(screenShotPath);
            if (!(screenshotFile.exists() && screenshotFile.isDirectory()))
                screenshotFile.mkdirs();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void takeScreenshot(String testCaseName) {
        if (BaseClass.getDriver() == null)
            return;
        String snapFile;
        try {
            String dateFormat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss_SSS").format(new GregorianCalendar().getTime());
            File screenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
            snapFile = BaseClass.screenshotsPath + testCaseName + "_"+dateFormat + ".png";
            FileHandler.copy(screenshot, new File(snapFile));
            latestScreenshotPath = snapFile;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void reportInformation(String testCaseName, String message) {
        takeScreenshot(testCaseName);
        //String path =" <br><img src='"+latestScreenshotPath+"' height='300' width='300'/><br>";

        String path = message+ "\n"+
                "<a href=\"" + latestScreenshotPath + "\"> <img src=\"" + latestScreenshotPath + "\" height='100' width='100'/> </a>";
        Reporter.log(path+"\n");
    }
}
