package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenuTest {
    WebDriver driver;
    Actions mouse;
    WebDriverWait wait;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        mouse = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    void shouldJSAlertPopupAppear(){
        WebElement rectangle = driver.findElement(By.id("hot-spot"));
        mouse.contextClick(rectangle).perform();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"You selected a context menu");
        alert.accept();
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
