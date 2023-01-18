import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RadiobuttonTest {
    String url = "https://demoqa.com/radio-button";
    String radiobuttonsLocator = "//input[@type='radio']/../label";
    String yesRadiobuttonLocator = "//*[@id='yesRadio']";
    String impressiveRadiobuttonLocator = "//*[@id='impressiveRadio']";
    String noRadiobuttonLocator = "//input[@id='noRadio']";
    String resultTextLocator = "//*[@class='text-success']";
    String[] radiobuttons = {yesRadiobuttonLocator, impressiveRadiobuttonLocator, noRadiobuttonLocator};
    WebDriver driver;
    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void radiobuttonTest(){
        driver.get(url);
        driver.manage().window().maximize();
        enum Radiobutton{
            Yes,
            Impressive,
            No;
        }
        Random rnd = new Random();  //1 to 3
        List<WebElement> radiobuttons = driver.findElements(By.xpath(radiobuttonsLocator));
        //WebDriverWait wait = new WebDriverWait(driver, 3000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(radiobuttonsLocator)));
        radiobuttons.get(rnd.nextInt(radiobuttons.size())).click(); //save the selected value -> to enum(Yes, Impressive, No) -> compare with enum
        //xpath indexes from 1

        //driver.findElement(By.xpath(yesRadiobuttonLocator)).click();
        //String yesExpected = driver.findElement(By.xpath(yesRadiobuttonLocator)).getText();
        //String impressiveExpected = driver.findElement(By.xpath(impressiveRadiobuttonLocator)).getText();
        //String result = driver.findElement(By.xpath(resultTextLocator)).getText();
        //Assert.assertEquals(result, yesExpected);
    }

//    @AfterTest
//    public void teardownClass(){
//        WebDriverManager.chromedriver().quit();
//    }
}
