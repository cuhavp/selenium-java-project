package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPage {
    WebDriver driver;

    /**
     * Suffix:
     * txt --> text box
     * btn --> button
     * lbl --> label
     * rad --> radio Button
     * chk --> checkbox
     * .....
     */
    By usernameTxt = By.id("username");
    By passwordTxt = By.id("password");
    By submitBtn = By.xpath("//*[@type='submit']");

    public FormAuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password){
        driver.findElement(usernameTxt).sendKeys(username);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(submitBtn).click();
    }
}
