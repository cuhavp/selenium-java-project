package modules.crossBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeMobileViewModeTest {
    public static void main(String[] args) {

// DeviceName = "Google Nexus 5";
// DeviceName = "Samsung Galaxy S4";
// DeviceName = "Samsung Galaxy Note 3";
// DeviceName = "Samsung Galaxy Note II";
// DeviceName = "Apple iPhone 4";
      String  DeviceName = "Apple iPhone 5";
// DeviceName = "Apple iPad 3 / 4";
// String ChromeDriverPath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
// System.setProperty("webdriver.chrome.driver", ChromeDriverPath);

        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", DeviceName);

        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.s


        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.google.com");

    }
}
