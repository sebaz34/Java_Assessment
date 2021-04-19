
package roomplanner;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class RoomPlanner extends JFrame implements ActionListener, KeyListener
{

    private int totalX = 11;
    private int totalY = 19;

    private JTextField[][] fields = new JTextField[totalX][totalY];
    private JButton btnClear, btnSave, btnSort, btnFind, btnRAF, btnExit;
    private String dataFileName = "EmissionsTracker.csv";
    private String tableFileName = "EmissionsTable.csv";

    private String[] headingsAtTheTop = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Weekly Average"};
    private String[] headingsOnTheSide = {"Emissions", "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm", "4:00pm", "5:00pm", "Total", "Average"};

    
    
    public static void main(String[] args)
    {
        RoomPlanner roomPlannerApplication = new RoomPlanner();
        roomPlannerApplication.run();
    }
    
    private void run()
    {
        setBounds(100, 50, 1550, 650);
        setTitle("Room Planner");
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        
        displayGUI();
        readDataFile(dataFileName);
        calculateTotals();

        setResizable(true);
        setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc="Display GUI">    

    private void displayGUI()
    {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        
        displayTextFields(springLayout);
        displayButtons(springLayout);
        setupTable(springLayout);
    }

    private void displayTextFields(SpringLayout layout)
    {
        for (int y = 0; y < totalY; y++)
        {
            for (int x = 0; x < totalX; x++)     
            {
                int xPos = x * 120 + 20;
                int yPos = y * 25 + 20;           
                fields[x][y] = LibraryComponents.LocateAJTextField(this, this, layout, 9, xPos, yPos);
            }
        }
    }
    
    private void displayButtons(SpringLayout layout)
    {
        btnClear = LibraryComponents.LocateAJButton(this, this, layout, "Clear", 20, 550, 80, 25);
        btnSave = LibraryComponents.LocateAJButton(this, this, layout, "Save", 110, 550, 80, 25);
        btnSort = LibraryComponents.LocateAJButton(this, this, layout, "Sort", 200, 550, 80, 25);
        btnFind = LibraryComponents.LocateAJButton(this, this, layout, "Find", 290, 550, 80, 25);
        btnRAF = LibraryComponents.LocateAJButton(this, this, layout, "RAF", 380, 550, 80, 25);
        btnExit = LibraryComponents.LocateAJButton(this, this, layout, "Exit", 470, 550, 80, 25);
    }
    
    private void setupTable(SpringLayout layout)
    {
      
    } 

    public void setFieldProperties(int x, int y, boolean editable, int r, int g, int b)
    {
        fields[x][y].setEditable(editable);
        fields[x][y].setBackground(new Color(r, g, b));
    }

    //</editor-fold>

                
    //<editor-fold defaultstate="collapsed" desc="Action and Key Listeners">    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnClear)
        {
            ClearData();
        }
        if (e.getSource() == btnSave)
        {
            saveEmmisionsTableToFile(tableFileName);
        }
        if (e.getSource() == btnSave)
        {
            writeDataFile(dataFileName);
        }
        if (e.getSource() == btnExit)
        {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e)  {  }
    @Override
    public void keyPressed(KeyEvent e)  {  }
    @Override
    public void keyReleased(KeyEvent e)
    {
        calculateTotals();
    }
    
    //</editor-fold>
    

    //<editor-fold defaultstate="collapsed" desc="Manage Screen Data">    
    
    private void ClearData()
    {
        for (int y = 1; y < totalY; y++)
        {
            for (int x = 1; x < totalX; x++)
            {
                fields[x][y].setText("0");
            }
        }
    }

    private void calculateTotals()
    {
          
    }

       
    public String checkInteger(String strValue)
    {
        try 
        {
            Integer.parseInt(strValue);
            return strValue;
        }
        catch (Exception e) 
        {
            return "0";
        }
    }
            
    //</editor-fold>    

    
    //<editor-fold defaultstate="collapsed" desc="File Management">    

    private void readDataFile(String fileName)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            
            for (int x = 1; x < totalX - 1; x++)
            {
                for (int y = 1; y < totalY - 2; y++)
                {
                    String temp[] = br.readLine().split(",");                    
                    fields[x][y].setText(temp[2]);
                }
            }
            br.close();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());            
        }
    }

    public void writeDataFile(String fileName)
    {
        try
        {
            //BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
            BufferedWriter outFile = new BufferedWriter(new FileWriter("EmissionsTracker_NEW.csv"));
            for (int x = 1; x < totalX - 1; x++)
            {
                for (int y = 1; y < totalY - 2; y++)
                {
                    outFile.write(fields[0][y].getText() + "," + fields[x][0].getText() + "," + fields[x][y].getText());
                    outFile.newLine();
                }
            }
            outFile.close();
            System.out.println("Emmissions Tracker data has been saved.");
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void saveEmmisionsTableToFile(String fileName)
    {
        try
        {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
            for (int y = 0; y < totalY; y++)
            {
                for (int x = 0; x < totalX-1; x++)
                {
                    outFile.write(fields[x][y].getText() + "," );               
                }
                outFile.write(fields[6][y].getText() + "" );
                outFile.newLine();
            }
            outFile.close();
            System.out.println("Emmissions Tracker table has been saved.");
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    //</editor-fold>    

}
