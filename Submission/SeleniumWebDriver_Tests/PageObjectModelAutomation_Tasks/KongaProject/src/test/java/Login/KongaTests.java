package Login;

import PageObjects.*;
import Setup.SetsUpTests;
import org.testng.annotations.Test;

public class KongaTests extends SetsUpTests {

    @Test
    public void testLoginPage()
    {
        int addToCartButtonID=1;
        int numberOfItems=4;

        try {//sign in to Konga website
            LoginPage loginPage= homepage.clickloginSignUpButton();
            //enter the username and password string with valid user details
            loginPage.enterusername("alolaelizabeth12@gmail.com");
            loginPage.enterPassword("jesubet13");
            homepage = loginPage.clickLoginButton();
            //select any categories and the subcategory
            SubCategoryPage subCategoryPage = homepage.clickCategoryAndSub();
            //use the search box to search for an item
            subCategoryPage.searchForAnItem("Macbook");
            SearchPage searchPage = subCategoryPage.clickSearchButton();
            //click on the add to Cart button
            searchPage.clickonAddToCart(addToCartButtonID);
            //click on my Cart Menu
            AddToCartPage addToCartPage = searchPage.clickmyCartButton();
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
            System.out.println(checkOutPage.invalid_Message());
        }catch (InterruptedException e){
            //Todo Auto-Generated catch block
            e.printStackTrace();
        }



    }

}
