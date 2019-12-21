package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import supports.Browser;

import java.util.List;

public class TodoFunctions extends LoadableComponent<TodoFunctions> {

    public TodoFunctions() {
        PageFactory.initElements(Browser.getDriver(), this);
    }

    @Override
    public void load() {
       Browser.visit("http://todomvc.com/examples/vanillajs");
    }

    @Override
    protected void isLoaded() throws Error {

    }

    /*********************************
     *    exposing elements
     *********************************/

    @FindBy(className = "new-todo")
    WebElement new_todo; // --driver.findElement(By.className("new-todo"))

    @FindBy(xpath = "//*[@class='todo-count']/strong")
    WebElement remain_todo;

    @FindBy(linkText = "All")
    WebElement show_all;

    @FindBy(linkText = "Active")
    WebElement show_active;

    @FindBy(linkText = "Completed")
    WebElement show_completed;

    @FindBy(className = "clear-completed")
    WebElement clear_competed;

    private WebElement getTask(String name) {
        return Browser.find(How.XPATH,String.format("//label[.='%s']", name));
    }

    private WebElement updateTask(String name) {
        return Browser.find(How.XPATH,String.format("//label[.='%s']/../../input", name));
    }

    public WebElement deleteTask(String name) {
        return Browser.find(How.XPATH,String.format("//label[.='%s']/following-sibling::button", name));
    }

    /************************
     Exposing user operations
     ***********************/

    public TodoFunctions editTodoName(String oldName, String newName) {
        Browser.doubleClick(getTask(oldName));
        updateTask(oldName).sendKeys(newName+"\n");
        return this;
    }
    public TodoFunctions createNewTodo(String taskName) {
        new_todo.sendKeys(taskName + "\n");
        return this;
    }



    public void deleteTodo(String taskName) {
        while (isTodoExisted(taskName)) {
            Browser.hover(getTask(taskName));
            deleteTask(taskName).click();
        }
    }

    public boolean isTodoExisted(String taskName) {
        if (getTodo(taskName).size() > 0) return true;
        else return false;
    }

    public List<WebElement> getTodo(String taskName) {
        return Browser.all(How.XPATH,String.format("//label[.='%s']", taskName));
    }

    public void showAll() {
        show_all.click();
    }

    public void showActive() {
        show_active.click();
    }

    public void showCompleted() {
        show_completed.click();
    }

    public void clearCompleted() {
        clear_competed.click();
    }

    public int countRemainTodos() {
        return Integer.parseInt(remain_todo.getText());
//        return Integer.parseInt(Browser.text(REMAIN_TASK_LBL));
    }

}

