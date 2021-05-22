package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String name) {
        Browser.launch(name);
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreen(ITestResult testResult) throws IOException {
        if(!testResult.isSuccess()){
            File file = ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.FILE);
            File DestFile=new File("./target/screenshot/"
                    +testResult.getMethod().getMethodName()
                    +  "-"
                    +System.currentTimeMillis()+".png");

            FileUtils.copyFile(file, DestFile);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        Browser.getDriver().quit();
    }
}
