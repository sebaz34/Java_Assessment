/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomplanner;

/**
 *
 * @author sebas
 */
public class Furniture {
    
    public String name = "";
    public int count = 0;
    
    //Get Methods
    public String getName(){
        return name;
    }
    
    public int getCount(){
        return count;
    }
    
    //Set Methods
    public void setName(String name){
        this.name = name;
    }
    
    public void setCount(int count){
        this.count = count;
    }
}
