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
    Label lblContactName, lblContactType, lblPhoneNumber, lblWebsiteEmail, lblContactNotes, lblFind;
    TextField txtContactName, txtContactType, txtPhoneNumber, txtWebsiteEmail, txtFind;
    TextArea txtContactNotes;
    Button btnNew, btnSave, btnDel, btnFind, btnExit, btnFirst, btnPrev, btnNext, btnLast;

    int maxEntries = 100;     
    int numberOfEntries = 0;  
    int currentEntry = 0;    
    
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
        
        LocateLabels(myLayout);
        LocateTextFields(myLayout);
        LocateTextAreas(myLayout);
        LocateButtons(myLayout);

        this.addWindowListener(this);
    }
  
    public void LocateLabels(SpringLayout myLabelLayout)
    {
        lblContactName = LocateALabel(myLabelLayout, lblContactName, "Contact Name:", 23, 25);
        lblContactType = LocateALabel(myLabelLayout, lblContactType, "Contact Type:", 23, 50);
        lblPhoneNumber = LocateALabel(myLabelLayout, lblPhoneNumber, "Phone Number:", 23, 75);
        lblWebsiteEmail = LocateALabel(myLabelLayout, lblWebsiteEmail, "Website or Email:", 23, 100);
        lblContactNotes = LocateALabel(myLabelLayout, lblContactNotes, "Contact Notes:", 23, 125);
        lblFind = LocateALabel(myLabelLayout, lblFind, "Find", 390, 25);
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
        txtContactName  = LocateATextField(myTextFieldLayout, txtContactName, 20, 140, 25);
        txtContactType = LocateATextField(myTextFieldLayout, txtContactType, 20, 140, 50);
        txtPhoneNumber = LocateATextField(myTextFieldLayout, txtPhoneNumber, 20, 140, 75);
        txtWebsiteEmail = LocateATextField(myTextFieldLayout, txtWebsiteEmail, 20, 140, 100);
        txtFind = LocateATextField(myTextFieldLayout, txtFind, 10, 430, 25);
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
        txtContactNotes = LocateATextArea(myTextAreaLayout, txtContactNotes, 5, 25, 140, 125);
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
        btnNew = LocateAButton(myButtonLayout, btnNew, "New", 420, 90, 80, 25);
        btnSave = LocateAButton(myButtonLayout, btnSave, "Save", 420, 115, 80, 25);
        btnDel = LocateAButton(myButtonLayout, btnDel, "Delete", 420, 140, 80, 25);
        btnFind = LocateAButton(myButtonLayout, btnFind, "Find", 420, 50, 80, 25);
        btnExit = LocateAButton(myButtonLayout, btnExit, "Exit", 420, 210, 80, 25);
        btnFirst = LocateAButton(myButtonLayout, btnFirst, "|<", 400, 175, 30, 25);
        btnPrev = LocateAButton(myButtonLayout, btnPrev, "<", 430, 175, 30, 25);
        btnNext = LocateAButton(myButtonLayout, btnNext, ">", 460, 175, 30, 25);
        btnLast = LocateAButton(myButtonLayout, btnLast, ">|", 490, 175, 30, 25);
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
            if(ContactName != null && currentEntry == numberOfEntries)
            {
                numberOfEntries++;
                saveEntry(currentEntry);
            }
            else if (ContactName != null)
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
                if (ContactName[i].equals(txtFind.getText()))
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
        txtContactName.setText(ContactName[index]);
        txtContactType.setText(ContactType[index]);
        txtPhoneNumber.setText(PhoneNumber[index]);
        txtWebsiteEmail.setText(WebsiteEmail[index]);
        txtContactNotes.setText(ContactNotes[index]);
        currentEntry = index;
    }
    
    public void saveEntry(int index)
    {
        ContactName[index] = txtContactName.getText();
        ContactType[index] = txtContactType.getText();
        PhoneNumber[index] = txtPhoneNumber.getText();
        WebsiteEmail[index] = txtWebsiteEmail.getText();
        ContactNotes[index] = txtContactNotes.getText();
		
        writeFile();
    }

    public void readFile()
    {
        try
        {
            FileInputStream fstream = new FileInputStream("RelocationManager.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            int i = 0;
            String line;
			
            while ((line = br.readLine()) != null)
            {
                String[] temp = line.split(";");
                ContactName[i] = temp[0];
                ContactType[i] = temp[1];
                PhoneNumber[i] = temp[2];
                WebsiteEmail[i] = temp[3];
                ContactNotes[i] = temp[4];
                
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
                out.println(ContactName[m] +";" + ContactType[m] + ";" + PhoneNumber[m] + ";" + WebsiteEmail[m] + ";" + ContactNotes[m] +";");
            }
             out.close();
        }
        catch (Exception e)
        {
            System.err.println("Error Writing File: " + e.getMessage());
        }
    }
}
