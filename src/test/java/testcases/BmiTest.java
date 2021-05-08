package testcases;

import bases.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BmiPage;

public class BmiTest extends BaseTest {
    BmiPage bmiPage;
    @BeforeMethod
    void cleanUpForm() {
        bmiPage = new BmiPage();
        bmiPage.open();
        bmiPage.selectMetricTab();
        bmiPage.clear();
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
        bmiPage.calculate(age, gender, height, weight);
        Assert.assertTrue(bmiPage.getResult().contains(expected));
    }

}
