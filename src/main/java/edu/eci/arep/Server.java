package edu.eci.arep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//import edu.escuelaing.arem.handlers.Handler;
//import edu.escuelaing.arem.handlers.impl.HTMLHandler;
//import edu.escuelaing.arem.handlers.impl.ICOHandler;
//import edu.escuelaing.arem.handlers.impl.PNGHandler;

public class Server {

	public static void main(String[] args) throws IOException {
		//Handler handler;
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(getPort());
		} catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
		}
		PrintWriter out;
		BufferedReader in;
		
		while(true)
		{
		Socket clientSocket = null;
		
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(
				new InputStreamReader(
						clientSocket.getInputStream()));
				
		
		String inputLine;
		String outputLine;
		String request = null;
		
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.matches("(GET)+.*")) {
					request = inputLine.split(" ")[1];
				}
				if(!in.ready())
					break;	
			}
			
		request = request == null ? "/error.html" : request;
            request = request.equals("/") ? "/index.html" : request;
            
            
            StringBuilder response = new StringBuilder();
    		
    		try {
    			BufferedReader reader = new BufferedReader(
    					new FileReader(System.getProperty("user.dir") + "/src/resources/static" + request));
    			String inputfile;
    			while ((inputfile = reader.readLine()) != null)
    				response.append(inputfile);
    			out.println("HTTP/1.1 200 OK \r");
    			out.println("Content-Type: text/html \r");
    			out.println("\r");
    			out.println(response.toString());

    			reader.close();

    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
//			if (request.matches("(/apps).*")) {
//
//			} else if (request.matches(".*(.html)")) {
//				handler = new HTMLHandler();
//				handler.handle(out, clientSocket.getOutputStream(), request);
//			} else if (request.matches(".*(.PNG)")) {
//				handler = new PNGHandler();
//				handler.handle(out, clientSocket.getOutputStream(), request);
//			} else if (request.matches(".*(.ico)")) {
//				handler = new ICOHandler();
//				handler.handle(out, clientSocket.getOutputStream(), request);
//			}
			out.close();
			in.close();
				

		}
	}
	
	static int getPort() {
		return System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : 4567;
	}

}

