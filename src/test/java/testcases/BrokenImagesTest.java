package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImagesTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void reloadPage() {
        driver.get("http://the-internet.herokuapp.com/broken_images");
    }

    @Test
    void tc01() {
        List<WebElement> images = driver.findElements(By.cssSelector("img"));
        for (WebElement image : images) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                System.out.println(image.getAttribute("outerHTML") + " is broken.");
            }
        }
    }


    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
