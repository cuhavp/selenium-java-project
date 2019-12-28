package modules.bmi;

import configurations.BaseTest;
import libraries.BmiFunction;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class CalculatorTest extends BaseTest {
    public BmiFunction bmiPage;

    @BeforeClass
    public void setUp() {
        bmiPage = new BmiFunction();
        bmiPage.load();
        bmiPage.selectMetricTab();
    }

    @DataProvider(name = "BmiData")
    public Object[][] testData() {
        return new Object[][]{
                {"25", "male", "180", "64", "BMI = 20.1 kg/m2   (Normal)"},
                {"25", "male", "180", "54", "BMI = 20.1 kg/m2   (Normal)"},
                {"25", "male", "180", "44", "BMI = 20.1 kg/m2   (Normal)"},
                {"25", "male", "180", "34", "BMI = 20.1 kg/m2   (Normal)"},
                {"25", "male", "180", "24", "BMI = 20.1 kg/m2   (Normal)"},
        };
    }


    @Test(dataProvider = "BmiData")
    public void TC01(String age, String gender, String height, String weight, String expectedResult) {
        bmiPage.fillCalculatorForm(age, gender, height, weight);
        bmiPage.shouldHaveResult(expectedResult);
    }


}
