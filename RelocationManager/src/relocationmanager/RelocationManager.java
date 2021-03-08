package relocationmanager;

// With Sample Modularisation

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.SpringLayout;

/**
 * @author Mark O'Reilly
 */

public class RelocationManager extends Frame implements WindowListener
{
    Label lblContactName, lblContactType, lblPhoneNumber, lblWebsiteEmail, lblContactNotes, lblFind;
    TextField txtContactName, txtContactType, txtPhoneNumber, txtWebsiteEmail, txtFind;
    TextArea txtContactNotes;
    Button btnNew, btnSave, btnDel, btnFind, btnExit, btnFirst, btnPrev, btnNext, btnLast;

    int maxEntries = 100;     // Global variable to define the maximum size of the 3 arrays.
    int numberOfEntries = 0;  // Global variable to remember how many actual entries are currently in the 3 arrays.
    int currentEntry = 0;     // Global variable to remember which entry in the arrays we are currently focused on.
    
    // Declare the 3 arrays for storing the PC/IP data in memory - each has a maximum size of
	//         maxEntries (currently equal to 100 entries)
    String[] ContactName = new String[maxEntries];   
    String[] ContactType = new String[maxEntries];
    String[] PhoneNumber = new String[maxEntries];
    String[] WebsiteEmail = new String[maxEntries];
    String[] ContactNotes = new String[maxEntries];


    
    public static void main(String[] args)
    {
        Frame myFrame = new RelocationManager();
        myFrame.setSize(600,350);
        myFrame.setLocation(400, 200);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }

    public RelocationManager()
    {
        setTitle("Relocation Manager");
        setBackground(Color.white);

        SpringLayout myLayout = new SpringLayout();
        setLayout(myLayout);
        
	// Call the methods below to instantiate and place the various screen components
        LocateLabels(myLayout);
        LocateTextFields(myLayout);
        LocateTextAreas(myLayout);
        LocateButtons(myLayout);

        this.addWindowListener(this);
    }

    //------------------------------------------------------------------------------------------
    // Method that manages the adding of multiple Labels to the screen.
    // Each line requests the LocateALabel method to instantiate, add and place a specific Label  
    public void LocateLabels(SpringLayout myLabelLayout)
    {
        lblContactName = LocateALabel(myLabelLayout, lblContactName, "Contact Name:", 23, 25);
        lblContactType = LocateALabel(myLabelLayout, lblContactType, "Contact Type:", 23, 50);
        lblPhoneNumber = LocateALabel(myLabelLayout, lblPhoneNumber, "Phone Number:", 23, 75);
        lblWebsiteEmail = LocateALabel(myLabelLayout, lblWebsiteEmail, "Website or Email:", 23, 100);
        lblContactNotes = LocateALabel(myLabelLayout, lblContactNotes, "Contact Notes:", 23, 125);
        lblFind = LocateALabel(myLabelLayout, lblFind, "Find", 390, 25);
    }

    /**
    * Method with low coupling and high cohesion 
    *    for adding individual labels:
    *    - reduces overall code, especially in the
    *         LocateLabels method.
    *    - makes this method re-usable with minimal
    *         adjustment as it is moved from one
    *         program to another.
    */
    public Label LocateALabel(SpringLayout myLabelLayout, Label myLabel, String  LabelCaption, int x, int y)
    {
        myLabel = new Label(LabelCaption);
        add(myLabel);        
        myLabelLayout.putConstraint(SpringLayout.WEST, myLabel, x, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, this);
        return myLabel;
    }
   

    //------------------------------------------------------------------------------------------
    // Method that manages the adding of multiple TextFields to the screen.
    // Each line requests the LocateATextField method to instantiate, add and place a specific TextField  
    public void LocateTextFields(SpringLayout myTextFieldLayout)
    {
        txtContactName  = LocateATextField(myTextFieldLayout, txtContactName, 20, 130, 25);
        txtContactType = LocateATextField(myTextFieldLayout, txtContactType, 20, 130, 50);
        txtPhoneNumber = LocateATextField(myTextFieldLayout, txtPhoneNumber, 20, 130, 75);
        txtWebsiteEmail = LocateATextField(myTextFieldLayout, txtWebsiteEmail, 20, 130, 100);
        txtFind = LocateATextField(myTextFieldLayout, txtFind, 10, 430, 25);
    }

    /**
    * Method with low coupling and high cohesion 
    *    for adding individual text boxes:
    *    - reduces overall code, especially in the
    *         LocateTextFields method.
    *    - makes this method re-usable with minimal
    *         adjustment as it is moved from one
    *         program to another.
    */
    public TextField LocateATextField(SpringLayout myTextFieldLayout, TextField myTextField, int width, int x, int y)
    {
        myTextField = new TextField(width);
        add(myTextField);        
        myTextFieldLayout.putConstraint(SpringLayout.WEST, myTextField, x, SpringLayout.WEST, this);
        myTextFieldLayout.putConstraint(SpringLayout.NORTH, myTextField, y, SpringLayout.NORTH, this);
        return myTextField;
    }

    
    public void LocateTextAreas(SpringLayout myTextAreaLayout)
    {
        txtContactNotes = LocateATextArea(myTextAreaLayout, txtContactNotes, 5, 20, 130, 125);
    }

    /**
    * Method with low coupling and high cohesion 
    *    for adding individual text boxes:
    *    - reduces overall code, especially in the
    *         LocateTextFields method.
    *    - makes this method re-usable with minimal
    *         adjustment as it is moved from one
    *         program to another.
    */
    public TextArea LocateATextArea(SpringLayout myTextAreaLayout, TextArea myTextArea, int height, int width, int x, int y)
    {
        myTextArea = new TextArea(height, width);
        add(myTextArea);        
        myTextAreaLayout.putConstraint(SpringLayout.WEST, myTextArea, x, SpringLayout.WEST, this);
        myTextAreaLayout.putConstraint(SpringLayout.NORTH, myTextArea, y, SpringLayout.NORTH, this);
        return myTextArea;
    }

    //------------------------------------------------------------------------------------------
    // Method that manages the adding of multiple Buttons to the screen.
    // Each line requests the LocateAButton method to instantiate, add and place a specific Button  
    public void LocateButtons(SpringLayout myButtonLayout)
    {
        btnNew = LocateAButton(myButtonLayout, btnNew, "New", 420, 90, 80, 25);
        btnSave = LocateAButton(myButtonLayout, btnSave, "Save", 420, 115, 80, 25);
        btnDel = LocateAButton(myButtonLayout, btnDel, "Delete", 420, 140, 80, 25);
        btnFind = LocateAButton(myButtonLayout, btnFind, "Find", 420, 50, 80, 25);
        btnExit = LocateAButton(myButtonLayout, btnExit, "Exit", 320, 170, 80, 25);
        btnFirst = LocateAButton(myButtonLayout, btnFirst, "|<", 400, 175, 30, 25);
        btnPrev = LocateAButton(myButtonLayout, btnPrev, "<", 430, 175, 30, 25);
        btnNext = LocateAButton(myButtonLayout, btnNext, ">", 460, 175, 30, 25);
        btnLast = LocateAButton(myButtonLayout, btnLast, ">|", 490, 175, 30, 25);
    }

    /**
    * Method with low coupling and high cohesion 
    *    for adding individual buttons:
    *    - reduces overall code, especially in the
    *         LocateButtons method.
    *    - makes this method re-usable with minimal
    *         adjustment as it is moved from one
    *         program to another.
    */
    public Button LocateAButton(SpringLayout myButtonLayout, Button myButton, String  ButtonCaption, int x, int y, int w, int h)
    {    
        myButton = new Button(ButtonCaption);
        add(myButton);
        myButtonLayout.putConstraint(SpringLayout.WEST, myButton, x, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, myButton, y, SpringLayout.NORTH, this);
        myButton.setPreferredSize(new Dimension(w,h));
        return myButton;
    }
  

    // Manage responses to the various Window events
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }

    public void windowIconified(WindowEvent we)
    {
    }

    public void windowOpened(WindowEvent we)
    {
    }

    public void windowClosed(WindowEvent we)
    {
        
    }

    public void windowDeiconified(WindowEvent we)
    {
    }

    public void windowActivated(WindowEvent we)
    {
    }

    public void windowDeactivated(WindowEvent we)
    {
    }
    
// Display the required data entry (record) in the Frame
    // The calling method must specify the number (index) of the entry that this
    //     method needs to currently display on screen.
    public void displayEntry(int index)
    {
        // Take the required entry from the PCName array and display it
        //      in the txtPCName TextField.
        txtContactName.setText(ContactName[index]);
        txtContactType.setText(ContactType[index]);
        txtPhoneNumber.setText(PhoneNumber[index]);
        txtWebsiteEmail.setText(WebsiteEmail[index]);
        txtContactNotes.setText(PhoneNumber[index]);
        currentEntry = index;
    }

    ///START FROM HERE//
    
    
    // Take the current record displayed on screen and save it back into the 'currentEntry' position
    //      of the 3 arrays.
    public void saveEntry(int index)
    {
        // Take the current entry in the txtPCName TextField (on screen) and copy it 
        //      into the appropriate (currentEntry) position of the PCName array.
        PCName[index] = txtPCName.getText();
        PCID[index] = txtPCID.getText();
        IPAddresses[index] = txtIP.getText();
		
        // (If required) Call the method below that writes the data back to the data file.
        writeFile();
    }

        
    // Read in the data from the data file - IPAddresses.txt - one line at a time and store in the 3 arrays.
    // Remember the number of entries read in, in the global variable: numberOfEntries.
    public void readFile()
    {
        // Try to read in the data and if an exception occurs go to the Catch section 
        try
        {
            // Set up vaious streams for reading in the content of the data file.
            FileInputStream fstream = new FileInputStream("RelocationManager.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            int i = 0;   // i is used as the line counter
            String line; // line is used to temporarily store the line read in from the data file
			
            // Read a line from the data file into the buffer and then check whether
            //      it is null.  The while loop continues until a line read in is null.
            while ((line = br.readLine()) != null)
            {
                // Split the line of data (from the text file) and put each entry into the
                //                                             temporary array - temp[]
                String[] temp = line.split(";");

                // Save each entry into its respective array:
                PCName[i] = temp[0];      //Takes the first entry in temp and puts it in the PCName array at the current location
                PCID[i] = temp[1];        //Takes the second entry in temp and puts it in the PCID array at the current location
                IPAddresses[i] = temp[2]; //Takes the third entry in temp and puts it in the IPAddress array at the current location

                i++;  // Increment i so we can keep a count of how many entries have been read in.
            }

            numberOfEntries = i;   // Set numberOfEntries equal to i, so as to remember how many entries are now in the arrays 

            br.close();            // Close the BufferedReader
            in.close();            // Close the DataInputStream
            fstream.close();       // Close the FileInputStream
        }
        catch (Exception e)
        {
            // If an exception occurs, print an error message on the console.
            System.err.println("Error Reading File: " + e.getMessage());
        }
    }

    
    // Write the data back out to the data file - one line at a time
    // Note: You may wish to use a different data file name while initially
    //       developing, so as not to accidently corrupt your input file.
    public void writeFile()
    {
        // Try to print out the data and if an exception occurs go to the Catch section 
        try
        {
            // After testing has been completed, replace the hard-coded filename: "IPAddresses_New.txt"
            //       with the parameter variable: fileName 
            // Set up a PrintWriter for printing the array content out to the data file.
            PrintWriter out = new PrintWriter(new FileWriter("IPAddresses.txt"));
            
            // Print out each line of the array into your data file.
            // Each line is printed out in the format:  PCName,PCID,IPAddress
            for(int m = 0; m < numberOfEntries; m++){
                out.println(PCName[m] +"," +PCID[m] + "," + IPAddresses[m]);
            }

            // Close the printFile (and in so doing, empty the print buffer)
             out.close();
        }
        catch (Exception e)
        {
            // If an exception occurs, print an error message on the console.
            System.err.println("Error Writing File: " + e.getMessage());
        }
    }
}
