package networksurveyor;
//Source:
//  Creating a simple Chat Client/Server Solution 
//  http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html


import java.net.*;
import java.io.*;

public class ChatServerThread extends Thread
{

    private ChatServer server = null;
    private Socket socket = null;
    private int ID = -1;
    private DataInputStream streamIn = null;
    private DataOutputStream streamOut = null;
    private Question question = new Question();

    public ChatServerThread(ChatServer _server, Socket _socket)
    {
        super();
        server = _server;
        socket = _socket;
        ID = socket.getPort();
    }

    public void send(Question question)
    {
        try
        {
            streamOut.writeUTF(question);
            streamOut.flush();
        }
        catch (IOException ioe)
        {
            System.out.println(ID + " ERROR sending: " + ioe.getMessage());
            server.remove(ID);
            stop();
        }
    }

    public int getID()
    {
        return ID;
    }

    public void run()
    {
        System.out.println("Server Thread " + ID + " running.");
        while (true)
        {
            server.handle(ID, question);
        }
    }

    public void open() throws IOException
    {
        streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        streamOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void close() throws IOException
    {
        if (socket != null)
        {
            socket.close();
        }
        if (streamIn != null)
        {
            streamIn.close();
        }
        if (streamOut != null)
        {
            streamOut.close();
        }
    }
}