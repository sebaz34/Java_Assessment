/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksurveyor;

/**
 *
 * @author sebas
 */
public class NetworkSurveyor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Run Application Window
        SurveyManager runWindow = new SurveyManager();
        runWindow.setVisible(true);
        
        runWindow.txtQQuestion.setText("How large are elephants?");
       
    }
    
}
