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

    public static WebDriver open(String name) {
        switch (name.toLowerCase()) {
            case "ie":
                return new InternetExplorerDriver();
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                return new ChromeDriver();
            case "safari":
                return new SafariDriver();
            case "chrome_headless": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                return new ChromeDriver(chromeOptions);
            }
            case "firefox_headless": {
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                return new FirefoxDriver(firefoxOptions);
            }
            default:
                throw new IllegalStateException("Undefine browser : " + name);
        }

    }
}
