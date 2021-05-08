package testcases;

import bases.BaseTest;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {
    Actions mouse;
    WebDriverWait wait;

    @BeforeMethod
    void load() {
        WebDriverManager.chromedriver().setup();
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


}
