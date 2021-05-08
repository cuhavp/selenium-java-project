package testcases;

import bases.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class HoverTest extends BaseTest {
    Actions mouse;

    @BeforeMethod
    void load() {
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

}
