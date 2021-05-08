package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NestFramesTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames"); //original page
    }

    @Test
    void listAllFrames(){
       driver.switchTo().frame("frame-top"); // is frame-top

       driver.switchTo().frame("frame-left"); // is frame-left
       String leftFrame = driver.findElement(By.xpath("html/body")).getText();
        Assert.assertEquals(leftFrame,"LEFT");
        driver.switchTo().parentFrame();// back to parent is frame-top

        driver.switchTo().frame("frame-middle");
        String middleFrame = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(middleFrame,"MIDDLE");
        driver.switchTo().parentFrame(); // back to parent is frame-top

        driver.switchTo().frame("frame-right");
        String rightFrame = driver.findElement(By.xpath("html/body")).getText();
        Assert.assertEquals(rightFrame,"RIGHT");
        driver.switchTo().parentFrame();// back to parent is frame-top

        driver.switchTo().parentFrame();// back to parent is original page
        driver.switchTo().frame("frame-bottom");
        String bottomFrame = driver.findElement(By.xpath("html/body")).getText();
        Assert.assertEquals(bottomFrame,"BOTTOM");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}