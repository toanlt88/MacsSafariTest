package test;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GridTest1 {
    WebDriver driver;
    String fileWithPath= "C:\\temp\\screenshot\\screenshot.jpg";

    @BeforeTest (alwaysRun = true)
    public void setup() throws Exception {
        URL url = new URL("https://selenium4.test.clarkinc.biz/");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browserName", "chrome");
        cap.setCapability("platformName", "Windows");
        cap.setCapability("browserVersion","101.0.4951.41");
        driver = new RemoteWebDriver(url,cap);
    }

    @AfterTest(alwaysRun = true)
    public void teardown() throws Exception {
//        driver.close();
        if (driver != null) {
            try{
                driver.quit();
            }catch (Exception e){}
        }
    }

    @Test
    public void lauch() throws InterruptedException, IOException {
        driver.get("https://www.dev.webstaurantstore.com/");
        Thread.sleep(15000);
        System.out.println("Launching: ");
        System.out.println(driver.getTitle());
        TakesScreenshot scrShot =((TakesScreenshot) driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}