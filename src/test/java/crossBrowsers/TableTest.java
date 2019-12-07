package crossBrowsers;

import org.openqa.selenium.support.How;

public class TableTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("https://the-internet.herokuapp.com/tables");

        int totalColumns = Browser.all(How.XPATH,"//table[@id='table1']/thead/tr/th").size();
        int totalRows = Browser.all(How.XPATH,"//table[@id='table1']/tbody/tr").size();

//       for (int row =1; row <= totalRows;row++){
//           for(int column = 1;column<= totalColumns;column++){
//               System.out.println(Browser.text(How.XPATH,String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]",row,column)));
//           }
//       }

        //todo: get list due

        double[] due = new double[ totalRows];
        String dueValue = "";
        for (int row =1;row<=totalRows;row++){
            dueValue = Browser.text(How.XPATH,String.format("//table[@id='table1']/tbody/tr[%d]/td[4]",row));
            dueValue=dueValue.replace("$","");
            due[row-1] = Double.valueOf(dueValue);
        }
        
    }
}
