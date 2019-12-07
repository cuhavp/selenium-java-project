package crossBrowsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static crossBrowsers.Browser.*;

public class ChromeTest {
    public static void main(String[] args) {
        open("chrome");
        visit("https://google.com");

    }
}
