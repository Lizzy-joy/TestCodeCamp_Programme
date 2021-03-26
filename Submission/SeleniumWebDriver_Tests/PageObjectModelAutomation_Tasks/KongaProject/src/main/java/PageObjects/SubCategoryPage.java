package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage {

    private final WebDriver driver;
    private final By searchBar=By.xpath("//*[@id=\"jsSearchInput\"]");
    private final By searchButton=By.className("fdd83_39Iap");
    //Elem
    // ent on the search were more than 1
    int searchBarElementID=1;


    public SubCategoryPage(WebDriver driver)
    {
        this.driver=driver;

    }


    public void  searchForAnItem(String item)
    {
        //Search for item on the search bar
        driver.findElements(searchBar).get(searchBarElementID).sendKeys(item);

    }

    public SearchPage clickSearchButton() throws InterruptedException {
        //Click on the search Button on the search Bar
        driver.findElements(searchButton).get(searchBarElementID).click();
        Thread.sleep(5000);
        return new SearchPage(driver);

    }
}
