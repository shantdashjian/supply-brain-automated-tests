package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {

    @Test
    public void testLoginWithCorrectUsernameAndPassord() {
        driver.get("https://api-demo.supplybrain.io/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("njdemo@njtest.com");
        loginPage.setPassword("njdemo1234");
        HomePage homePage = loginPage.clickLoginButton();
        String actualDashboardBodyText = homePage.getDashboardBodyText();
        assertEquals(actualDashboardBodyText, "You are logged in!", "Login failed");
    }
}
