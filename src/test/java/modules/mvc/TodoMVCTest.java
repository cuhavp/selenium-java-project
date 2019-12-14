package modules.mvc;

import libraries.TodoFunctions;
import org.openqa.selenium.support.How;
import supports.Browser;

public class TodoMVCTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("http://todomvc.com/examples/vanillajs");
        TodoFunctions todoPage = new TodoFunctions();
        todoPage.createNewTodo("to do 1");
        todoPage.createNewTodo("to do 1");
        todoPage.createNewTodo("to do 1");


//        todoPage.editTodoName("to do 5", "task 1");

        todoPage.deleteTodo("to do 1");
    }
}
