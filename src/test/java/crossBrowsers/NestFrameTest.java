package crossBrowsers;

import org.openqa.selenium.support.How;

public class NestFrameTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("https://the-internet.herokuapp.com/nested_frames");
        String text = "";


//        Browser.getDriver().switchTo().frame("frame-top");
//        Browser.getDriver().switchTo().frame(0);
//        Browser.getDriver().switchTo().frame(Browser.find(How.XPATH,"//frameset"));
        Browser.getDriver().switchTo().frame("frame-left");
        text = Browser.text(How.XPATH, "html/body");
        System.out.println(text);


        Browser.getDriver().switchTo().parentFrame();
        Browser.getDriver().switchTo().frame("frame-middle");
        text = Browser.text(How.XPATH, "html/body");
        System.out.println(text);

        Browser.getDriver().switchTo().parentFrame();
        Browser.getDriver().switchTo().frame("frame-right");
        text = Browser.text(How.XPATH, "html/body");
        System.out.println(text);


        Browser.getDriver().switchTo().parentFrame();
        Browser.getDriver().switchTo().parentFrame();


        Browser.getDriver().switchTo().frame("frame-bottom");
//        Browser.getDriver().switchTo().frame(1);
        text = Browser.text(How.XPATH, "html/body");
        System.out.println(text);
    }
}
