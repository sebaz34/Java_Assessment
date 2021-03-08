package relocationmanager;

// With Sample Modularisation

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.SpringLayout;

/**
 * @author Mark O'Reilly
 */

public class RelocationManager extends Frame implements WindowListener
{
    Label lblContactName, lblContactType, lblPhoneNumber, lblWebsiteEmail, lblContactNotes, lblFind;
    TextField txtContactName, txtContactType, txtPhoneNumber, txtWebsiteEmail, txtFind;
    TextArea txtContactNote;
    Button btnNew, btnSave, btnDel, btnFind, btnExit, btnFirst, btnPrev, btnNext, btnLast;

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
        txtContactNote = LocateATextArea(myTextAreaLayout, txtContactNote, 5, 20, 130, 125);
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


}
