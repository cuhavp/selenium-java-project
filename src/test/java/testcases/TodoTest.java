package testcases;

import bases.BaseTest;
import bases.Browser;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {
    @BeforeClass
    void navigate(){
        Browser.visit("https://todomvc.com/examples/vanillajs");
    }

    @Test
    void addNewTodo(){
        Browser.fill(By.className("new-todo"),"task1\n");
        Assert.assertTrue(Browser.isDisplayed(By.xpath("//label[.='task1']")));
    }

    @Test
    void markCompleted(){
        Browser.click(By.xpath("//label[.='task1']/../input[@class='toggle']"));
//        Browser.click(By.xpath("//label[.='task1']/preceding-sibling::input[@class='toggle']"));
        Browser.click(By.linkText("Completed"));
        Assert.assertTrue(Browser.isDisplayed(By.xpath("//label[.='task1']")));
    }

    @Test
    void deleteCompleted(){
        Browser.fill(By.className("new-todo"),"task1\n");
        Browser.hover(By.xpath("//label[.='task1']"));
        Browser.click(By.xpath("//label[.='task1']/../button[@class='destroy']"));
//        Browser.click(By.xpath("//label[.='task1']/following-sibling::button"));
        Assert.assertTrue(Browser.count(By.xpath("//label[.='task1']"))==0);
    }
}