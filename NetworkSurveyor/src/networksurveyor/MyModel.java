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
 */
public class MyModel extends AbstractTableModel {
    
        //the data
        ArrayList<Question> al;

        // the headers
        String[] header;
        
        // to hold the column index for the Sent column
        int col;

        // constructor 
        MyModel(ArrayList<Question> obj, String[] header)
        {
            // save the header
            this.header = header;
            // and the data
            al = obj;
            // get the column index for the Sent column
            col = this.findColumn("Sent");
        }

        // method that needs to be overload. The row count is the size of the ArrayList

        public int getRowCount()
        {
            return al.size();
        }

        // method that needs to be overload. The column count is the size of our header
        public int getColumnCount()
        {
            return header.length;
        }

        // method that needs to be overload. The object is in the arrayList at rowIndex
        public Question getValueAt(int rowIndex, int columnIndex)
        {
            return al.get(rowIndex);
        }

        // a method to return the column name 
        public String getColumnName(int index)
        {
            return header[index];
        }
        
        public Class getColumnClass(int columnIndex) 
        {
            if (columnIndex == col) 
            {
                return Boolean.class; // For every cell in column 7, set its class to Boolean.class
            }
            return super.getColumnClass(columnIndex); // Otherwise, set it to the default class
	}

        // a method to add a new line to the table
        void add(String word1, String word2, boolean sent)
        {
//            // make it an array[3] as this is the way it is stored in the ArrayList
//            // (not best design but we want simplicity)
//            Object[] item = new Object[3];
//            item[0] = word1;
//            item[1] = word2;
//            item[2] = sent;
//            al.add(item);
//            // inform the GUI that I have change
            fireTableDataChanged();
        }
    }

