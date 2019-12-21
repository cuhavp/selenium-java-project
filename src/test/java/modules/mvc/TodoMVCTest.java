package modules.mvc;

import libraries.TodoFunctions;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.*;
import supports.Browser;

public class TodoMVCTest {
    public static TodoFunctions todoPage;

    @BeforeClass
    public static void setUp(){
        Browser.open("chrome");
    }

    @BeforeMethod
    public static void preConditions(){
        todoPage = new TodoFunctions();
        todoPage.load();
    }

    @Test(description = "create new todo")
    public static void addNewTask() {
        int numberTaskAfter = todoPage
                .createNewTodo("to do 1")
                .countRemainTodos();
        Assert.assertEquals(numberTaskAfter,1);
    }

    @Test(description = "delete a todo")
    public static void deleteTask() {
        int numberTaskAfter = todoPage
                .createNewTodo("to do 1")
                .countRemainTodos();
        todoPage.deleteTask("to do 1");
        Assert.assertEquals(numberTaskAfter,0);
    }

    @AfterClass
    public static void tearDown(){
        Browser.close();
    }
}
