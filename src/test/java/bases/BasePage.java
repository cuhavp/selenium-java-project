package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static bases.Browser.getDriver;

public abstract class BasePage {
    protected Actions mouse;
    protected WebDriverWait wait;

    public BasePage() {
        mouse = new Actions(getDriver());
        wait = new WebDriverWait(getDriver(),30);
    }

    public void visit(String url){
        getDriver().get(url);
    }

    public void fill(By locator, String withText){
        getDriver().findElement(locator).clear();
        getDriver().findElement(locator).sendKeys(withText);
    }

    public void click(By locator){
        getDriver().findElement(locator).click();
    }

    public String getText(By locator){
        return getDriver().findElement(locator).getText();
    }

    public abstract void open() ;
}
