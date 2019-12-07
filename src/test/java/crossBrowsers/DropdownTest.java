package crossBrowsers;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;

public class DropdownTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("https://the-internet.herokuapp.com/dropdown");
        selectAnOption("option 1");

    }

    public static void selectAnOption(String option) {
        Select select = new Select(Browser.find(How.ID, "dropdown"));

        String[] OPTIONS = {"Option 1","Option 2"};
        if(Arrays.stream(OPTIONS).anyMatch(o -> o.equals(option))){
            select.selectByVisibleText(option);
        }else {
            throw new IllegalArgumentException("The "+option+ " dose not exist!!");
        }
    }
}
