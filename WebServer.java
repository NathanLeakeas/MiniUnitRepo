import java.net.*;
import java.io.*;

public class WebServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket server = new ServerSocket(5580);
        while(true)
        {
            //try()
            //{
                Socket s = server.accept();
                System.out.println("Client connected from "+s.getInetAddress());
                HandleRequest service = new HandleRequest(s);
                Thread t = new Thread(service);
                t.start();

            //}
        }

    }
    
}

