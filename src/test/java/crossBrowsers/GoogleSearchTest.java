package crossBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;

public class GoogleSearchTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("https://google.com");
        WebDriver driver = Browser.getDriver();
/**
 * 1. tagName: input
 * 2. Attributes: name, title, arial-label
 * 3. text: N/A
 */
        driver.findElement(By.name("q")).sendKeys("selenium");
        Browser.find(How.NAME,"q").sendKeys("selenium");
        driver.findElement(By.tagName("input")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("selenium");
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
        driver.findElement(By.cssSelector("input[name=q]")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@title=\"Search\"]")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@aria-label=\"Search\"]")).sendKeys("selenium");
    }
}
