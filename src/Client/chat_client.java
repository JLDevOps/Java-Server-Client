package Client;

import java.io.*;
import java.net.Socket;
import Utilities.message_utilities;

/**
 * Chat_Client - Client side to communicate with the echo server to send messages with the correct bytes
 * to the echo server.
 *
 * Compilation: javac -classpath . Client/chat_client.java
 * Example Usage: java -classpath . Client/chat_client <address> <Port Number> <Number of Trial Runs>
 */

public class chat_client
{
    /**
     * Method to send messages to the echo server.
     * @param message - The generated message that contain the correct, 10, 1000, or 10,000 size bytes to be sent.
     * @param pWriter - PrintWriter that sends the messages to the correct socket.
     * @param receiveRead - BufferedReader that reads message from echo-server
     * @throws Exception - Exception is thrown if a message is not reached/sent
     */
    private static void sendMessage(String message, PrintWriter pWriter, BufferedReader receiveRead) throws Exception
    {

        int messageLength = message.length();
        final long sentTime = System.nanoTime();
        pWriter.println(message);
        pWriter.flush();
        if ((receiveRead.readLine()) != null) {
            System.out.println("Message Length Received: " + messageLength);
        }
        final long receiveTime = System.nanoTime();
        final long totalTime = receiveTime - sentTime;
        double totalSeconds = (totalTime/1000000000.0);
        System.out.println("Total Time from Send to Receive from Server: " + totalTime + " Nano-Seconds or  " + totalSeconds + " Seconds");
    }

    /**
     * Method to run the set amount of tests for client to server echos -- Mainly used for sending only specific set amount of bits
     * @param counter -- Counter to read iteratively to match test limits.
     * @param numberOfRuns -- Amount of runs that the user wants.
     * @param message -- Message generated from 10 bytes, 1,000 bytes, or 10,0000 bytes
     * @param pWriter -- PrinterWriter to send messages to the echo server
     * @param receiveRead -- BufferedReader object to read receive messages.
     * @throws Exception -- Throws general exceptions for any errors
     */

    private static void runTest(int counter, int numberOfRuns, String message, PrintWriter pWriter, BufferedReader receiveRead) throws Exception{
        System.out.println("-----Test------");
        while (counter < numberOfRuns)
        {
            sendMessage(message, pWriter, receiveRead);
            counter++;
        }
    }

    public static void main(String[] args) throws Exception
    {
        String address;
        int PORT;
        int numberOfRuns;

        address = args[0];
        PORT = Integer.parseInt(args[1]);
        numberOfRuns = Integer.parseInt(args[2]);

        Socket sock = new Socket(address, PORT);

        //Sending to client
        OutputStream osStream = sock.getOutputStream();

        //Print writer to print output
        PrintWriter pWriter = new PrintWriter(osStream, true);

        //Receiving from Server
        InputStream isStream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(isStream));

        System.out.println("Begin to start sending messages:");

        String ten_byte_message = message_utilities.byte_message_size(10);
        String thousand_byte_message = message_utilities.byte_message_size(1000);
        String ten_thousand_byte_message = message_utilities.byte_message_size(10000);

        int counter = 0;
        runTest(counter, numberOfRuns, ten_byte_message, pWriter, receiveRead);

        counter = 0;
        runTest(counter, numberOfRuns, thousand_byte_message, pWriter, receiveRead);

        counter = 0;
        runTest(counter, numberOfRuns, ten_thousand_byte_message, pWriter, receiveRead);


        System.out.println("-----Test------");
        counter = 0;
        while (counter < numberOfRuns)
        {
            sendMessage(ten_byte_message, pWriter, receiveRead);
            sendMessage(thousand_byte_message, pWriter, receiveRead);
            sendMessage(ten_thousand_byte_message, pWriter, receiveRead);
            counter++;
        }

    }
}
