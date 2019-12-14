package crossBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;

public class TodoMVCTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("http://todomvc.com/examples/vanillajs");
        Browser.fill(How.CLASS_NAME,"new-todo","to do 1\n");
        Browser.fill(How.CLASS_NAME,"new-todo","to do 2\n");
        Browser.fill(How.CLASS_NAME,"new-todo","to do 3\n");

//        Browser.doubleClick(How.XPATH,"//label[.=\"to do 1\"]");
        Browser.hover(How.XPATH,"//label[.=\"to do 2\"]");
        Browser.click(How.XPATH,"//label[.=\"to do 2\"]/following-sibling::button");
//        Browser.fill(How.XPATH,"//label[.=\"to do 1\"]/../../input","task 1\n");
        Browser.captureScreenshot();
    }
}
