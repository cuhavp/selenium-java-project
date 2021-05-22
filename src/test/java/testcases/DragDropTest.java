package testcases;

import bases.BaseTest;
import bases.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDropTest extends BaseTest {
    @BeforeMethod
    void init(){
        Browser.visit("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void action(){
      WebElement rectangleA = Browser.find(By.id("column-a"));
        WebElement rectangleB = Browser.find(By.id("column-b"));
        Browser.mouse.clickAndHold(rectangleA)
                .moveToElement(rectangleB).perform();
    };
}
