package edu.eci.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket powerSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			powerSocket = new Socket("127.0.0.1", 4567);
			out = new PrintWriter(powerSocket.getOutputStream(), true);
			in = new BufferedReader(
					new InputStreamReader(powerSocket.getInputStream()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		
		String input;
		
		System.out.println("please enter the list, elements separated by ',' end with '.'");
		while((input = stdin.readLine())!=null) {
			out.println(input);
			System.out.println("the sorted list is: " + in.readLine());
		}
		
		out.close();
		in.close();
		stdin.close();
		powerSocket.close();
	}

}
