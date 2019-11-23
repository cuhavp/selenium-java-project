package crossBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
    private static WebDriver driver;

    public static void open(String name) {
        switch (name.toLowerCase()) {
            case "ie":
                driver= new InternetExplorerDriver();
            case "edge":
                driver= new EdgeDriver();
            case "firefox":
                driver= new FirefoxDriver();
            case "chrome":
                driver= new ChromeDriver();
            case "safari":
                driver= new SafariDriver();
            case "chrome_headless": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver= new ChromeDriver(chromeOptions);
            }
            case "firefox_headless": {
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                driver= new FirefoxDriver(firefoxOptions);
            }
            default:
                throw new IllegalStateException("Undefine browser : " + name);
        }

    }

    public static void visit(String url){
        driver.get(url);
    }

    public static void navigate(String url){
        driver.navigate().to(url);
    }

    public static void reloadPage(){
        driver.navigate().refresh();
    }
    public static void backToPreviousPage(){
        driver.navigate().back();
    }
}
