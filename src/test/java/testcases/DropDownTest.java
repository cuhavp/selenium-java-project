package testcases;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest  extends BaseTest {

    @BeforeMethod
    void load(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    void option1ShouldSelected(){
        WebElement select = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(select);

        dropdown.selectByVisibleText("Option 1"); // text()

        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[.='Option 1']")).isSelected());// text()
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[text()='Option 1']")).isSelected());// text()
    }

}
