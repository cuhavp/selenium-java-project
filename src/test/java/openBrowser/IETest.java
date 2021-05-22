package openBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IETest {
    public static void main(String[] args) {
        WebDriverManager.iedriver().setup();
        new InternetExplorerDriver();
    }
}
