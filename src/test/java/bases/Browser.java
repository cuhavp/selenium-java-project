package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Browser {
    private static WebDriver driver;
    public static Actions mouse;
    public static WebDriverWait wait;

    public static void launch(String name) {
        if (name.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (name.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (name.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        mouse = new Actions(getDriver());
        wait = new WebDriverWait(getDriver(), 30);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static void fill(By locator, String withText) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(withText);
    }

    public static WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public static void click(By locator) {
        driver.findElement(locator).click();
    }

    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public static void hover(By locator) {
        mouse.moveToElement(find(locator)).perform();
    }

    public static List<WebElement> all(By locator) {
        return driver.findElements(locator);
    }

    public static int count(By locator) {
        return all(locator).size();
    }

    void check(By checkbox) {
        if (!find(checkbox).isSelected()) {
            click(checkbox);
        }
    }

    void uncheck(By checkbox) {
        if (find(checkbox).isSelected()) {
            click(checkbox);
        }
    }

}
