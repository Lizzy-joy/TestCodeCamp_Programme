package Facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook_LogInOut {
    //Import Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException{
        //fetch the chromeDriver.exe file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //launch the chromedriver.exe file
        driver = new ChromeDriver();

        String url = "https://web.facebook.com/login";
        //input the website URL
        driver.get (url);

        //Maximize the browser
        driver.manage() .window().maximize();
    }
    @Test(priority = 0)
    public void loginTest() throws InterruptedException {
        //click on the username field and input a valid username "08100044638"
        driver.findElement(By.id("email")).sendKeys("08100044638");

        //click on the password field and input a valid password "GRACE1234"
        driver.findElement(By.id("pass")).sendKeys("GRACE1234");

        //click on the login button
        driver.findElement(By.id("loginbutton")).click();

        //Get Page Title and Print out
        System.out.println(driver.getTitle());

        if(driver.getCurrentUrl().contains("https://web.facebook.com/")) {
            System.out.println("PASSED - User has Successfully logged in");
        }else {
            System.out.println("FAILED - The user was unable to login");
        }
    }

    @Test(priority = 1)
    public void signOut() throws InterruptedException{
        Thread.sleep(1500);
        //Click User Profile
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div[3]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]")).click();
        Thread.sleep(3000);

        if(driver.getCurrentUrl().contains("https://web.facebook.com/")) {
            System.out.println("PASSED - User has Successfully logged out");
        }else {
            System.out.println("FAILED - User is still logged in");
        }
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public static void main(String args[]) throws InterruptedException {
        Facebook_LogInOut test = new Facebook_LogInOut();
        test.setUp();
        test.loginTest();
        test.signOut();
        test.tearDown();
    }
}
