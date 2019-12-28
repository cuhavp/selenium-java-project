package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import supports.Browser;

public class BmiFunction extends LoadableComponent<BmiFunction> {
    /**
     * Txt --> text field
     * Btn --> button
     * Rad --> radio button
     * Lbl --> label
     */
    private By metricTab = By.xpath("//a[.='Metric Units']");
    private By ageTxt = By.id("cage");
    private By maleRad = By.id("csex1");
    private By femaleRad = By.id("csex2");
    private By heightTxt = By.id("cheightmeter");
    private By weightTxt = By.id("ckg");
    private By calculateBtn = By.xpath("//input[@alt='Calculate']");
    private By resultLbl = By.className("bigtext");

    @Override
    public void load() {
        Browser.visit("https://www.calculator.net/bmi-calculator.html");
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public void selectMetricTab() {
        Browser.click(metricTab);
    }

    public void fillCalculatorForm(String age, String gender, String height, String weight) {
        Browser.fill(ageTxt, age);
        if (gender.equalsIgnoreCase("male")) Browser.click(maleRad);
        else Browser.click(femaleRad);

        Browser.fill(heightTxt, height);
        Browser.fill(weightTxt, weight);
        Browser.click(calculateBtn);
    }

    public void shouldHaveResult(String expected) {
        String result = Browser.text(resultLbl);
        Assert.assertEquals(result, expected);
    }

}
