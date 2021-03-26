package konga;

import org.testng.annotations.Test;
import pageObjects.*;
import setup.SetupTests;

public class KongaTests extends SetupTests {

    @Test
    public void testLoginPage()

    {
        int addToCartButtonID = 1;
        int itemCount = 4;

        try {//sign in to Konga website
            LoginPage loginPage= HomePage.clickLoginSignUpButton();
            //enter the username and password string with valid user details
            loginPage.enterUsername("alolaelizabeth12@gmail.com");
            loginPage.enterPassword("jesubet13");
            HomePage homePage = loginPage.clickLoginButton();
            //select any categories and the subcategory
            SubCategoryPage subCategoryPage = HomePage.clickCategoryAndSub();
            //use the search box to search for an item
            subCategoryPage.searchForAnItem("Macbook");
            SearchPage searchPage = subCategoryPage.clickSearchButton();
            //click on the add to Cart button
            searchPage.clickOnAddToCart(addToCartButtonID);
            //click on my Cart Menu
            AddToCartPage addToCartPage = searchPage.clickMyCartButton();
            //Click on checkout
            CheckOutPage checkOutPage = addToCartPage.clickCheckOut();
            //select pay now option to continue payment
            checkOutPage.clickOnPayNow();
            //click on the continue button to proceed to payment
            checkOutPage.clickContinueToPayment();
            //select the card method payment
            checkOutPage.clickOnPaymentType();
            //insert a invalid card number,date,Cvv and pin
            checkOutPage.enterCardDetails("5423456789902346", "11/20", "219");
            //print the error message for the card number field
            System.out.println(checkOutPage.invalid_message());
        }catch (InterruptedException e){

            /* Todo Auto-Generated catch block */
            e.printStackTrace();
        }

    }

}
