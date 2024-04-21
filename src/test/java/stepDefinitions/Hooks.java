package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import static utilities.ConfigReader.getProperty;

public class Hooks {

    AppiumDriver driver;

    @Before
    public void initialization() throws MalformedURLException {
        System.out.println("Platform " + getProperty("platformName"));
        driver = Driver.initializeDriver(getProperty("platformName"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/HataliEkranGoruntuleri/" + scenario.getName() + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
