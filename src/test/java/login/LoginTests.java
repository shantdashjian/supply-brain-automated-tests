package login;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://api-demo.supplybrain.io/login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }


    @Test
    public void loginWithCorrectEmailAndPasswordShouldAuthenticateAndThenLogout() {
        loginPage.setEmail("njdemo@njtest.com");
        loginPage.setPassword("njdemo1234");
        HomePage homePage = loginPage.clickLoginButton();
        String actualDashboardBodyText = homePage.getDashboardBodyText();
        assertEquals(actualDashboardBodyText, "You are logged in!", "Login failed");
        homePage.clickLogoutLink();
    }

    @Test
    public void loginWithCorrectEmailButIncorrectPasswordShouldGiveAnErrorMessage() {
        loginPage.setEmail("njdemo@njtest.com");
        loginPage.setPassword("incorrectpassword");
        loginPage.clickLoginButton();
        boolean actualIsInvalidFeedbackLabelDisplayed = loginPage.isInvalidFeedbackLabelDisplayed();
        assertTrue(actualIsInvalidFeedbackLabelDisplayed, "Invalid feedback label not displayed");
        String actualInvalidFeedbackLabelText = loginPage.getInvalidFeedbackLabelText();
        assertEquals(actualInvalidFeedbackLabelText, "These credentials do not match our records.", "Invalid feedback text incorrect");
    }

    @Test
    public void loginWithIncorrectEmailButCorrectPasswordShouldGiveAnErrorMessage() {
        loginPage.setEmail("incorrectusername@njtest.com");
        loginPage.setPassword("njdemo1234");
        loginPage.clickLoginButton();
        boolean actualIsInvalidFeedbackLabelDisplayed = loginPage.isInvalidFeedbackLabelDisplayed();
        assertTrue(actualIsInvalidFeedbackLabelDisplayed, "Invalid feedback label not displayed");
        String actualInvalidFeedbackLabelText = loginPage.getInvalidFeedbackLabelText();
        assertEquals(actualInvalidFeedbackLabelText, "These credentials do not match our records.", "Invalid feedback text incorrect");
    }
}
