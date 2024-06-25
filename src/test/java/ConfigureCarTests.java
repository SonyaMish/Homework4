import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ConfigureCarTests extends BaseTests {
    @Override
    protected String getUrl() {
        return "http://pragmatic.bg/automation/lecture13/Config.html";
    }

    @Test
    public void testOptionalFeaturesCheckbox(){
        WebElement abs = driver.findElement(By.name("abs"));
        WebElement airBags = driver.findElement(By.name("airbags"));
        WebElement parkingSensor = driver.findElement(By.name("parksensor"));
        WebElement ledHeadLamp = driver.findElement(By.name("ledheadlamp"));

        Actions builder = new Actions(driver);

        if (!airBags.isSelected()) {
            builder.click(airBags);
        }
        if (!parkingSensor.isSelected()) {
            builder.click(parkingSensor);
        }
        if (abs.isSelected()){
            builder.click(abs);
        }
        if (ledHeadLamp.isSelected()){
            builder.click(ledHeadLamp);
        }

        builder.perform();

        softAssert.assertTrue(airBags.isSelected());
        softAssert.assertTrue(parkingSensor.isSelected());
        softAssert.assertFalse(abs.isSelected());
        softAssert.assertFalse(ledHeadLamp.isSelected());

        softAssert.assertAll();
    }
}
