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
    private By usernameDropdown = By.cssSelector(".ml-auto li:nth-child(2)");
    private By logoutLink = By.xpath("//*[contains(text(), 'Logout')]");


    // Interactions
    public String getDashboardBodyText() {
        return driver.findElement(dashboardBody).getText();
    }

    public LoginPage clickLogoutLink() {
        driver.findElement(usernameDropdown).click();
        driver.findElement(logoutLink).click();
        return new LoginPage(driver);
    }
}
