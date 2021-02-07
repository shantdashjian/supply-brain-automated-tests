package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utility.EventReporter;

import java.io.File;
import java.io.IOException;

public class BaseTests extends TestListenerAdapter {

    protected static EventFiringWebDriver driver;

    @BeforeSuite
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        FileUtils.deleteDirectory(new File("./test-output/"));
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

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("./test-output/screenshots/" + result.getMethod() + ".png");
            FileUtils.moveFile(screenshot, destinationFile);
            Reporter.log("<a href='./screenshots/" + destinationFile.getName() + "'> <img src='./screenshots/" + destinationFile.getName() + "' height='100' width='100'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
