package pages;

import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPage extends BasePage {

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

    public void open(){
        visit("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password){
        fill(usernameTxt,username);
        fill(passwordTxt,password);
        click(submitBtn);
    }
}
