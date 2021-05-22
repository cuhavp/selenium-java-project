package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckboxesTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void reloadPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    void theCheckboxesShouldSelected() {
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        check(checkbox1);
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        check(checkbox2);
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected());
    }

    @Test
    void theCheckboxesShouldDeSelected() {
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        uncheck(checkbox1);
        Assert.assertFalse(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        uncheck(checkbox2);
        Assert.assertFalse(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected());
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }

    void check(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    void uncheck(WebElement checkbox) {
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
