package relocationmanager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class RelocationManager extends Frame implements WindowListener, ActionListener
{
    //Screen objects declerations
    Label lblContactName, lblContactType, lblPhoneNumber, lblWebsiteEmail, lblContactNotes, lblFind, lblTitle;
    TextField txtContactName, txtContactType, txtPhoneNumber, txtWebsiteEmail, txtFind, txtFilter;
    TextArea txtContactNotes;
    Button btnNew, btnSave, btnDel, btnFind, btnExit, btnFirst, btnPrev, btnNext, btnLast, btnSortContactName, btnBinarySearch, btnFilterBy;

    //Global Variables for array management
    int maxEntries = 100;     
    int numberOfEntries = 0;  
    int currentEntry = 0; 
    String fileName = "RelocationManager.txt";
    
    //Array to manage data
    RelocationContacts[] ContactInfo = new RelocationContacts[maxEntries];

    public static void main(String[] args)
    {
        Frame myFrame = new RelocationManager();
        myFrame.setSize(750,650);
        myFrame.setLocation(400, 200);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }

    public RelocationManager()
    {
        setTitle("Relocation Manager");
        setBackground(Color.pink);

        SpringLayout myLayout = new SpringLayout();
        setLayout(myLayout);
        
        LocateLabels(myLayout);
        LocateTextFields(myLayout);
        LocateTextAreas(myLayout);
        LocateButtons(myLayout);

        this.addWindowListener(this);
    }
  
    public void LocateLabels(SpringLayout myLabelLayout)
    {
        lblContactName = LocateALabel(myLabelLayout, lblContactName, "Contact Name:", 23, 125);
        lblContactType = LocateALabel(myLabelLayout, lblContactType, "Contact Type:", 23, 150);
        lblPhoneNumber = LocateALabel(myLabelLayout, lblPhoneNumber, "Phone Number:", 23, 175);
        lblWebsiteEmail = LocateALabel(myLabelLayout, lblWebsiteEmail, "Website or Email:", 23, 200);
        lblContactNotes = LocateALabel(myLabelLayout, lblContactNotes, "Contact Notes:", 23, 225);
        lblFind = LocateALabel(myLabelLayout, lblFind, "Find:", 545, 100);
        lblTitle = LocateALabel(myLabelLayout, lblTitle, "Relocation Manager", 23, 25);
        //LABEL COSMETICS
        //Title label
        lblTitle.setForeground(Color.BLUE);
        
    }

    public Label LocateALabel(SpringLayout myLabelLayout, Label myLabel, String  LabelCaption, int x, int y)
    {
        myLabel = new Label(LabelCaption);
        add(myLabel);        
        myLabelLayout.putConstraint(SpringLayout.WEST, myLabel, x, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, this);
        return myLabel;
    }
   
    public void LocateTextFields(SpringLayout myTextFieldLayout)
    {
        txtContactName  = LocateATextField(myTextFieldLayout, txtContactName, 40, 140, 125);
        txtContactType = LocateATextField(myTextFieldLayout, txtContactType, 40, 140, 150);
        txtPhoneNumber = LocateATextField(myTextFieldLayout, txtPhoneNumber, 40, 140, 175);
        txtWebsiteEmail = LocateATextField(myTextFieldLayout, txtWebsiteEmail, 40, 140, 200);
        txtFind = LocateATextField(myTextFieldLayout, txtFind, 11, 510, 125);
        txtFilter = LocateATextField(myTextFieldLayout, txtFilter, 15, 550, 350);
    }

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
        txtContactNotes = LocateATextArea(myTextAreaLayout, txtContactNotes, 5, 42, 140, 225);
        
    }

    public TextArea LocateATextArea(SpringLayout myTextAreaLayout, TextArea myTextArea, int height, int width, int x, int y)
    {
        myTextArea = new TextArea(height, width);
        add(myTextArea);        
        myTextAreaLayout.putConstraint(SpringLayout.WEST, myTextArea, x, SpringLayout.WEST, this);
        myTextAreaLayout.putConstraint(SpringLayout.NORTH, myTextArea, y, SpringLayout.NORTH, this);
        return myTextArea;
    }


    public void LocateButtons(SpringLayout myButtonLayout)
    {
        btnNew = LocateAButton(myButtonLayout, btnNew, "New", 520, 190, 80, 25);
        btnSave = LocateAButton(myButtonLayout, btnSave, "Save", 520, 215, 80, 25);
        btnDel = LocateAButton(myButtonLayout, btnDel, "Delete", 520, 240, 80, 25);
        btnFind = LocateAButton(myButtonLayout, btnFind, "Find", 520, 150, 80, 25);
        btnExit = LocateAButton(myButtonLayout, btnExit, "Exit", 520, 310, 80, 25);
        btnFirst = LocateAButton(myButtonLayout, btnFirst, "|<", 500, 275, 30, 25);
        btnPrev = LocateAButton(myButtonLayout, btnPrev, "<", 530, 275, 30, 25);
        btnNext = LocateAButton(myButtonLayout, btnNext, ">", 560, 275, 30, 25);
        btnLast = LocateAButton(myButtonLayout, btnLast, ">|", 590, 275, 30, 25);
        btnSortContactName = LocateAButton(myButtonLayout, btnSortContactName, "Sort by Contact Name:", 23, 350, 200, 25);
        btnBinarySearch = LocateAButton(myButtonLayout, btnBinarySearch, "Binary Search by Contact Name:", 233, 350, 200, 25);
        btnFilterBy = LocateAButton(myButtonLayout, btnFilterBy, "Filter By:", 443, 350, 100, 25);
    }

        public Button LocateAButton(SpringLayout myButtonLayout, Button myButton, String  ButtonCaption, int x, int y, int w, int h)
    {    
        myButton = new Button(ButtonCaption);
        add(myButton);
        myButton.addActionListener(this);
        myButtonLayout.putConstraint(SpringLayout.WEST, myButton, x, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, myButton, y, SpringLayout.NORTH, this);
        myButton.setPreferredSize(new Dimension(w,h));
        return myButton;
    }
  
    public void actionPerformed(ActionEvent e)
    {
        //FIND BUTTON
        if(e.getSource() == btnFind)
        {
            search();
        }
        //EXIT BUTTON
        if(e.getSource() == btnExit)
        {
            System.exit(0);
        }
        
        //NEW BUTTON
        if(e.getSource() == btnNew)
        {
            if( numberOfEntries < maxEntries -1)
            {
                currentEntry = numberOfEntries;
                resetTxtFields();
                displayEntry(currentEntry);
            }
        }
        
        //SAVE BUTTON
        if(e.getSource() == btnSave)
        {
            if(ContactInfo[currentEntry].getName() != null && currentEntry == numberOfEntries)
            {
                numberOfEntries++;
                saveEntry(currentEntry);
            }
            else if (ContactInfo[currentEntry].getName() != null)
            {
                saveEntry(currentEntry);
            }
        }
        
        //DELETE BUTTON
        if(e.getSource() == btnDel)
        {
            resetTxtFields();
            saveEntry(currentEntry);
        }
        
        //FIRST BUTTON
        if(e.getSource() == btnFirst)
        {
            displayEntry(0);
        }
        
        //PREVIOUS BUTTON
        if(e.getSource() == btnPrev)
        {
            if(currentEntry != 0)
            {
                displayEntry(currentEntry - 1);
            }
        }
        
        //NEXT BUTTON
        if(e.getSource() == btnNext)
        {
            if(currentEntry < numberOfEntries - 1)
            {
                 displayEntry(currentEntry + 1);
            }
        }
        
        //LAST BUTTON
        if(e.getSource() == btnLast)
        {
            displayEntry(numberOfEntries - 1);
        }
    }

    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }

    public void windowIconified(WindowEvent we)
    {
    }

    public void windowOpened(WindowEvent we)
    {
        readFile();
        displayEntry(currentEntry);
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
    
    public void resetTxtFields()
    {
        txtContactName.setText("");
        txtContactType.setText("");
        txtPhoneNumber.setText("");
        txtWebsiteEmail.setText("");
        txtContactNotes.setText("");
    }
    
    public void search()
    {
            boolean found = false;
            int i = 0;
            while (i < numberOfEntries && found == false)
            {
                String searchName = ContactInfo[i].getName().toLowerCase();
                if (searchName.contains(txtFind.getText()))
                {
                    found = true;
                }
                i++;
            }
            if (found) 
            {
                currentEntry = i - 1;
                displayEntry(currentEntry);
            }
    }
    
    public void displayEntry(int index)
    {
        txtContactName.setText(ContactInfo[index].getName());
        txtContactType.setText(ContactInfo[index].getType());
        txtPhoneNumber.setText(ContactInfo[index].getPhone());
        txtWebsiteEmail.setText(ContactInfo[index].getWebEmail());
        txtContactNotes.setText(ContactInfo[index].getNotes());
        currentEntry = index;
    }
    
    public void saveEntry(int index)
    {
        ContactInfo[index].setName(txtContactName.getText());
        ContactInfo[index].setType(txtContactType.getText());
        ContactInfo[index].setPhone(txtPhoneNumber.getText()); 
        ContactInfo[index].setWebEmail(txtWebsiteEmail.getText());
        ContactInfo[index].setNotes(txtContactNotes.getText());
		
        writeFile();
    }

    public void readFile()
    {
        try
        {
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            int i = 0;
            String line;
			
            while ((line = br.readLine()) != null)
            {
                String[] temp = line.split(";");
                ContactInfo[i] = new RelocationContacts(temp[0], temp[1], temp[2], temp[3], temp[4]);
                
                i++;
            }

            numberOfEntries = i;

            br.close();
            in.close();
            fstream.close();
        }
        catch (Exception e)
        {

            System.err.println("Error Reading File: " + e.getMessage());
        }
    }

    public void writeFile()
    {
        try
        {
            PrintWriter out = new PrintWriter(new FileWriter("RelocationManager.txt"));
            for(int m = 0; m < numberOfEntries; m++){
                out.println(ContactInfo[m].getName() +";" + ContactInfo[m].getType() + ";" + ContactInfo[m].getPhone() + ";" + ContactInfo[m].getWebEmail() + ";" + ContactInfo[m].getNotes() +";");
            }
             out.close();
        }
        catch (Exception e)
        {
            System.err.println("Error Writing File: " + e.getMessage());
        }
    }
}

class RelocationContacts
{
    private String Name = new String();
    private String Type = new String();
    private String Phone = new String();
    private String WebEmail = new String();
    private String Notes = new String();
    
    //Default Constructor - Assings default value
    public RelocationContacts()
    {
        Name = "Default";
        Type = "Default";
        Phone = "Default";
        WebEmail = "Default";
        Notes = "Default";
    }
    
    //Prefered Constructor with inputs given
    public RelocationContacts(String inputName, String inputType, String inputPhone, String inputWebEmail, String inputNotes)
    {
        Name = inputName;
        Type = inputType;
        Phone = inputPhone;
        WebEmail = inputWebEmail;
        Notes = inputNotes;
    }
    
    //Set method to change object values
    public void setRelocationContact (String inputName, String inputType, String inputPhone, String inputWebEmail, String inputNotes)
    {
        Name = inputName;
        Type = inputType;
        Phone = inputPhone;
        WebEmail = inputWebEmail;
        Notes = inputNotes;
    }

    //Setters and Getters
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getWebEmail() {
        return WebEmail;
    }

    public void setWebEmail(String WebEmail) {
        this.WebEmail = WebEmail;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }
}
