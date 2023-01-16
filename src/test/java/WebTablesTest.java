import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebTablesTest {
    String url = "https://demoqa.com/webtables";
    String addButtonLocator = "//*[@id='addNewRecordButton']";
    String firstNameFieldLocator = "//*[@id='firstName']";
    String lastNameFieldLocator = "//*[@id='lastName']";
    String emailFieldLocator = "//*[@id='userEmail']";
    String ageFieldLocator = "//*[@id='age']";
    String salaryFieldLocator = "//*[@id='salary']";
    String departmentFieldLocator = "//*[@id='department']";
    String submitButtonLocator = "//*[@id='submit']";

    String firstName = "User";
    String lastName = "New";
    String email = "test@test.com";
    String age = "32";
    String salary = "1000";
    String department = "TestDep";

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
    public void webTablesTest(){
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath(addButtonLocator)).click();
        driver.findElement(By.xpath(firstNameFieldLocator)).sendKeys(firstName);
        driver.findElement(By.xpath(lastNameFieldLocator)).sendKeys(lastName);
        driver.findElement(By.xpath(emailFieldLocator)).sendKeys(email);
        driver.findElement(By.xpath(ageFieldLocator)).sendKeys(age);
        driver.findElement(By.xpath(salaryFieldLocator)).sendKeys(salary);
        driver.findElement(By.xpath(departmentFieldLocator)).sendKeys(department);
        driver.findElement(By.xpath(submitButtonLocator)).click();

    }
}
