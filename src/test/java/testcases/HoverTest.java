package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HoverTest {
    WebDriver driver;
    Actions mouse;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        mouse = new Actions(driver);
    }

    @DataProvider
    Object[][] avatar() {
        return new Object[][]{
                new Object[]{0, "name: user1"},
                new Object[]{1, "name: user2"},
                new Object[]{2, "name: user3"},
        };
    }

    @Test(dataProvider = "avatar")
    void avatarCaption(int personIndex, String caption) {
        WebElement person1 = driver.findElements(By.className("figure")).get(personIndex);
        mouse.moveToElement(person1).perform(); // --> hover

        WebElement person1Caption = person1
                .findElement(By.className("figcaption"))
                .findElement(By.tagName("h5"));

        Assert.assertEquals(person1Caption.getText(), caption);
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
