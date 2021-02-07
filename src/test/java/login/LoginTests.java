package login;

import base.BaseTests;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PasswordResetPage;

import java.util.Set;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        goToLoginPageAndGetLoginPageHandle();
    }

    private void goToLoginPageAndGetLoginPageHandle() {
        goToLoginPage();
        loginPage = new LoginPage(driver);
    }

    private void goToLoginPage() {
        driver.get("https://api-demo.supplybrain.io/login");
        driver.manage().window().maximize();
    }


    @Test(description = "logs in with correct email and password")
    public void loginWithCorrectEmailAndPasswordShouldAuthenticate() {
        loginPage.setEmail("njdemo@njtest.com");
        loginPage.setPassword("njdemo1234");
        HomePage homePage = loginPage.clickLoginButton();
        String actualDashboardBodyText = homePage.getDashboardBodyText();
        assertEquals(actualDashboardBodyText, "You are logged in!", "Login failed");
        homePage.clickLogoutLink();
    }

    @Test(description = "tries to log in with correct email but incorrect password")
    public void loginWithCorrectEmailButIncorrectPasswordShouldGiveAnErrorMessage() {
        loginPage.setEmail("njdemo@njtest.com");
        loginPage.setPassword("incorrectpassword");
        loginPage.clickLoginButton();
        boolean actualIsInvalidFeedbackLabelDisplayed = loginPage.isInvalidFeedbackLabelDisplayed();
        assertTrue(actualIsInvalidFeedbackLabelDisplayed, "Invalid feedback label not displayed");
        String actualInvalidFeedbackLabelText = loginPage.getInvalidFeedbackLabelText();
        assertEquals(actualInvalidFeedbackLabelText, "These credentials do not match our records.", "Invalid feedback text incorrect");
    }

    @Test(description = "tries to log in with incorrect email but correct password")
    public void loginWithIncorrectEmailButCorrectPasswordShouldGiveAnErrorMessage() {
        loginPage.setEmail("incorrectusername@njtest.com");
        loginPage.setPassword("njdemo1234");
        loginPage.clickLoginButton();
        boolean actualIsInvalidFeedbackLabelDisplayed = loginPage.isInvalidFeedbackLabelDisplayed();
        assertTrue(actualIsInvalidFeedbackLabelDisplayed, "Invalid feedback label not displayed");
        String actualInvalidFeedbackLabelText = loginPage.getInvalidFeedbackLabelText();
        assertEquals(actualInvalidFeedbackLabelText, "These credentials do not match our records.", "Invalid feedback text incorrect");
    }

    @Test(description = "tries to log in without entering email but with password")
    public void loginWithoutEmailButWithPasswordShouldStayOnTheLoginPageAndShowHTML5ValidationMessage() {
        loginPage.setEmail("");
        loginPage.setPassword("njdemo1234");
        loginPage.clickLoginButton();
        String actualValidationMessage = loginPage.getEmailValidationMessage();
        assertEquals(actualValidationMessage, "Please fill out this field.", "Validation message did not display");
    }

    @Test(description = "tries to log in entering email but with no password")
    public void loginWithEmailButNoPasswordShouldStayOnTheLoginPageAndShowHTML5ValidationMessage() {
        loginPage.setEmail("njdemo@njtest.com");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        String actualValidationMessage = loginPage.getPasswordValidationMessage();
        assertEquals(actualValidationMessage, "Please fill out this field.", "Validation message did not display");
    }

    @Test(description = "tries to log in entering email without an @")
    public void loginWithEmailWithoutAtSignShouldStayOnTheLoginPageAndShowHTML5ValidationMessage() {
        loginPage.setEmail("njdemonjtest.com");
        loginPage.setPassword("njdemo1234");
        loginPage.clickLoginButton();
        String actualValidationMessage = loginPage.getEmailValidationMessage();
        assertTrue(actualValidationMessage.contains("Please include an '@' in the email address."), "Validation message did not display");
    }

    @Test(description = "tries to log in entering email without a part before the @")
    public void loginWithEmailWithoutAPartBeforeTheAtSignShouldStayOnTheLoginPageAndShowHTML5ValidationMessage() {
        loginPage.setEmail("@test.com");
        loginPage.setPassword("njdemo1234");
        loginPage.clickLoginButton();
        String actualValidationMessage = loginPage.getEmailValidationMessage();
        assertTrue(actualValidationMessage.contains("Please enter a part followed by '@'."), "Validation message did not display");
    }

    @Test(description = "tries to log in entering email without a part after the @")
    public void loginWithEmailWithoutAPartAfterTheAtSignShouldStayOnTheLoginPageAndShowHTML5ValidationMessage() {
        loginPage.setEmail("njdemo@");
        loginPage.setPassword("njdemo1234");
        loginPage.clickLoginButton();
        String actualValidationMessage = loginPage.getEmailValidationMessage();
        assertTrue(actualValidationMessage.contains("Please enter a part following '@'."), "Validation message did not display");
    }

    @Test(description = "logs in with correct email and password and checks the Remember Me checkbox")
    public void loginWithCorrectEmailAndCorrectPasswordAndCheckRememberMeShouldRememberUserAfterBrowserQuit() {
        loginPage.setEmail("njdemo@njtest.com");
        loginPage.setPassword("njdemo1234");
        loginPage.checkRememberMeCheckbox();
        HomePage homePage = loginPage.clickLoginButton();

        // Save cookies for next session
        Set<Cookie> allCookies = driver.manage().getCookies();

        driver.close();
        instantiateDriver();
        goToLoginPage();

        // We need to clean the cookies and load back the previous session cookies
        driver.manage().deleteAllCookies();
        for (Cookie cookie : allCookies) {
            driver.manage().addCookie(cookie);
        }

        goToLoginPage();
        homePage = new HomePage(driver);
        String actualDashboardBodyText = homePage.getDashboardBodyText();
        assertEquals(actualDashboardBodyText, "You are logged in!", "Login failed");
        homePage.clickLogoutLink();
    }

    @Test(description = "logs in with correct email and password without checking the Remember Me checkbox")
    public void loginWithCorrectEmailAndCorrectPasswordAndWithoutCheckRememberMeShouldNotRememberUserAfterBrowserQuit() {
        loginPage.setEmail("njdemo@njtest.com");
        loginPage.setPassword("njdemo1234");
        HomePage homePage = loginPage.clickLoginButton();

        // Save cookies for next session
        Set<Cookie> allCookies = driver.manage().getCookies();

        driver.close();
        instantiateDriver();
        goToLoginPage();

        // We need to clean the cookies and load back the previous session cookies
        driver.manage().deleteAllCookies();
        for (Cookie cookie : allCookies) {
            driver.manage().addCookie(cookie);
        }

        goToLoginPage();
        loginPage = new LoginPage(driver);
        String actualBodyText = loginPage.getBodyText();
        assertFalse(actualBodyText.contains("You are logged in!"));
    }

    @Test(description = "clicks Forgot Your Password? link")
    public void clickResetPasswordLinkShouldOpenPasswordResetPage() {
        PasswordResetPage passwordResetPage = loginPage.clickForgotYourPasswordLink();
        String actualBodyText = passwordResetPage.getBodyText();
        assertTrue(actualBodyText.contains("Reset Password"), "Password reset page did not display");
    }
}
