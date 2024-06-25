import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public abstract class BaseTests {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    protected abstract String getUrl();

    @BeforeMethod
    protected void setUp() {
        softAssert = new SoftAssert();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getUrl());
    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }
}