/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksurveyor;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sebas
 * 
 * 
 * USE THIS FOR FURTHER CHANGES:
 * https://tips4java.wordpress.com/2008/11/21/row-table-model/
 */
public class MyModel extends AbstractTableModel 
{
    private String[] columnNames =
    {
        "Qn#",
        "Topic",
        "Question"
    };
 
    private ArrayList<Question> questions;
 
    public MyModel()
    {
        questions = new ArrayList<Question>();
    }
 
    public MyModel(ArrayList<Question> questions)
    {
        this.questions = questions;
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public int getRowCount()
    {
        return questions.size();
    }
 
    @Override
    public Class getColumnClass(int column)
    {
        switch (column)
        {
            case 0: return int.class;
            default: return String.class;
        }
    }
 
    @Override
    public boolean isCellEditable(int row, int column)
    {

       return false;
        
    }   
 
    @Override
    public Object getValueAt(int row, int column)
    {
        Question question = getQuestion(row);

        switch (column)
        {
            case 0: return question.getNumber();
            case 1: return question.getTopic();
            case 2: return question.getQuestion();
            default: return null;
        }
    }
 
    @Override
    public void setValueAt(Object value, int row, int column)
    {
        Question question = getQuestion(row);

        switch (column)
        {
            case 0: question.setNumber((int)value); break;
            case 1: question.setTopic((String)value); break;
            case 2: question.setQuestion((String)value); break;
        }

        fireTableCellUpdated(row, column);
    }
 
    public Question getQuestion(int row)
    {
        return questions.get( row );
    }
    }