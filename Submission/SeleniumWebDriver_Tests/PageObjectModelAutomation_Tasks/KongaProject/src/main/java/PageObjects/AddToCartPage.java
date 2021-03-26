package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {

    private final WebDriver driver;
    private final By totalItemCount=By.xpath("//*[@id=\"js-cart-items-wrapper\"]/div/div/div[2]/div[1]/form/div/div/div");
    private final By addItem=By.xpath("//*[@id=\"js-cart-items-wrapper\"]/div/div/div[1]/div/a/h4");
    private final By checkOutButton= By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button");

    public AddToCartPage(WebDriver driver)
    {
        this.driver=driver;

    }
    //Check the number of item in the cart
    public void itemCount (int count) throws InterruptedException {
        int itemNumber= Integer.parseInt(driver.findElement(totalItemCount).getText());
        do
        {
            //if the amount is equal to the amount entered stop adding
            if (itemNumber==count) break;
            driver.findElement(addItem).click();
            //store the count of items
            itemNumber=Integer.parseInt(driver.findElement(totalItemCount).getText());
            //if the item is not equal to the required amount,keep adding
        }while (itemNumber !=count);
        Thread.sleep(5000);

}