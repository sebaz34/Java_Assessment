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
public class Question {
    //Variables
    public String question;
    public String topic;
    public int number;
    public String answerA;
    public String answerB;
    public String answerC;
    public String answerD;
    public String answerE;
    
    public static void main()
    {
        
    }
    
    public void newQuestion(String q, String t, int n, String a, String b, String c, String d, String e)
    {
        //assign passed through values to new object varible
        question = q;
        topic = t;
        number = n;
        answerA = a;
        answerB = b;
        answerC = c;
        answerD = d;
        answerE = e;
    }

    
//<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswerE() {
        return answerE;
    }

    public void setAnswerE(String answerE) {
        this.answerE = answerE;
    }
    
    //</editor-fold>
    
    
}
