package openBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IETest {
    public static void main(String[] args) {
//        System.setProperty("webdriver.ie.driver","");
        WebDriverManager.iedriver().setup();
        new InternetExplorerDriver();
    }
}
