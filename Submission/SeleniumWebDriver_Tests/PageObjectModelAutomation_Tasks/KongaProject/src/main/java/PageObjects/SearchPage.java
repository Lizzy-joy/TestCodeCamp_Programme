package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private final WebDriver driver;
    private final By AddToCartButton=By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/section/section[2]/section/ul/li[2]/div/div/div[2]/form/div[4]/button");
    private final By MyCartButton =By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div/a[2]/span[1]");

    public SearchPage(WebDriver driver)
    {
        this.driver=driver;

    }
    //Click the first Add to cart button
    public void clickonAddToCart(int index) throws InterruptedException {
        driver.findElements(AddToCartButton).get(index-1).click();
        Thread.sleep(5000);
    }

    //Click on My Cart Page
    public AddToCartPage clickmyCartButton() throws InterruptedException {
        driver.findElement(MyCartButton).click();
        Thread.sleep(5000);
        return new AddToCartPage(driver);

    }

}
