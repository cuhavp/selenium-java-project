package modules.mvc;

import libraries.TodoFunctions;
import org.openqa.selenium.support.How;
import supports.Browser;

public class TodoMVCTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        TodoFunctions todoPage = new TodoFunctions();
        todoPage.load();
        int numberTaskAfter = todoPage
                .createNewTodo("to do 1")
                .countRemainTodos();
        System.out.println("After: " + numberTaskAfter);
    }
}
