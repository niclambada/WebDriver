import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebDriverTest  extends SeleniumWebDriver {

    @BeforeTest
    public void setup() {
        initialization();
    }

    @Test
    public void shouldBeSelectSizeTest() {
        WebElement actualSize = driver.findElement(By.xpath("//span[contains(@class, 'swatch-8-5')]"));
        WebElement selectedSize = driver.findElement(By.xpath("//span[contains(@class, 'selected')]"));
        Assert.assertEquals(actualSize, selectedSize);
    }

    @Test
    public void verifySneakersName() {
        WebElement sneakersName = driver.findElement(By.xpath("//h1[@class = 'product_title entry-title' and text() ='New Balance 574 Dark']"));
        String txt = sneakersName.getText();
        Assert.assertTrue(sneakersName.getText().contains("New Balance 574 Dark"));
    }

    @AfterClass
    public void shutdown() {
        driver.quit();
    }
}
