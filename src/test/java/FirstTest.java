import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {
    //Prepare the environment
    //Set the data
    //Action
    //Assertion
    WebDriver driver;

    @BeforeMethod
    void startUp() {
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com");
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

    @Test
    void testLogo() {
        //open a browser automated by code (selenium)
        //open trendyol.com
        //check the logo
        //check the url as https://www.trendyol.com/
        By logo = By.id("logo");
        WebElement logoElement = driver.findElement(logo);
        Assert.assertTrue(logoElement.isDisplayed());
    }

    @Test
    void testSearch() {
        //open a browser automated by code (selenium)
        //go to trendyol
        //search laptop
          //searchbox click
          //type laptop
          //click search icon
        //check if there are any results
        By searchBox = By.className("vQI670rJ");
        driver.findElement(searchBox)
                .sendKeys("laptop");

        By modalCloseButton = By.className("modal-section-close");
        driver.findElement(modalCloseButton).click();

        By searchIcon = By.className("ft51BU2r");
        driver.findElement(searchIcon).click();

        By productCard = By.className("product-card");
        WebElement productCardElement = driver.findElement(productCard);
        Assert.assertTrue(productCardElement.isDisplayed());
    }

    @Test
    void testKadin() {
        By modalCloseButton = By.className("modal-section-close");
        driver.findElement(modalCloseButton).click();

        By tab = By.className("tab-link");
        driver.findElement(tab).click();

        String cssValue = driver.findElement(tab).getAttribute("class");
        Assert.assertTrue(cssValue.contains("active"));
    }


    //homework: login scenario
}
