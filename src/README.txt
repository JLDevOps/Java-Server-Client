README:

TCP - ECHO SERVER / CLIENT Experiment

To RUN/COMPILE the client, server, and utilities java files for USE:

Steps:
	1. Compile/Run the Server File
	2. Compile/Run the Client File


For the Server File:
	1. Go into the "src" folder
		1. cd src
	2. To compile the java class
		1. javac -classpath . Server/chat_server.java
	3. After Compilation:
		1. If the compilation is successful:
			a. Run this command to initialize the server:
				a. java -classpath . Server.chat_server
		2. Else:
			a. Immediately contact the programmer
	4. The server will display a successful message with: "Server Ready for Receiving"

For the Client File:
	1. Go into the "src" folder
		1. cd src
	2. To compile the java class
		1. javac -classpath . Client/chat_client.java
	3. After Compilation:
		1. If the compilation is successful:
			a. Run this command to initialize the server:
				a. java -classpath . Client.chat_client
		2. Else:
			a. Immediately contact the programmer
	4. The server will display a successful message with: "Server Ready for Receiving"


Quick Commands:

1. cd TCP-Chat/src
2. javac -classpath . Server/chat_server.java
3. java -classpath . Server/chat_server
4. javac -classpath . Client/chat_client.java
5. java -classpath . Client/chat_client
