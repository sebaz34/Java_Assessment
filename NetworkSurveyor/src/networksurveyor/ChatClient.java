package networksurveyor;
//Source relating to Chat:
//  Creating a simple Chat Client1/Server Solution 
//  http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html


//CHAT RELATED ---------------------------
import java.net.*;
import java.io.*;
//----------------------------------------

import java.awt.*;

public class ChatClient extends Frame
{

    //CHAT RELATED ---------------------------
    private Socket socket = null;
    private DataInputStream console = null;
    private DataOutputStream streamOut = null;
    private ChatClientThread client = null;
    private SurveyManager parentSurveyManager = null;
    private ClientSurvey parentClientSurvey = null;

    

    public static void main(String[] args)
    {
    }

    public ChatClient(String nameServer, int port, SurveyManager pSurveyManager)
    {
        parentSurveyManager = pSurveyManager;
        connect(nameServer, port);
    }
    
    public ChatClient(String nameServer, int port, ClientSurvey pClientSurvey)
    {
        parentClientSurvey = pClientSurvey;
        connect(nameServer, port);
    }

    public void connect(String serverName, int serverPort)
    {
        println("Establishing connection. Please wait ...");
        try
        {
            socket = new Socket(serverName, serverPort);
            println("Connected: " + socket);
            open();
        }
        catch (UnknownHostException uhe)
        {
            println("Host unknown: " + uhe.getMessage());
        }
        catch (IOException ioe)
        {
            println("Unexpected exception: " + ioe.getMessage());
        }
    }

    private void send()
    {
        try
        {
            streamOut.writeUTF("Test");
            streamOut.flush();
        }
        catch (IOException ioe)
        {
            println("Sending error: " + ioe.getMessage());
            close();
        }
    }
    
    public void send(String message)
    {
        try
        {
            streamOut.writeUTF(message);
            streamOut.flush();
        }
        catch(IOException ioe)
        {
            println("Sending Error:" + ioe.getMessage());
            close();
        }
    }

    public void handle(String msg)
    {
        if (msg.equals(".bye"))
        {
            println("Good bye. Press EXIT button to exit ...");
            close();
        }
        else
        {
            println(msg);
        }
    }

    public void open()
    {
        try
        {
            streamOut = new DataOutputStream(socket.getOutputStream());
            client = new ChatClientThread(this, socket);
        }
        catch (IOException ioe)
        {
            println("Error opening output stream: " + ioe);
        }
    }

    public void close()
    {
        try
        {
            if (streamOut != null)
            {
                streamOut.close();
            }
            if (socket != null)
            {
                socket.close();
            }
        }
        catch (IOException ioe)
        {
            println("Error closing ...");
        }
        client.close();
        client.stop();
    }

    void println(String msg)
    {
        if (msg.contains("SENTQ; ") || msg.contains("SENTA; ")) 
        {
            //Pull apart question message data
            String[] questionData = new String[10];
            questionData = msg.split(";");

            if (parentClientSurvey != null) 
            {
                if (questionData[0].equals("SENTQ")) 
                {
                    parentClientSurvey.txtQQuestion.setText(questionData[1]);
                    parentClientSurvey.txtQTopic.setText(questionData[2]);
                    parentClientSurvey.lblQuestionNum.setText(questionData[3]);
                    parentClientSurvey.txtQAnswerA.setText(questionData[4]);
                    parentClientSurvey.txtQAnswerB.setText(questionData[5]);
                    parentClientSurvey.txtQAnswerC.setText(questionData[6]);
                    parentClientSurvey.txtQAnswerD.setText(questionData[7]);
                    parentClientSurvey.txtQAnswerE.setText(questionData[8]);
                }
            }

            if (parentSurveyManager != null) 
            {
                if (questionData[0].equals("SENTA"))
                {
                    parentSurveyManager.UpdateLinkedList(questionData[1], questionData[2]);
                    
                }
            }
        }
        else
        {
            System.out.println(msg);
        }
        
        
        
    }

    public void getParameters()
    {
    
    }
    }
