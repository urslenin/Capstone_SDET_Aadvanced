
package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import testbase.BaseClass;

import java.io.File;
import java.io.IOException;

public class Hooks extends BaseClass {

    @Before
    public void setUp() {
        setUpDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        tearDown();
        System.out.println(scenario.getName() + " scenario completed");
    }
    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");

    }
}