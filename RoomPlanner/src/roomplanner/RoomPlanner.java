
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
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.border.LineBorder;
//import classes
import roomplanner.CellData;
import roomplanner.Heading;
import roomplanner.ColorUtils;


public class RoomPlanner extends JFrame implements ActionListener, KeyListener, MouseListener
{
    
//<editor-fold defaultstate="collapsed" desc="Global Variables">
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
    private JTextField txtHeading1, txtData1, txtHeading2, txtData2, txtHeading3, txtData3, txtHeading4, txtData4, txtFind;
    private JButton btnClear, btnSave, btnSort, btnFind, btnRAF, btnExit;
    private JButton btnGreen, btnRed, btnPurple, btnYellow, btnBlue, btnWhite;
    private JLabel[] horizontalLabels = new JLabel[11];
    private JLabel[] verticalLabels = new JLabel[19];
    private String dataFileName = "Sample Data File 2.txt";
    
    public Heading headings[] = new Heading[4];
    public CellData cellData[] = new CellData[209];
   
//</editor-fold>

    
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

        setResizable(true);
        setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc="Display GUI">    

    private void displayGUI()
    {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        
        displayLabels(springLayout);
        displayTextFields(springLayout);
        displayButtons(springLayout);
        setupTable();
    }
    
    private void displayLabels(SpringLayout layout)
    {
        int x = 40;
        int y = 70;
        int counter = 0;
        //Display horizontal Labels
        for (JLabel label: horizontalLabels)
        {
            LibraryComponents.LocateAJLabel(this, layout, Integer.toString(counter) , x + 50, y);
            counter += 1;
            x += 110;
        }
        
        x = 15;
        y = 50;
        counter = 0;
        //Display vertical labels
        for (JLabel label: verticalLabels)
        {
            LibraryComponents.LocateAJLabel(this, layout, Integer.toString(counter), x, y + 50);
            counter += 1;
            y += 20;
        }
    }

    private void displayTextFields(SpringLayout layout)
    {
        //Create Main grid of text fields
        for (int y = 0; y < totalY; y++)
        {
            for (int x = 0; x < totalX; x++)     
            {
                int xPos = x * 110 + 40;
                int yPos = y * 20 + 100;           
                fields[x][y] = LibraryComponents.LocateAJTextField(this, this, layout, 9, xPos, yPos);
                fields[x][y].setBorder(new LineBorder(Color.BLACK, 1));
            }
        }
        
        //<editor-fold defaultstate="collapsed" desc="Heading and Search Setup">
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
        //txtFind Set Up
        txtFind = LibraryComponents.LocateAJTextField(this, null, layout, 15, 310, 554);
        //</editor-fold>
    }
    
    private void displayButtons(SpringLayout layout)
    {
        //Function Buttons (Bottom of Screen)
        btnClear = LibraryComponents.LocateAJButton(this, this, layout, "Clear", 20, 550, 80, 25);
        btnSave = LibraryComponents.LocateAJButton(this, this, layout, "Save", 110, 550, 80, 25);
        btnSort = LibraryComponents.LocateAJButton(this, this, layout, "Sort", 200, 550, 80, 25);
        btnFind = LibraryComponents.LocateAJButton(this, this, layout, "Find", 490, 550, 80, 25);
        btnRAF = LibraryComponents.LocateAJButton(this, this, layout, "RAF", 580, 550, 80, 25);
        btnExit = LibraryComponents.LocateAJButton(this, this, layout, "Exit", 670, 550, 80, 25);
        
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
                ColorUtils colorUtilities = new ColorUtils();
                int r = colorUtilities.getRFromColorName(tempColour);
                int g = colorUtilities.getGFromColorName(tempColour);
                int b = colorUtilities.getBFromColorName(tempColour);
                
                fields[tempX][tempY].setBackground(new Color(r,g,b));
            }
        }
    } 

    public void setFieldProperties(int x, int y, boolean editable, int r, int g, int b)
    {
        fields[x][y].setEditable(editable);
        fields[x][y].setBackground(new Color(r, g, b));
    }

    //</editor-fold>

                
    //<editor-fold defaultstate="collapsed" desc="Action, Key, and Mouse Listeners">    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Function Buttons
        if (e.getSource() == btnClear)
        {
            ClearData();
        }
        if (e.getSource() == btnSave)
        {
            ArrayList<CellData> savedCellData = new ArrayList<CellData>();
            ArrayList<Heading> savedHeadings = new ArrayList<Heading>();
            savedHeadings = saveHeadingsToMemory();
            savedCellData = saveCellDataToMemory();     
            writeCSVDataFile(dataFileName, savedHeadings, savedCellData);
        }
        if (e.getSource() == btnExit)
        {
            System.exit(0);
        }
        if(e.getSource() == btnFind)
        {
            String searchText = txtFind.getText();
            SearchData(searchText);
            
        }
        if (e.getSource() == btnRAF)
        {
            writeRAFDataFile("RAF File");
        }
        if (e.getSource() == btnSort) {
            JFrame sortFrame = new JFrame();
            sortFrame.setBounds(10,10,400,400);
            SpringLayout popUpSpringLayout = new SpringLayout();
            sortFrame.setLayout(popUpSpringLayout);
            sortFrame.setVisible(true);
            
            JTextArea txtSort = new JTextArea();
            txtSort = LibraryComponents.LocateAJTextArea(sortFrame, popUpSpringLayout, 10, 10, 20, 20);
            txtSort.setText("Items \t #Unit Spaces\n\n");
            String currentItem = "";
            int currentCount = 0;
            int numberOfEntries = 0;
            
            String[] sortArray = new String[totalX * totalY + 2];
            
            for (int y = 0; y < totalY; y++) 
            {
                for (int x = 0; x < totalX; x++) 
                {
                    if(!fields[x][y].getText().isEmpty())
                    {
                        sortArray[numberOfEntries] = fields[x][y].getText();
                        numberOfEntries++;
                    }
                }
            }
            
            Arrays.sort(sortArray, 0, numberOfEntries);
            
            currentItem = sortArray[0];
            currentCount = 1;
            
            for (int i = 1; i <= numberOfEntries; i++)
            {
                if (currentItem.equals(sortArray[i])) 
                {
                    currentCount++;
                }
                else
                {
                    txtSort.append(currentItem + "\t" + currentCount + "\n");
                    currentItem = sortArray[i];
                    currentCount = 1;
                }
            }
        }
        
        //Colour Buttons
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
    public void keyReleased(KeyEvent e) {   }
    
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
        for (int y = 0; y < totalY; y++)
        {
            for (int x = 0; x < totalX; x++)
            {
                fields[x][y].setText("");
                fields[x][y].setBackground(Color.WHITE);
            }
        }
    }
       
    private void SearchData(String searchString)
    {
        for (int y = 0; y < totalY; y++)
        {
            for (int x = 0; x < totalX; x++)
            {
                if (fields[x][y].getText().equalsIgnoreCase(searchString) && !searchString.isEmpty())
                {
                    fields[x][y].setBorder(new LineBorder(Color.BLACK, 5));
                }
                else{
                    fields[x][y].setBorder(new LineBorder(Color.BLACK, 1));
                }
            }
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

    public void writeCSVDataFile(String fileName, ArrayList<Heading> headings, ArrayList<CellData> cellData)
    {
        try
        {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
            
            for (Heading heading: headings) 
            {
                outFile.write(heading.header + "," + heading.data);
                outFile.newLine();
            }
            
            for (CellData celldata: cellData) 
            {
                String x = String.valueOf(celldata.x);
                String y = String.valueOf(celldata.y);
                outFile.write(x + "," + y + "," + celldata.cellContents + "," + celldata.cellColour);
                outFile.newLine();   
            }
            outFile.close();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
            System.err.println("The above error occured in writeDataFile()");
        }
    }
    
    public void writeRAFDataFile(String fileName)
    {
        try
        {
            String str;
            RandomAccessFile rafFile = new RandomAccessFile(fileName, "rw");
            for (int y = 1; y < totalY; y++)
            {
                str = "";
                for (int x = 0; x < totalX; x++)
                {
                    str = str + fields[x][y].getText() + fields[x][y].getBackground();
                }
                rafFile.writeUTF(str);
            }
            rafFile.close();
            System.out.println("Room Planner System RAF data has been saved.");
        }
        catch (Exception e)
        {
            System.err.println("Error caught during writeRAFDataFile method. Error is: " + e);
        }
    }
    
    public ArrayList<Heading> saveHeadingsToMemory()
    {
        ArrayList<Heading> newHeadings = new ArrayList<Heading>();
        for (int headingCounter = 0; headingCounter < 4; headingCounter++) 
            {
                Heading currentHeading = new Heading();
                switch (headingCounter)
                {
                    case 0:
                        currentHeading.header = txtHeading1.getText();
                        currentHeading.data = txtData1.getText();
                        break;
                    case 1:
                        currentHeading.header = txtHeading2.getText();
                        currentHeading.data = txtData2.getText();
                        break;
                    case 2:
                        currentHeading.header = txtHeading3.getText();
                        currentHeading.data = txtData3.getText();
                        break;
                    case 3:
                        currentHeading.header = txtHeading4.getText();
                        currentHeading.data = txtData4.getText();
                        break;
                }
                newHeadings.add(currentHeading);
            }
        return newHeadings;
    }
    
    public ArrayList<CellData> saveCellDataToMemory()
    {
        //Declare and instantiate new arrays to hold new incoming data
        ArrayList<CellData> newCellData = new ArrayList<CellData>();

        //CellData
        for (int y = 0; y < totalY; y++) 
        {
            for (int x = 0; x < totalX; x++) 
            {
                //Instantiate and assing values to temp CellData object
                CellData currentCell = new CellData();
                //Assign currentcell coordinates
                currentCell.x = x;
                currentCell.y = y;
                //Pull cell colour from fields array
                Color tempColour = fields[x][y].getBackground();
                int tempR = tempColour.getRed();
                int tempG = tempColour.getGreen();
                int tempB = tempColour.getBlue();
                ColorUtils colorUtils = new ColorUtils();
                String tempColourString = colorUtils.getColorNameFromRgb(tempR, tempG, tempB);
                if(!tempColourString.equals("White") && !fields[x][y].getText().equals(""))
                {
                    //Assign cell colour to current cell
                    currentCell.cellColour = tempColourString;
                    //Assign cell contents to current cell
                    currentCell.cellContents = fields[x][y].getText();
                    //Assign object to array
                    newCellData.add(currentCell);
                }
            }
        }
        return newCellData;
    }

    //</editor-fold>    

    
}
