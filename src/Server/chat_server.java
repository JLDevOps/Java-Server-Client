package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class chat_server {
    public static void main(String[] args) throws Exception
    {
        String address = "localhost";
        int PORT = 10000;

        //Begin SOCK - Transmission
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server Ready for Receiving:");

        Socket sock = serverSocket.accept();

        //Reading from Keyboard
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

        //Sending to Client
        OutputStream outputStream = sock.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);

        //Receiving From Server
        InputStream inputStream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inputStream));

        String receiveMessage, sendMessage;
        while(true)
        {
            if ((receiveMessage = receiveRead.readLine()) != null)
            {
                System.out.println(receiveMessage);

                sendMessage = keyRead.readLine();
                printWriter.println(sendMessage);
                printWriter.flush();
            }
        }

    }
}
