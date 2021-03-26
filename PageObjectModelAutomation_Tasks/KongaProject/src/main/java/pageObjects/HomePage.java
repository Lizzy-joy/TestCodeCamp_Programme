package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private static WebDriver driver;
    private static final By loginButton = By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button");
    private static final By categoryBarElement = By.className("ef511_2c5_i");
    private static final By subcategory = By.xpath(".//a[contains(text(),'Macbooks')]");
    //Category number where 0 = All Categories and  7 = Wines & Other Categories
    static int categoryNumber = 1;
    //Subcategory number where 0 = Mini Laptops and Netbooks and  4 = Macbooks
    static int loginButtonElementID = 3;

    public HomePage(WebDriver driver)
    {
        HomePage.driver = driver;
    }

    public static LoginPage clickLoginSignUpButton()
    {
        driver.findElements(loginButton).get(loginButtonElementID).click();
        return new LoginPage(driver);
    }

    public static SubCategoryPage clickCategoryAndSub() throws InterruptedException
    {
        Actions executeAction = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement selectedCategory = driver.findElements(categoryBarElement).get(categoryNumber);
        //Mouse hover on the selected category
        executeAction.moveToElement(selectedCategory).perform();
        Thread.sleep(7000);

        //Wait for the element to appear before clicking on the selected subcategory
        //wait.until(ExpectedConditions.visibilityOfElementLocated(subcategory));
        //Click on the MacBook
        driver.findElement(subcategory).click();
        Thread.sleep(5000);

        return new SubCategoryPage(driver);
    }

}
