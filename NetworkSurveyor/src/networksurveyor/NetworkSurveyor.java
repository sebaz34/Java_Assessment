
package networksurveyor;

import java.util.ArrayList;
import javax.swing.JTable;
//Import readers and writers
import java.io.BufferedReader;
import java.io.FileReader;


public class NetworkSurveyor {

    //Global variables
    MyModel questionTableModel;
    JTable table;
    String fileName = "SurveyByNetwork_SampleData.txt";
    ArrayList<Question> questionList = new ArrayList();
    


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
    
    //Method Responsible for reading in questions from file and creating objects of each question in memory
    public ArrayList<Question> getQuestionListFromFile()
    {
        //Read in data from text file
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            int counter = 0;
            Question currentQuestion = new Question();
            
            while((line = br.readLine()) != null)
            {
                //iterate through variables of the object and assign new line to that variable
                switch(counter)
                {
                    case 0: currentQuestion.setNumber(line); break;
                    case 1: currentQuestion.setTopic(line); break;
                    case 2: currentQuestion.setQuestion(line); break;
                    case 3: currentQuestion.setAnswerA(line); break;
                    case 4: currentQuestion.setAnswerB(line); break;
                    case 5: currentQuestion.setAnswerC(line); break;
                    case 6: currentQuestion.setAnswerD(line); break;
                    case 7: currentQuestion.setAnswerE(line); break;
                }
                
                //+1 to counter
                counter ++;
                
                //if counter is at 7, reset counter to 0
                //once object is complete, append object to questionList
                if (counter > 7) 
                {
                    counter = 0;
                    questionList.add(currentQuestion);
                    currentQuestion = new Question();
                }
            }
            br.close();
        }
        catch(Exception e)
        {
            System.err.println("Error: Encountered within getQuestionList() Error Message: "+ e.getMessage());
        }
        
        //Return master list
        return questionList;
    }
    
    //Creates and returns Table Model
    public MyModel getTableModel()
    {
        // instantiate JTable model
        questionTableModel = new MyModel(getQuestionListFromFile());
        return questionTableModel;
    }
    
    public MyModel setTableModel(ArrayList<Question> masterList)
    {
        questionTableModel = new MyModel(masterList);
        return questionTableModel;
    }
    
    //Pulls from memory the questionList array
    public ArrayList<Question> getQuestionListFromMemory()
    {
        return questionList;
    }
 }
