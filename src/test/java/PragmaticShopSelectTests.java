import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class PragmaticShopSelectTests extends BaseTests{

    @Override
    protected String getUrl() {
        return "https://shop.pragmatic.bg/admin/";
    }

    @Test
    public void testOrderStatusDropdown() {
        WebElement usernameInputElement = driver.findElement(By.id("input-username"));
        WebElement passwordInputElement = driver.findElement(By.id("input-password"));
        usernameInputElement.sendKeys("admin");
        passwordInputElement.sendKeys("parola123!");
        WebElement loginButton = driver.findElement((By.className("fa-key")));//.btn
        loginButton.click();

        WebElement salesMenu = driver.findElement(By.id("menu-sale"));
        salesMenu.click();

        WebElement orders = driver.findElement(By.xpath("//li[@id='menu-sale']//a[contains(@href, 'order')]"));
        orders.click();

        WebElement orderStatus = driver.findElement(By.id("input-order-status"));
        Select orderStatusSelect = new Select(orderStatus);
        List<WebElement> orderStatusOptions = orderStatusSelect.getOptions();

        List<String> actualOrderStatusOptions = new ArrayList<String>();
        for (WebElement orderStatusOption : orderStatusOptions) {
            actualOrderStatusOptions.add(orderStatusOption.getText());
        }

        List<String> expectedOrderStatusOptions =
                List.of("", "Missing Orders", "Canceled", "Canceled Reversal","Chargeback", "Complete", "Denied", "Expired", "Failed", "Pending", "Processed", "Processing", "Refunded", "Reversed", "Shipped", "Voided");

        assertEquals(actualOrderStatusOptions, expectedOrderStatusOptions, "Order status dropdown options do not match expected values.");
    }
}