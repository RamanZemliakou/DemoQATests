import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class RadiobuttonTest {
    String url = "https://demoqa.com/radio-button";
    String yesRadiobuttonLocator = "//*[@for='yesRadio']";
    String impressiveRadiobuttonLocator = "//*[@for='impressiveRadio']";
    String resultTextLocator = "//*[@class='text-success']";

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
    public void checkboxTest(){
        driver.get(url);
        driver.manage().window().maximize();
        Random rndButton = new Random();
        List<WebElement> radiobuttons = driver.findElements(By.xpath("//*[@for]"));
        radiobuttons.get(rndButton.nextInt(radiobuttons.size())).click();
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
