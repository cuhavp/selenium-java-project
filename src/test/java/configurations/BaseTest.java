package configurations;

import libraries.BmiFunction;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser) {
        Browser.open(browser);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(!result.isSuccess()) Browser.captureScreenshot();// capture screenshot when test failed.
    }

    @AfterTest
    public void close(){
        Browser.close();
    }
}
