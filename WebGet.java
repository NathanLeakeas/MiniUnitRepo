import java.net.*;
import java.util.Scanner;
import java.io.*;

public class WebGet
{

    public static void main(String[] args) throws UnknownHostException, IOException
    {
        //String hostname = args[0];
        final String hostname = "google.com";
        Socket s = new Socket(hostname,80);

        Scanner fromHost = new Scanner(s.getInputStream());
        PrintWriter toHost = new PrintWriter(s.getOutputStream());

        toHost.print("GET / HTTP/1.1\n Host: "+hostname+"\n\n");
        toHost.flush();

        boolean endHeader = false;
        while(!endHeader&&fromHost.hasNext()){
            String input = fromHost.nextLine();
            if(input.compareTo("")==0)
            {
                endHeader=true;
            }
            else
            {
                System.out.println(input);
            }

        }





        s.close();
    }



}