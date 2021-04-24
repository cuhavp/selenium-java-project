package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BmiTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    @BeforeMethod
    void cleanUpForm() {
        driver.findElement(By.xpath("//a[.='Metric Units']")).click();
        driver.findElement(By.className("clearbtn")).click();
    }

    @DataProvider
    Object[][] testdata(){
        return new Object[][]{
                new Object[]{"25" ,"male", "180" ,"65", "BMI = 20.1 kg/m2   (Normal)"},
                new Object[]{"25" ,"male", "180" ,"30", "BMI = 9.3 kg/m2   (Severe thinness)"},
                new Object[]{"25" ,"male", "180" ,"55", "BMI = 17 kg/m2   (Moderate thinness)"},
                new Object[]{"25" ,"male", "180" ,"60", "BMI = 18.5 kg/m2   (Mild thinness)"},
                new Object[]{"25" ,"male", "180" ,"85", "BMI = 26.2 kg/m2   (Overweight)"},
                new Object[]{"25" ,"male", "180" ,"100", "BMI = 30.9 kg/m2   (Obese Class I)"},
                new Object[]{"25" ,"male", "180" ,"120", "BMI = 37 kg/m2   (Obese Class II)"},
                new Object[]{"25" ,"male", "180" ,"140", "BMI = 43.2 kg/m2   (Obese Class III)"},
                new Object[]{"25" ,"female", "180" ,"65", "BMI = 20.1 kg/m2   (Normal)"},
                new Object[]{"25" ,"female", "180" ,"30", "BMI = 9.3 kg/m2   (Severe thinness)"},
                new Object[]{"25" ,"female", "180" ,"55", "BMI = 17 kg/m2   (Moderate thinness)"},
                new Object[]{"25" ,"female", "180" ,"60", "BMI = 18.5 kg/m2   (Mild thinness)"},
                new Object[]{"25" ,"female", "180" ,"85", "BMI = 26.2 kg/m2   (Overweight)"},
                new Object[]{"25" ,"female", "180" ,"100", "BMI = 30.9 kg/m2   (Obese Class I)"},
                new Object[]{"25" ,"female", "180" ,"120", "BMI = 37 kg/m2   (Obese Class II)"},
                new Object[]{"25" ,"female", "180" ,"140", "BMI = 43.2 kg/m2   (Obese Class III)"}
        };
    }

    @Test(dataProvider ="testdata" )
    void tc01(String age,String gender,String height,String weight,String expected) {
        driver.findElement(By.id("cage")).sendKeys(age);

        if (gender.equalsIgnoreCase("male")){
            driver.findElement(By.id("csex1")).click();
        }else  driver.findElement(By.id("csex2")).click();

        driver.findElement(By.id("cheightmeter")).sendKeys(height);
        driver.findElement(By.id("ckg")).sendKeys(weight);
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        String actualResult = driver.findElement(By.className("rightresult")).getText();
        Assert.assertTrue(actualResult.contains(expected));
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
