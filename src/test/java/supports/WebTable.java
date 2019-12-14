package supports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTable {
    private WebElement table;

    public WebTable(WebElement table) {
        this.table = table;
    }

    public int getTotalRows(){
        return table.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size();
    }

    public int getTotalColumns(){
        return table.findElements(By.tagName("th")).size();
    }

    public WebElement getCell(int rowIndex, int columnIndex){
       return table.findElement(By.tagName("tbody"))
               .findElements(By.tagName("tr")).get(rowIndex-1)
               .findElements(By.tagName("td")).get(columnIndex-1);
    }

    public List<WebElement> getRow(int rowIndex){
        return table.findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr")).get(rowIndex-1)
                .findElements(By.tagName("td"));
    }
    public List<WebElement> getColumn(int columnIndex){
        return table.findElement(By.tagName("tbody"))
                .findElements(By.xpath(String.format("//tr/td[%d]",columnIndex)));
    }
}
