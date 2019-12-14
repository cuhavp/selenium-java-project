package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.How;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
        find(how, locator).clear();
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

    public static String text(How how, String locator){
        return find(how, locator).getText();
    }

    public static List<WebElement> all(How how,String locator){
        return driver.findElements(how.buildBy(locator));
    }

    public static void doubleClick(How how, String locator){
        Actions dbClick = new Actions(driver);
        dbClick.doubleClick(find(how, locator)).perform();
    }

    public static void hover(How how, String locator){
        Actions hover = new Actions(driver);
        hover.moveToElement(find(how, locator)).perform();
    }

    public static void captureScreenshot(){
       File screenShot =  ( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           try {
               FileUtils.copyFile(screenShot, new File("./target/screenshot-"+ System.currentTimeMillis()+".png"));
           } catch (IOException e) {
               e.printStackTrace();
           }
    }

    public static void close(){
        if(driver != null){
            driver.quit();
        }
    }

}
