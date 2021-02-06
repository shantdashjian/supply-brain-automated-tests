package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utility.EventReporter;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    protected EventFiringWebDriver driver;

    @BeforeSuite
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        FileUtils.deleteDirectory(new File("./src/main/resources/screenshots/"));
    }

    @BeforeMethod
    public void methodSetup() {
        instantiateDriver();
    }

    protected void instantiateDriver() {
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        return options;
    }

    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            FileUtils.moveFile(screenshot, new File("./src/main/resources/screenshots/" + result.getName() + ".png"));
        }
        driver.quit();
    }

    @AfterClass
    public void tearDown() {
    }
}
