package libraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

import java.util.List;

public class TodoFunctions {

    /**
     * Perform manual tests --> define common functions --> get locator objects
     * 1. create new to do
     * 2. update name
     * 3. mark done
     * 4. delete
     * 5. show all to dos
     * 6. show active to dos
     * 7. show completed to dos
     * 8. clear completed to dos
     * 9. count remain active to dos
     * 10. check existing to do
     * 11. get to dos -->
     */

    public void createNewTodo(String taskName) {
        Browser.fill(How.CLASS_NAME, "new-todo", taskName + "\n");
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
}

