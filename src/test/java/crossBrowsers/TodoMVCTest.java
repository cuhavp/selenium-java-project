package crossBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TodoMVCTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("http://todomvc.com/examples/vanillajs");
        WebDriver driver = Browser.getDriver();
        /**
         * 1. tagName: input
         * 2. attr: class, placeholder
         * 3. text: N/A
//         */
//        driver.findElement(By.tagName("input")).sendKeys("to do 1");
//        driver.findElement(By.xpath("//input")).sendKeys("to do 1");
//        driver.findElement(By.cssSelector("input")).sendKeys("to do 1");
        driver.findElement(By.className("new-todo")).sendKeys("to do 1\n");
//        driver.findElement(By.cssSelector(".new-todo")).sendKeys("to do 1");
//        driver.findElement(By.cssSelector("input.new-todo")).sendKeys("to do 1");
//        driver.findElement(By.xpath("//*[@class=\"new-todo\"]")).sendKeys("to do 1");
//        driver.findElement(By.xpath("//input[@class=\"new-todo\"]")).sendKeys("to do 1");
//        driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys("to do 1");
//        driver.findElement(By.xpath("//input[contains(@placeholder,'What needs to be done')]")).sendKeys("to do 1");
//        driver.findElement(By.xpath("//label[.=\"to do 1\"]/../input")).click();
        driver.findElement(By.xpath("//label[text()=\"to do 1\"]/preceding-sibling::input")).click();
        driver.findElement(By.xpath("//label[.=\"to do 1\"]/following-sibling::button")).click();
    }
}
