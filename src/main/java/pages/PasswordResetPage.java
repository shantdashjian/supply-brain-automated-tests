package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordResetPage {
    private WebDriver driver;

    public PasswordResetPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements
    private By body = By.tagName("body");

    // Interactions
    public String getBodyText() {
        return driver.findElement(body).getText();
    }
}
