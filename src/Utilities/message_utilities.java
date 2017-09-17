package Utilities;

import java.lang.StringBuilder;

public class message_utilities {

    /**
     * Function to create message string to send from client to server.
     * Parameter byte_size limits the amount of string "a" to append to
     * the main string.
     * @param byte_size - The size that the message has to be.
     * @return builder.toString - Returns the message with the correct byte size.
     */

    public static String byte_message_size(int byte_size)
    {

        //Append string characters to reach
        String byte_message = "";
        StringBuilder builder = new StringBuilder(byte_message);

        int size_of_message = 0;

        /*
            Loop through byte size length to append string "a"
            to reach the length needed for string message
         */
        try
        {
            while (size_of_message < byte_size) {
                builder.append("a");
                size_of_message = builder.toString().getBytes().length;
            }
            return builder.toString();
        } catch (Exception ex)
        {
            return builder.toString();
        }

    }

}
