package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * Chat_Server - Echo Server that starts the listener for the PORT (argument) on any server or computer.
 * It listens for any messages being sent, and prints out the message on the terminal/commandline.
 *
 * Compilation: javac -classpath . Server/chat_server.java
 * Example Usage: java -classpath . Server/chat_server <Port Number>
 */

public class chat_server {
    public static void main(String[] args) throws Exception {

        String port;
        int PORT;
        port = args[0];
        PORT = Integer.parseInt(port);

        //Begin SOCK - Transmission
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server Ready for Receiving:");

        Socket sock = serverSocket.accept();

        //Sending to Client
        OutputStream outputStream = sock.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);

        //Receiving From Server
        InputStream inputStream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inputStream));

        String receiveMessage, sendMessage;
        int messageLength;
        while (true) {
            if ((receiveMessage = receiveRead.readLine()) != null)
            {
                //final long receiveTime = System.currentTimeMillis();
                final long receiveTime = System.nanoTime();
                messageLength = receiveMessage.length();
                System.out.println(receiveTime + ": Message Length is " + messageLength);

                sendMessage = receiveMessage;
                printWriter.println(sendMessage);
                printWriter.flush();
            } else if (Objects.equals(receiveMessage = receiveRead.readLine(), "END"))
            {
                System.exit(0);
            }
        }

    }
}
