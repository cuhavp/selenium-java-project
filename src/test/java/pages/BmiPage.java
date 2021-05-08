package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BmiPage {
    WebDriver driver;
    By metricTab = By.xpath("//a[.='Metric Units']");
    By ageTxt = By.id("cage");
    By maleRad = By.id("csex1");
    By femaleRad = By.id("csex2");
    By heightTxt = By.id("cheightmeter");
    By weightTxt = By.id("ckg");
    By calculateBtn = By.xpath("//input[@value='Calculate']");
    By clearBtn = By.className("clearbtn");
    By resultLbl = By.className("rightresult");

    public BmiPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricTab(){
        driver.findElement(metricTab).click();
    }
    public void calculate(String age,String gender,String height,String weight){
        driver.findElement(ageTxt).sendKeys(age);
        if (gender.equalsIgnoreCase("male")){
            driver.findElement(maleRad).click();
        }else  driver.findElement(femaleRad).click();

        driver.findElement(heightTxt).sendKeys(height);
        driver.findElement(weightTxt).sendKeys(weight);
        driver.findElement(calculateBtn).click();
    }

    public void clear(){
        driver.findElement(clearBtn).click();
    }

    public String getResult(){
        return driver.findElement(resultLbl).getText();
    }
}
