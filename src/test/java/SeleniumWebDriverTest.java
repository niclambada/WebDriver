import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebDriverTest  extends SeleniumWebDriver {

    @BeforeTest
    public void setUp() {
        initialization();
    }

    @Test
    public void shouldBeSelectConverseSizeTest() {
        WebElement actualSize = driver.findElement(By.xpath("//span[contains(@class, 'swatch-8-5')]"));
        WebElement selectedSize = driver.findElement(By.xpath("//span[contains(@class, 'selected')]"));
        WebElement sneakersName = driver.findElement(By.xpath("//h1[@class = 'product_title entry-title' and text() ='New Balance 574 Dark']"));
        String txt = sneakersName.getText();
        Assert.assertEquals(actualSize, selectedSize);
        Assert.assertTrue(sneakersName.getText().contains("New Balance 574 Dark"));
    }

    @AfterClass
    public void shutdown() {
        driver.quit();
    }
}
