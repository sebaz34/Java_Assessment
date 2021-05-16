/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomplanner;

/**
 * The CellData class is to store data for the cells in the Room Planner project.
 * @author sebas
 */
public class CellData {
    
    public int y = 0;
    public int x = 0;
    public String cellContents = "";
    public String cellColour = "";
    public boolean fixed = false;
    
    //Get Methods
    public int getY()
    {
        return y;
    }
    public int getX()
    {
        return x;
    }
    public String getCellContents()
    {
        return cellContents;
    }
    public String getCellColour()
    {
        return cellColour;
    }
    public boolean getFixed()
    {
        return fixed;
    }
    
    //Set Methods
    public void setY(int y)
    {
        this.y = y;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setCellContents(String cellContents)
    {
        this.cellContents = cellContents;
    }
    public void setCellColour(String cellColour)
    {
        this.cellColour = cellColour;
    }
    public void setFixed(boolean fixed)
    {
        this.fixed = fixed;
    }
}
