package openBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();// open browser
        driver.manage().window().maximize(); // maximize browser window
//        driver.navigate().to("https://google.com.vn"); // navigate to a url
        driver.get("https://google.com.vn");
        driver.get("https://www.selenium.dev");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        driver.close();// close session
//        driver.quit();

    }

}
