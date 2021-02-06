package login;

import base.BaseTests;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
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

    @Test
    public void loginWithCorrectEmailAndCorrectPasswordAndCheckRememberMeShouldRememberUserAfterBrowserQuit() {
        loginPage.setEmail("njdemo@njtest.com");
        loginPage.setPassword("njdemo1234");
        loginPage.checkRememberMeCheckbox();
        HomePage homePage = loginPage.clickLoginButton();

        // Save cookies for next session
        Set<Cookie> allCookies = driver.manage().getCookies();

        driver.close();
        driver = new ChromeDriver();
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

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
