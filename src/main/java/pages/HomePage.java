package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements
    private By dashboardBody = By.className("card-body");

    // Interactions
    public String getDashboardBodyText() {
        return driver.findElement(dashboardBody).getText();
    }
}
