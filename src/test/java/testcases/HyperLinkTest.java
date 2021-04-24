package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLinkTest {

    @Test
    void redirector(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/redirector");

        driver.findElement(By.linkText("here")).click();// <----
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/200");
        String content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 200 status code."));
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/404");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");
        driver.findElement(By.linkText("here")).click();

        driver.quit();
    }
}
