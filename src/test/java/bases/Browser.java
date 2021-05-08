package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
   private static WebDriver driver;

    public static void launch(String name){
        if (name.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }else if(name.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }else if(name.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            driver=  new InternetExplorerDriver();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
