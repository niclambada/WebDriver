import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumWebDriver {

    public static WebDriver driver;
    public static WebElement searchInput;
    public static WebElement searchButton;
    public static WebElement searchSneakers;
    public static WebElement searchSizeButton;

    public static void initialization() {
        driver = new ChromeDriver();

        driver.get("https://nbalance.by/");
        driver.manage().window().maximize();

        searchInput = waitForElementLocatedBy(driver ,By.xpath("//input[@class = 'yith-s']"));
        searchInput.sendKeys("New Balance 574 Dark");
        searchButton = waitForElementLocatedBy(driver, By.xpath("//input[@id='yith-searchsubmit']"));
        searchButton.click();
        searchSneakers = waitForElementLocatedBy(driver, By.xpath("//a[contains(@class, 'woocommerce-LoopProduct-link') and h2[text() = 'New Balance 574 Dark']]"));
        searchSneakers.click();
        searchSizeButton = waitForElementLocatedBy(driver, By.xpath("//span[contains(@class, 'swatch-8-5')]"));
        searchSizeButton.click();
    }

    private static WebElement waitForElementLocatedBy(org.openqa.selenium.WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
