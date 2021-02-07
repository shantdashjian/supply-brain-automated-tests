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
    private By rememberMeCheckbox = By.id("remember");
    private By body = By.tagName("body");
    private By forgotYourPasswordLink = By.xpath("//*[contains(text(), 'Forgot Your Password?')]");

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

    public void checkRememberMeCheckbox() {
        driver.findElement(rememberMeCheckbox).click();
    }

    public String getBodyText() {
        return driver.findElement(body).getText();
    }

    public PasswordResetPage clickForgotYourPasswordLink() {
        driver.findElement(forgotYourPasswordLink).click();
        return new PasswordResetPage(driver);
    }

    public String getEmailValidationMessage() {
        return driver.findElement(emailField).getAttribute("validationMessage");
    }

    public String getPasswordValidationMessage() {
        return driver.findElement(passwordField).getAttribute("validationMessage");
    }

}
