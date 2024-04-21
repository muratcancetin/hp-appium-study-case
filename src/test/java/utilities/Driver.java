package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static utilities.ConfigReader.getProperty;

public class Driver {

    static AppiumDriver driver;
    static DesiredCapabilities desiredCapabilities;

    public static AppiumDriver initializeDriver(String osVersion) throws MalformedURLException {

        desiredCapabilities = new DesiredCapabilities();
        if (osVersion.equals("Android")) {

            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getProperty("platformVersion"));
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getProperty("deviceName"));
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,getProperty("udid"));
            desiredCapabilities.setCapability(MobileCapabilityType.APP, getProperty("appPath"));
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
            desiredCapabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
            desiredCapabilities.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");
            driver = new AppiumDriver((new URL("http://127.0.0.1:4723/wd/hub")), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        }
        else {
            System.out.println("IOS");
        }

        return getDriver();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }


}
