package openBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {
    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =  new FirefoxDriver();
    }
}
