package crossBrowsers;

import org.openqa.selenium.support.How;

public class IFrameTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("https://the-internet.herokuapp.com/iframe");
        Browser.getDriver().switchTo().frame(Browser.find(How.ID,"mce_0_ifr"));
        Browser.find(How.TAG_NAME,"p").clear();
        Browser.fill(How.ID,"tinymce","hello");
    }
}
