package crossBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.How;

public class Browser {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void open(String name) {
        switch (name.toLowerCase()) {
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "chrome_headless": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox_headless": {
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            default:
                throw new IllegalStateException("Undefine browser : " + name);
        }

    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static void navigate(String url) {
        driver.navigate().to(url);
    }

    public static void reloadPage() {
        driver.navigate().refresh();
    }

    public static void backToPreviousPage() {
        driver.navigate().back();
    }

    public static WebElement find(How how, String locator) {
        return driver.findElement(how.buildBy(locator));
    }

    public static void fill(How how, String locator,String withText){
        find(how, locator).sendKeys(withText);
    }

    public static void click(How how, String locator){
        find(how, locator).click();
    }

    public static void check(How how, String locator){
        if(!find(how, locator).isSelected()){
            click(how, locator);
        }
    }
    
    public static void uncheck(How how, String locator){
        if(find(how, locator).isSelected()){
            click(how, locator);
        }
    }

}
