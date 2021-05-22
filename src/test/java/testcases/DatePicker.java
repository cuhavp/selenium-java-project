package testcases;

import helper.DateUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DatePicker {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    void ticketPage(){
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        //Accept cookie footer pop up
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("cookie-agree"))).get(0).click();
        // select depart date
        driver.findElement(By.id("roundtrip-date-depart")).click();
        WebElement dateWidgetFrom = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar"))).get(0);

        // This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        DateUtils.clickGivenDay(columns, DateUtils.getCurrentDay());
        //close date pickper
        driver.findElement(By.className("ui-datepicker-close")).click();

    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
