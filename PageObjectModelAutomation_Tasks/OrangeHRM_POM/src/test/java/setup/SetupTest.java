package setup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class SetupTest {
    //Create a WebDriver Object
    private WebDriver driver;

    //Create LoginPage Object
    protected LoginPage loginPage;
    // Create DashboardPage Object
    protected DashboardPage dashboardPage;

    @BeforeTest
    public void setUp(){
        //browser setup for chrome WebDriver
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //Instantiate WebDriver Object
        driver = new ChromeDriver();
        //maximize the window browser
        driver.manage().window().maximize();
        //launch the application
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Instantiate login page after launching the browser - Handle
        loginPage = new LoginPage (driver);
    }

    @AfterTest
    public void closeBrowser() {
        // ".close" would close the window but the ".quit" would exist the session
        driver.quit();
    }

}
