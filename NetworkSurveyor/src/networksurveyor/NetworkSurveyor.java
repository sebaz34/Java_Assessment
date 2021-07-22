
package networksurveyor;

import java.util.ArrayList;
import javax.swing.JTable;

public class NetworkSurveyor {

    MyModel questionTableModel;
    JTable table;
    


    public static void main(String[] args) {
        
        //Run Application Window
        SurveyManager runWindow = new SurveyManager();
        runWindow.setVisible(true);
       
        
    }
    
    //Method Responsible for managing the data inside the question selector table
    //tblQuestionSelector - name of table
    //Question class order of variables:
    //question, topic, INT number, answerA, answerB, answerC, answerD, answerE
    
    public String[] getColumnNames()
    {
        //Create table column names
        String columnNames[] = {"#", "Topic", "Question"};
        return columnNames;
    }
    
    public ArrayList<Question> getQuestionList()
    {
        //Create master list of questions
        ArrayList<Question> questionList = new ArrayList();
        
        //TESTING -- create dummy data
        Question testQuestion1 = new Question();
        testQuestion1.newQuestion("What colour is the sky?", "Nature", 1, "Blue", "Not Blue", "Green", "Bannana", "The 2001 Olympics hosted in Sydney, Australia");
        Question testQuestion2 = new Question();
        testQuestion2.newQuestion("How long is a piece of string?", "Strings and Twine", 2, "5m", "1cm", "18mm", "Apple", "The 2001 Olympics hosted in Sydney, Australia");
        
        //TESTING -- Add dummy data to master list
        questionList.add(testQuestion1);
        questionList.add(testQuestion2);
        
        //Return master list
        return questionList;
    }
    
    public MyModel getTableModel()
    {
        // instantiate JTable model
        questionTableModel = new MyModel(getQuestionList(), getColumnNames());
        return questionTableModel;
    }
    
 }
