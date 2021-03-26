package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private final By nameOfUser = By.id("username");
    private final By passwordOfUser = By.id("password");
    private final By loginButton = By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    //Enter Username
    public void enterUsername(String userName)
    {
        driver.findElement(nameOfUser).sendKeys(userName);
    }

    //Enter Password
    public void enterPassword(String userPassword)
    {
        driver.findElement(passwordOfUser).sendKeys(userPassword);
    }

    //Click on the Login button
    public HomePage clickLoginButton() throws InterruptedException
    {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return new HomePage(driver);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
