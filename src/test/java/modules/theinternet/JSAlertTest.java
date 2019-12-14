package modules.theinternet;

import org.openqa.selenium.support.How;
import supports.Browser;

public class JSAlertTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("https://the-internet.herokuapp.com/javascript_alerts");
//        Browser.click(How.XPATH,"//button[.='Click for JS Alert']");
//        Browser.click(How.XPATH,"//button[.='Click for JS Confirm']");
        Browser.click(How.XPATH,"//button[.='Click for JS Prompt']");
        Browser.getDriver().switchTo().alert().sendKeys("Hello Moto");
        Browser.getDriver().switchTo().alert().accept();
    }
}
