package libraries;

import objects.TodoObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

import java.util.List;

public class TodoFunctions extends TodoObjects {


    /**
     *              Page Object Model
     */
    
    /************************
     Exposing user operations
     ***********************/

    public void createNewTodo(String taskName) {
        Browser.fill(NEW_TODO_TXT, taskName + "\n");
    }


    public void editTodoName(String oldName, String newName) {
        Browser.doubleClick(getTask(oldName));
        Browser.fill(updateTask(oldName),newName + "\n");
    }

    public void deleteTodo(String taskName) {
        while (isTodoExisted(taskName)) {
            Browser.hover(getTask(taskName));
            Browser.click(deleteTask(taskName));
        }
    }

    public boolean isTodoExisted(String taskName) {
        if (Browser.all(getTask(taskName)).size() > 0) return true;
        else return false;
    }

    public List<WebElement> getTodo(String taskName) {
        return Browser.all(getTask(taskName));
    }

    public void showAll() {
        Browser.click(SHOW_ALL_LINK);
    }

    public void showActive() {
        Browser.click(SHOW_ACTIVE_LINK);
    }

    public void showCompleted() {
        Browser.click(SHOW_COMPLETED_LINK);
    }

    public void clearCompleted() {
        Browser.click(CLEAR_COMPLETED_TASKS_BTN);
    }

    public int countRemainTodos() {
        return Integer.parseInt(Browser.text(REMAIN_TASK_LBL));
    }

}

