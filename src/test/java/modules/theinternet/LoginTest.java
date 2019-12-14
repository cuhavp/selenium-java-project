package modules.theinternet;

import org.openqa.selenium.support.How;
import supports.Browser;

public class LoginTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("https://the-internet.herokuapp.com/login");

        Browser.fill(How.ID, "username","tomsmith");
        Browser.fill(How.ID, "password","SuperSecretPassword!");
        Browser.click(How.CLASS_NAME, "radius");
    }
}
