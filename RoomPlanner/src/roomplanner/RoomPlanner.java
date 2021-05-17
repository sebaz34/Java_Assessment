
package roomplanner;


import javax.swing.*;

//import listeners and events
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import readers and writers
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import javax.swing.border.LineBorder;
//import classes
import roomplanner.CellData;
import roomplanner.Heading;


public class RoomPlanner extends JFrame implements ActionListener, KeyListener, MouseListener
{

    private int totalX = 11;
    private int totalY = 19;
    
    //counters to track length of array in the seperate arrays
    int CellDataCounter = 0;
    int HeadingCounter = 0;
    
    //Colour tracking variable used to keep track of currently selected colour
    Color currentColour = Color.WHITE;
    
    //Mouse held variable used to click and drag colours accross textfields
    boolean mouseHeld = false;

    private JTextField[][] fields = new JTextField[totalX][totalY];
    private JTextField txtHeading1, txtData1, txtHeading2, txtData2, txtHeading3, txtData3, txtHeading4, txtData4;
    private JButton btnClear, btnSave, btnSort, btnFind, btnRAF, btnExit;
    private JButton btnGreen, btnRed, btnPurple, btnYellow, btnBlue, btnWhite;
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
        //Create Main grid of text fields
        for (int y = 0; y < totalY; y++)
        {
            for (int x = 0; x < totalX; x++)     
            {
                int xPos = x * 110 + 5;
                int yPos = y * 20 + 100;           
                fields[x][y] = LibraryComponents.LocateAJTextField(this, this, layout, 9, xPos, yPos);
            }
        }
        //Create heading text fields
        txtHeading1 = LibraryComponents.LocateAJTextField(this, this, layout, 9, 10, 10);
        txtData1 = LibraryComponents.LocateAJTextField(this, this, layout, 9, 120, 10);
        txtHeading2 = LibraryComponents.LocateAJTextField(this, this, layout, 9, 260, 10);
        txtData2 = LibraryComponents.LocateAJTextField(this, this, layout, 9, 370, 10);
        txtHeading3 = LibraryComponents.LocateAJTextField(this, this, layout, 9, 510, 10);
        txtData3 = LibraryComponents.LocateAJTextField(this, this, layout, 9, 620, 10);
        txtHeading4 = LibraryComponents.LocateAJTextField(this, this, layout, 9, 760, 10);
        txtData4 = LibraryComponents.LocateAJTextField(this, this, layout, 9, 870, 10);
        //Set test within text fields
        txtHeading1.setText(headings[0].header);
        txtData1.setText(headings[0].data);
        txtHeading2.setText(headings[1].header);
        txtData2.setText(headings[1].data);
        txtHeading3.setText(headings[2].header);
        txtData3.setText(headings[2].data);
        txtHeading4.setText(headings[3].header);
        txtData4.setText(headings[3].data);
        //Format textfield backgrounds to look nice
        txtHeading1.setBackground(Color.LIGHT_GRAY);
        txtData1.setBackground(Color.LIGHT_GRAY);
        txtHeading2.setBackground(Color.LIGHT_GRAY);
        txtData2.setBackground(Color.LIGHT_GRAY);
        txtHeading3.setBackground(Color.LIGHT_GRAY);
        txtData3.setBackground(Color.LIGHT_GRAY);
        txtHeading4.setBackground(Color.LIGHT_GRAY);
        txtData4.setBackground(Color.LIGHT_GRAY);
    }
    
    private void displayButtons(SpringLayout layout)
    {
        //Function Buttons (Bottom of Screen)
        btnClear = LibraryComponents.LocateAJButton(this, this, layout, "Clear", 20, 550, 80, 25);
        btnSave = LibraryComponents.LocateAJButton(this, this, layout, "Save", 110, 550, 80, 25);
        btnSort = LibraryComponents.LocateAJButton(this, this, layout, "Sort", 200, 550, 80, 25);
        btnFind = LibraryComponents.LocateAJButton(this, this, layout, "Find", 290, 550, 80, 25);
        btnRAF = LibraryComponents.LocateAJButton(this, this, layout, "RAF", 380, 550, 80, 25);
        btnExit = LibraryComponents.LocateAJButton(this, this, layout, "Exit", 470, 550, 80, 25);
        
        //Color Buttons (Right Side of screen)
        btnGreen = LibraryComponents.LocateAJButton(this, this, layout, "", 1400, 100, 80, 25);
        btnRed = LibraryComponents.LocateAJButton(this, this, layout, "", 1400, 130, 80, 25);
        btnPurple = LibraryComponents.LocateAJButton(this, this, layout, "", 1400, 160, 80, 25);
        btnYellow = LibraryComponents.LocateAJButton(this, this, layout, "", 1400, 190, 80, 25);
        btnBlue = LibraryComponents.LocateAJButton(this, this, layout, "", 1400, 220, 80, 25);
        btnWhite = LibraryComponents.LocateAJButton(this, this, layout, "", 1400, 250, 80, 25);
        btnGreen.setBackground(Color.GREEN);
        btnRed.setBackground(Color.RED);
        btnPurple.setBackground(Color.MAGENTA);
        btnYellow.setBackground(Color.YELLOW);
        btnBlue.setBackground(Color.CYAN);
        btnWhite.setBackground(Color.WHITE);
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
                //Get cell coordinates
                int tempX = cellData[i].getX();
                int tempY = cellData[i].getY();
                
                //Get cell variables from array
                String tempContents = cellData[i].getCellContents();
                String tempColour = cellData[i].getCellColour();
                
                //Set cell text to be cell contentets
                fields[tempX][tempY].setText(tempContents);
                
                //Set cell background colour based on cell colour variable
                Color color = null;
                switch(tempColour)
                {
                    case "Green":
                        color = Color.GREEN;
                        break;
                    case "Red":
                        color = Color.RED;
                        break;
                    case "Purple":
                        color = Color.MAGENTA;
                        break;
                    case "Yellow":
                        color = Color.YELLOW;
                        break;
                    case "Blue":
                        color = Color.CYAN;
                        break;
                }
                fields[tempX][tempY].setBackground(color);
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
        if (e.getSource() == btnGreen)
        {
            currentColour = Color.GREEN;
            colourButtonBorder(btnGreen);
        }
        if (e.getSource() == btnRed)
        {
            currentColour = Color.RED;
            colourButtonBorder(btnRed);
        }
        if (e.getSource() == btnPurple)
        {
            currentColour = Color.MAGENTA;
            colourButtonBorder(btnPurple);
        }
        if (e.getSource() == btnYellow)
        {
            currentColour = Color.YELLOW;
            colourButtonBorder(btnYellow);
        }
        if (e.getSource() == btnBlue)
        {
            currentColour = Color.CYAN;
            colourButtonBorder(btnBlue);
        }
        if (e.getSource() == btnWhite)
        {
            currentColour = Color.WHITE;
            colourButtonBorder(btnWhite);
        }
    }
    
    public void colourButtonBorder(JButton clickedButton)
    {
        JButton[] colourButtons = {btnGreen, btnRed, btnPurple, btnYellow, btnBlue, btnWhite};
        for(JButton button:colourButtons)
        {
            //Change clicked button border
            if(button == clickedButton)
            {
                clickedButton.setBorder(new LineBorder(Color.BLACK,5));
            }
            //reset all other buttons borders
            else
            {
                button.setBorder(new LineBorder(Color.BLACK, 1));
            }
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
    
    public void mouseClicked(MouseEvent e) {
        JTextField clickedField = (JTextField) e.getComponent();
        clickedField.setBackground(currentColour);
    }

    public void mousePressed(MouseEvent e) {
        
    }
    
    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {

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
