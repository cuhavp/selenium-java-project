package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }
//    Open browser
//    Navigate to https://the-internet.herokuapp.com/tables


//    Focus on table 1
//    The person who has largest due is "Doe Jacson"

    @Test
    void largestDuePerson(){

        String maximumDuePerson = "";

        List<WebElement> dues = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
        float maxDueValue = Float.parseFloat(dues.get(0).getText().replace("$", ""));

        for(int i=1;i<dues.size();i++){
            float dueValue = Float.parseFloat(dues.get(i).getText().replace("$", ""));
            if(dueValue >maxDueValue){
                maxDueValue = dueValue;
            }
        }
        System.out.printf("Maximum due is %f",maxDueValue);


        List<WebElement> rows =driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String firstName = cells.get(1).getText();
            String lastName = cells.get(0).getText();
            String fullName = String.format("%s %s",firstName,lastName);
            float due = Float.parseFloat(cells.get(3).getText().replace("$",""));
            if (due == maxDueValue){
                maximumDuePerson = fullName;
                System.out.printf("Larges Due person is %s",fullName);
            }
        }

        Assert.assertEquals(maximumDuePerson,"Jason Doe");
    }
}
