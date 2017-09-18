README:

TCP - ECHO SERVER / CLIENT Experiment

How to RUN/COMPILE the client, server, and utilities java files for USE:

Steps:
	1. Compile/Run the Server File
	2. Compile/Run the Client File
    3. Usage Examples


Each Step:

1. For the Server File:
	1. Go into the "src" folder
		1. cd src
	2. To compile the java class
		1. javac -classpath . Server/chat_server.java
	3. After Compilation:
		1. If the compilation is successful:
			a. Run this command to initialize the server:
				a. java -classpath . Server.chat_server <Port Number>
				b. Example: java -classpath . Server.chat_server 10000
				    a. **Check which ports are currently open
		2. Else:
			a. Immediately contact the programmer
	4. The server will display a successful message with: "Server Ready for Receiving"

**If you are on the Rutgers Network and setting up the Server on any ILABS machine -- please use any ports more than 1024
due to permission error.  Recommended to use PORT - 10000


2. For the Client File:
	1. Go into the "src" folder
		1. cd src
	2. To compile the java class
		1. javac -classpath . Client/chat_client.java
	3. After Compilation:
		1. If the compilation is successful:
			a. Run this command to initialize the server:
				a. java -classpath . Client.chat_client <address> <Port Number> <Number of Trials>
				b. Example: java -classpath . Client.chat_client localhost 10000 5
				    a. **Check the address and the port to correctly connect to the server.
		2. Else:
			a. Immediately contact the programmer
	4. The server will display a successful message with: "Server Ready for Receiving"


3. For Same Hosts:
    1. Recommended Settings/Arguments for Server:
        a. Same Host: (Any port number)
            1. java -classpath . Server.chat_server 10000

4. Different Host: (Use python script provided to find Ports available):
    1. On the external server - run python port_scanner_open.py
        1. Results should provide several open ports and the ip-address for the client to connect to.
        2. java -classpath . Client.chat_client <address: hostname or ip> <port> <number of runs>
            1. Example - using cpp.rutgers.edu
            2. java -classpath . Client.chat_client 128.6.13.238 10000 5

Quick Commands:

1. cd TCP-Chat/src
2. javac -classpath . Server/chat_server.java
3. java -classpath . Server.chat_server <Port Number>
4. javac -classpath . Client/chat_client.java
5. java -classpath . Client.chat_client <address> <Port Number> <Number of Trials>
