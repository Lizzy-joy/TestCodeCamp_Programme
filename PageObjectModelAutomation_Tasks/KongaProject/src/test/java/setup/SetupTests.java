package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.HomePage;

public class SetupTests{

        //create a WebDriver Object
        private WebDriver driver;

        //create a HomePage Object
        protected HomePage homePage;


    @BeforeTest
        public void Setup() {
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
            HomePage homePage = new HomePage(driver);

        }

        @AfterTest
        public void teardown()
        {
            driver.quit();
        }

    }
