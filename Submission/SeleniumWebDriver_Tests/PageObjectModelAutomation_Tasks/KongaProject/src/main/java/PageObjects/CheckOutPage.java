package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {

    private final WebDriver driver;
    private final By payNowButton=By.xpath("//*[@id=\"mainContent\"]/form/div/section/div/div[4]/form/ul/li/div/button");
    private final By continuetoPayPaymentButton=By.xpath("//*[@id=\"mainContent\"]/form/div/section/div/div[9]/div/button");
    private final By checkOut_iframe=By.xpath("//*[@id='kpg-frame-component']");
    private final By cardButton=By.cssSelector(".card");
    private final By cardNumberField=By.xpath("//*[@id=\"card-number\"]");
    private final By datefield =By.id("expiry");
    private final By cvvfield = By.id("CVV");
    private final By invalidMessage =By.xpath("//*[@id=\"card-number_unhappy\"]");


    public  CheckOutPage (WebDriver driver)
    {
        this.driver=driver;

    }
    public void clickOnPayNow()
    {
        driver.findElement(payNowButton).click();

    }

    public void clickContinueToPayment() throws InterruptedException {
        driver.findElements(continuetoPayPaymentButton).get(1).click();
        Thread.sleep(1000);


    }

    //select the payment Type
    public void clickOnPaymentType() throws InterruptedException {
        WebElement checkOutFrame=driver.findElement(checkOut_iframe);
        //switch to iframe
        driver.switchTo().frame(checkOutFrame);
        driver.findElement(cardButton).click();
        Thread.sleep(3000);

    }
    //Enter card details
    public  void enterCardDetails(String cardnumber ,String date, String cvv)
    {
        driver.findElement(cardNumberField).sendKeys(cardnumber);
        driver.findElement(datefield).sendKeys(date);
        driver.findElement(cvvfield).sendKeys(cvv);

    }

    //Return user invalid message
    public String invalid_Message()
    {
        return driver.findElement(invalidMessage).getText();

    }

}
