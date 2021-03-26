package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

    private final WebDriver driver;
    private final By loginButton = By.xpath("//a[@class='_7ad32_SD12Y _16536_xxIKG']");
    private final By categoryBarElement = By.className("ef511_2c5_i");
    private final By subCategory = By.xpath(".//a[contains(text(),'Macbooks')]");
    //category number where 0=All categories and 7= wines and other Categories
    int categoryNumber = 1;
    //subcategory number where 0=mini laptops and netbook and 4=macbooks
    int loginButtonElementID = 3;


    public Homepage(WebDriver driver)

    {
        this.driver = driver;
    }

    public LoginPage clickloginSignUpButton()
    {
        driver.findElements(loginButton).get(loginButtonElementID).click();
        return new LoginPage(driver);

    }

    public SubCategoryPage clickCategoryAndSub() throws InterruptedException
    {
        Actions executeAction =new Actions(driver);


        WebDriverWait wait=new WebDriverWait(driver,30);
        WebElement selectedCategory=driver.findElements(categoryBarElement).get(categoryNumber);
        //move the mouse on the selected category
        executeAction.moveToElement(selectedCategory).perform();
        Thread.sleep(7000);

        //wait for the element to pop up  before clicking on selected category
        wait.until(ExpectedConditions.visibilityOfElementLocated(subCategory));
        //Click on AppleMacbooks
        driver.findElement(subCategory).click();
        Thread.sleep(3000);


        return new SubCategoryPage(driver);

}
