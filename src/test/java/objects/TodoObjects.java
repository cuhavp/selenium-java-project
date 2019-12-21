package objects;

import org.openqa.selenium.By;

public class TodoObjects {
    /**
     * CODING CONVENTION
     * SUFFIX:
     * - _TXT -->
     * - _BTN ->
     * - _LBL
     * - _LINK
     * - _RAD
     */
    /*********************************
     *    exposing elements
     *********************************/

    protected By NEW_TODO_TXT = By.className("new-todo");
    protected By REMAIN_TASK_LBL = By.xpath("//*[@class='todo-count']/strong");
    protected By SHOW_ALL_LINK =  By.linkText("All");
    protected By SHOW_ACTIVE_LINK =  By.linkText("Active");
    protected By SHOW_COMPLETED_LINK = By.linkText("Completed");
    protected By CLEAR_COMPLETED_TASKS_BTN = By.className("clear-completed");
    protected By getTask(String name){
        return By.xpath(String.format( "//label[.='%s']",name));
    }
    protected By updateTask(String name){
        return By.xpath(String.format("//label[.='%s']/../../input",name));
    }
    protected By deleteTask(String name){
        return By.xpath(String.format("//label[.='%s']/following-sibling::button",name));
    }
}
