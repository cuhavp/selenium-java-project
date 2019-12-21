package libraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

import java.util.List;

public class TodoFunctions {
    /**
     * CODING CONVENTION
     * SUFFIX:
     * - _TXT -->
     * - _BTN ->
     * - _LBL
     * - _LINK
     * - _RAD
     */

    /**
     *              Page Object Model
     */

    /*********************************
     *    exposing elements
     *********************************/

    private String NEW_TODO_TXT = "new-todo";
    private String TASK_LBL = "//label[.='%s']";
    private String EDIT_TASK_LBL = "//label[.='%s']/../../input";
    private String DELETE_TASK_RAD = "//label[.='%s']/following-sibling::button";
    private String REMAIN_TASK_LBL = "//*[@class='todo-count']/strong";
    private String SHOW_ALL_LINK = "All";
    private String SHOW_ACTIVE_LINK = "Active";
    private String SHOW_COMPLETED_LINK = "Completed";
    private String CLEAR_COMPLETED_TASKS_BTN = "clear-completed";

    /************************
     Exposing user operations
     ***********************/

    public void createNewTodo(String taskName) {
        Browser.fill(How.CLASS_NAME, NEW_TODO_TXT, taskName + "\n");
    }

    public void editTodoName(String oldName, String newName) {
        Browser.doubleClick(How.XPATH, String.format(TASK_LBL, oldName));
        Browser.fill(How.XPATH, String.format(EDIT_TASK_LBL, oldName), newName + "\n");
    }

    public void deleteTodo(String taskName) {
        while (isTodoExisted(taskName)) {
            Browser.hover(How.XPATH, String.format(TASK_LBL, taskName));
            Browser.click(How.XPATH, String.format(DELETE_TASK_RAD, taskName));
        }
    }

    public boolean isTodoExisted(String taskName) {
        if (Browser.all(How.XPATH, String.format(TASK_LBL, taskName)).size() > 0) return true;
        else return false;
    }

    public List<WebElement> getTodo(String taskName) {
        return Browser.all(How.XPATH, String.format(TASK_LBL, taskName));
    }

    public void showAll() {
        Browser.click(How.LINK_TEXT, SHOW_ALL_LINK);
    }

    public void showActive() {
        Browser.click(How.LINK_TEXT, SHOW_ACTIVE_LINK);
    }

    public void showCompleted() {
        Browser.click(How.LINK_TEXT, SHOW_COMPLETED_LINK);
    }

    public void clearCompleted() {
        Browser.click(How.CLASS_NAME, CLEAR_COMPLETED_TASKS_BTN);
    }

    public int countRemainTodos() {
        return Integer.parseInt(Browser.text(How.XPATH, REMAIN_TASK_LBL));
    }

}

