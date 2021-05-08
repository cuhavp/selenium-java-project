package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TableTest {
    WebDriver driver;
    List<Person> persons;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        persons = rows.stream()
                .map(this::toPerson).collect(Collectors.toList());

    }

    @Test
    void largestDuePerson(){
        Person largestDuePerson = persons
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);

        Assert.assertEquals(String.format("%s %s", largestDuePerson.getLastName(), largestDuePerson.getFirstName()), "Jason Doe");
    }

    @Test
    void smallestDuePerson(){
        Person smallestDuePerson = persons
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);

        Assert.assertEquals(String.format("%s %s", smallestDuePerson.getLastName(), smallestDuePerson.getFirstName()), "Jason Doe");
    }

    /**
     * element is a row in table
     * @param element
     * @return
             */
    private Person toPerson(WebElement element) {
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstname = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        float due = Float.parseFloat(element.findElements(By.tagName("td")).get(3).getText().trim().replace("$", ""));
        String website = element.findElements(By.tagName("td")).get(4).getText();
        return new Person(firstname, lastName, email, website, due);
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
