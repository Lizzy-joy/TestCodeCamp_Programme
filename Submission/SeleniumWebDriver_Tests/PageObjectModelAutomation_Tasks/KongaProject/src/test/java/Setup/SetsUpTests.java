package Setup;

import PageObjects.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetsUpTests {

    //create a WebDriver Object
    private WebDriver driver;

    //create homepage Object
    public Homepage homepage;



    @BeforeTest
    public void Setup() throws InterruptedException {
        // selenium WebDriver needs this executable in order to know which browser to run your test
        //Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Instantiate WebDriver Object
        driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //input website URl
        driver.get("https://www.konga.com/");
        //Instantiate Homepage after launching the browser-Handle
        homepage= new Homepage(driver)


    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }

}
