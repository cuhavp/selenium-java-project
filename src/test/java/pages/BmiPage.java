package pages;

import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static bases.Browser.*;

public class BmiPage extends BasePage {
    By metricTab = By.xpath("//a[.='Metric Units']");
    By ageTxt = By.id("cage");
    By maleRad = By.id("csex1");
    By femaleRad = By.id("csex2");
    By heightTxt = By.id("cheightmeter");
    By weightTxt = By.id("ckg");
    By calculateBtn = By.xpath("//input[@value='Calculate']");
    By clearBtn = By.className("clearbtn");
    By resultLbl = By.className("rightresult");


    public void open(){
        visit("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricTab(){
        click(metricTab);
    }
    public void calculate(String age,String gender,String height,String weight){
        fill(ageTxt,age);
        if (gender.equalsIgnoreCase("male")){
            click(maleRad);
        }else  click(femaleRad);

        fill(heightTxt,height);
        fill(weightTxt,weight);
        click(calculateBtn);

    }

    public void clear(){
      click(clearBtn);
    }

    public String getResult(){
        return getText(resultLbl);
    }
}
