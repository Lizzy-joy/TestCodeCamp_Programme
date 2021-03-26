package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By nameofUser=By.id("username");
    private final By passwordofUser=By.id("password");
    private final By loginButton = By.xpath("//button[@class='_0a08a_3czMG _988cf_1aDdJ']");


    public LoginPage(WebDriver driver)
    {
        this.driver=driver;

    }

    //Input valid username
    public void enterusername (String hostName)
    {
        driver.findElement(nameofUser).sendKeys(hostName);

    }

    //Input Valid Password
    public void enterPassword (String hostPassword)
    {
        driver.findElement(passwordofUser).sendKeys(hostPassword);

    }

    //click on LoginButton
    public Homepage clickLoginButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return new Homepage(driver);
    }


}
