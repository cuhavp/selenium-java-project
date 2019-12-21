package libraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

import java.util.List;

public class TodoFunctions {
    /**
     * CODING CONVENSION
     *
     * SUFFIX:
     *  - _TXT -->
     *  - _BTN ->
     *  - _LBL
     *  - _LINK
     *  - _RAD
     *
     */

    private String NEW_TODO_TXT = "new-todo";


    public void createNewTodo(String taskName) {
        Browser.fill(How.CLASS_NAME, NEW_TODO_TXT, taskName + "\n");
    }

    public void editTodoName(String oldName, String newName) {
        String todo = String.format("//label[.='%s']", oldName);
        Browser.doubleClick(How.XPATH, todo);
        Browser.fill(How.XPATH, todo + "/../../input", newName + "\n");
    }

    public void deleteTodo(String taskName) {
        while (isTodoExisted(taskName)){
            String todo = String.format("//label[.='%s']", taskName);
            Browser.hover(How.XPATH, todo);
            Browser.click(How.XPATH, todo + "/following-sibling::button");
        }

    }

    public boolean isTodoExisted(String taskName) {
        String todo = String.format("//label[.='%s']", taskName);
        if (Browser.all(How.XPATH, todo).size() > 0) return true;
        else return false;
    }

    public List<WebElement> getTodo(String taskName){
        return Browser.all(How.XPATH,String.format("//label[.='%s']", taskName));
    }
    public void showAll(){
        Browser.click(How.LINK_TEXT,"All");
    }
    public void showActive(){
        Browser.click(How.LINK_TEXT,"Active");
    }
    public void showCompleted(){
        Browser.click(How.LINK_TEXT,"Completed");
    }

    public void clearCompleted(){
        Browser.click(How.CLASS_NAME,"clear-completed");
    }

    public int countRemainTodos(){
        return Integer.parseInt(Browser.text(How.XPATH,"//*[@class='todo-count']/strong"));
    }

}

