package testcases;

import bases.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormAuthenticationPage;

public class FormAuthenticationTest extends BaseTest {

    FormAuthenticationPage formAuthenticationPage;

    @BeforeClass
    void setup() {
        formAuthenticationPage = new FormAuthenticationPage(driver);
    }

    @BeforeMethod
    void load() {
        formAuthenticationPage.open();
    }

    @Test
    void validCredential() {
        formAuthenticationPage.login("tomsmith", "SuperSecretPassword");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.id("flash-messages")).isDisplayed()); //You logged into a secure area!
    }

    @Test
    void invalidCredential() {
        formAuthenticationPage.login("tomsmith", "SuperSecretPassword");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("error")).isDisplayed());
    }

//    @AfterClass
//    void tearDown() {
//        driver.quit();
//    }

}
