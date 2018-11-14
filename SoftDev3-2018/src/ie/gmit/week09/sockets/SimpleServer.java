package ie.gmit.week09.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) throws IOException {
		 ServerSocket listener = new ServerSocket(9090);
		 
		 while(true) {
			 Socket socket = listener.accept();
			 try {
				 
				 PrintWriter out =
						 new PrintWriter(socket.getOutputStream(), true);
			 	out.println("hello");
			 	
			 	while (true) {
			 		BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
			 		String input = in.readLine();
			 		if (input==null  || ".".equals(input)) {
			 			break;
			 		}
			 		out.println("nice to meet you "+input);
			 	}
			 	
			 }finally{
				 socket.close();
			 }
		 }
		 //System.out.println("doone");

	}

}
