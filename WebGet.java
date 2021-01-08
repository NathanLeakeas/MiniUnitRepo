import java.net.*;
import java.util.Scanner;
import java.io.*;

public class WebGet
{

    public static void main(String[] args) throws IOException
    {
        String hostname, resource;
        if(args.length==2)
        {
            hostname = args[0];
            resource = args[1];
        }
        else
        {
            System.out.println("No Host, using horstmann.com instead");
            hostname = "horstmann.com";
            resource = "/";
        }
        try(Socket s = new Socket(hostname,80))
        {
            Scanner fromHost = new Scanner(s.getInputStream());
            PrintWriter toHost = new PrintWriter(s.getOutputStream());
    
            toHost.print("GET "+ resource + " HTTP/1.1\r\n" + "Host: " +hostname+"\r\n\r\n");
            toHost.flush();
    
            System.out.println("Getting "+resource+" from "+hostname);
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



}