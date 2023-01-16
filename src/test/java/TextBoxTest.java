import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextBoxTest {
    String url = "https://demoqa.com/text-box";
    String fullNameLocator = "//*[@id='userName']";
    String eMailLocator = "//*[@id='userEmail']";
    String currentAddressLocator = "//*[@id='currentAddress']";
    String permanentAddressLocator = "//*[@id='permanentAddress']";
    String submitButtonLocator = "//*[@id='submit']";
    String outputFieldLocator = "//*[@id='output']";
    String outputAddressLocator = "//p[@id='currentAddress']";


    String userName = "New User";
    String userEmail = "mail@mail.com";
    String currentAddress = "Belarus, Minsk";
    String permanetAddress = "some other address";

    WebDriver driver;
    @Parameters({"userName"})
    @BeforeSuite
    public void setupClass(@Optional("Test") String userName) {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
    }



    @Test(description = "Compare actual and expected Address", priority = 1)
    public void textBoxTest(){
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath(fullNameLocator)).sendKeys(userName);
        driver.findElement(By.xpath(eMailLocator)).sendKeys(userEmail);
        driver.findElement(By.xpath(currentAddressLocator)).sendKeys(currentAddress);
        driver.findElement(By.xpath(permanentAddressLocator)).sendKeys(permanetAddress);
        driver.findElement(By.xpath(submitButtonLocator)).click();
        String outputAddress = driver.findElement(By.xpath(outputAddressLocator)).getText();

        Assert.assertEquals(outputAddress, "Current Address :" + currentAddress);
        driver.quit();
    }

    @AfterTest
    public void teardownClass(){
        WebDriverManager.chromedriver().quit();
    }
}
