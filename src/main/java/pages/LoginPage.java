package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("form button");
    private By invalidFeedbackLabel = By.className("invalid-feedback");

    // Interactions
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public boolean isInvalidFeedbackLabelDisplayed() {
        return driver.findElement(invalidFeedbackLabel).isDisplayed();
    }

    public String getInvalidFeedbackLabelText() {
        return driver.findElement(invalidFeedbackLabel).getText();
    }

}
