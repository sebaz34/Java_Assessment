
package roomplanner;


import javax.swing.*;

//import listeners and events
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import readers and writers
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
//import classes
import roomplanner.CellData;
import roomplanner.Heading;


public class RoomPlanner extends JFrame implements ActionListener, KeyListener
{

    private int totalX = 11;
    private int totalY = 19;
    
    //counters to track length of array in the seperate arrays
    int CellDataCounter = 0;
    int HeadingCounter = 0;

    private JTextField[][] fields = new JTextField[totalX][totalY];
    private JButton btnClear, btnSave, btnSort, btnFind, btnRAF, btnExit;
    private String dataFileName = "ClientRoom1_Data_20220307.csv";
    private String tableFileName = "ClientRoom1_Data_20220307.csv";
    
    public Heading headings[] = new Heading[4];
    public CellData cellData[] = new CellData[209];
    
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
        
        readDataFile(dataFileName);
        displayGUI();
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
        setupTable();
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
    
    private void setupTable()
    {
        //Setting up room map cells
        for (int i = 0; i < CellDataCounter; i++) 
        {
            String validEntryCheck = cellData[i].getCellContents();
            if(validEntryCheck.equals("") || validEntryCheck.isEmpty())
            {
                break;
            }
            else
            {
                int tempX = cellData[i].getX();
                int tempY = cellData[i].getY();
                String tempString = cellData[i].getCellContents();
                
                fields[tempX][tempY].setText(tempString);
            }
            
        }
      
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

            
            //Read in file and loop for each line in file 
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            //line by line sort and store into relevent array (Heading or CellData
            while ((line = br.readLine()) != null)
            {    
                String temp[] = line.split(",");
                //Checking to see if first value in temp array is an integer
                try
                {
                    Integer.parseInt(temp[0]);
                    
                    //Instantiate new celldata class and assign values from temp into new class
                    CellData newCellData = new CellData();
                    
                    newCellData.setY(Integer.parseInt(temp[1]));
                    newCellData.setX(Integer.parseInt(temp[0]));
                    newCellData.setCellContents(temp[2]);
                    newCellData.setCellColour(temp[3]);
                    newCellData.setFixed(Boolean.parseBoolean(temp[4]));
                    
                    //Assigne newcelldata into array and increase index value of array
                    cellData[CellDataCounter] = newCellData;
                    CellDataCounter ++;
                }
                catch(Exception e)
                {
                    //Instantiate new heading class and assign values form temp into new class
                    Heading newHeadingData = new Heading();
                    
                    newHeadingData.setHeader(temp[0]);
                    newHeadingData.setData(temp[1]);
                    
                    //Assigns newHeadingData into array and increase index value of array
                    headings[HeadingCounter] = newHeadingData;
                    HeadingCounter ++; 
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
