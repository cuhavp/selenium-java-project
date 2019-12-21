package modules.theinternet;

import org.openqa.selenium.support.How;
import supports.Browser;

public class CheckboxesTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("https://the-internet.herokuapp.com/checkboxes");

        Browser.check(How.XPATH, "//form[@id='checkboxes']/input[1]");
        Browser.check(How.XPATH, "//form[@id='checkboxes']/input[2]");
        Browser.uncheck(How.XPATH, "//form[@id='checkboxes']/input[2]");

    }
}
