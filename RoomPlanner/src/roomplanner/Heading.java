/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomplanner;

/**
 * The Heading class is to store data for the headings in the Room Planner project.
 * @author sebas
 */
public class Heading {
    
    public String header = "";
    public String data = "";
    
    
    //Get methods
    public String getHeader()
    {
        return header;
    }
    
    public String getData()
    {
        return data;
    }
    
    //Set methods
    public void setHeader(String header)
    {
        this.header = header;
    }
    
    public void setData(String data)
    {
        this.data = data;
    }
}
