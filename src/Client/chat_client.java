package Client;

import java.io.*;
import java.net.*;
import java.net.Socket;


public class chat_client
{
    public static void main(String[] args) throws Exception
    {

        String address;
        int PORT;

        if (args.length == 0)
        {
            System.out.println("No arguments were given");
        }
        else if (args.length != 3)
        {
            System.out.println("Incorrect number of arguments: Please provide the Address and PORT number");
        }
        else
        {
            address = args[1];
            PORT = Integer.parseInt(args[2]);
        }


        address = "localhost";
        PORT = 10000;

        Socket sock = new Socket("localhost", 10000);

        //Reading from Keyboard
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

        //Sending to client
        OutputStream osStream = sock.getOutputStream();

        //Print writer to print output
        PrintWriter pWriter = new PrintWriter(osStream, true);

        //Receiving from Server
        InputStream isStream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(isStream));

        System.out.println("Begin to start sending messages:");

        String receiveMessage, sendMessage;

        while(true)
        {
            sendMessage = keyRead.readLine(); // Reading from Keyboard
            pWriter.println(sendMessage);
            pWriter.flush();

            if((receiveMessage = receiveRead.readLine()) != null)
            {
                //Received from Server
                System.out.println(receiveMessage);
            }
        }
    }
}
