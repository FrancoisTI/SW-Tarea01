package com.example.demo.socket.mensaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private final Integer PORT = 13;
	
	
	public Server() {
		Socket clientSocket;
		try {
			ServerSocket serversocket = new ServerSocket(PORT);
			while(true) {
				System.out.println("-------1 Iniciando serverSocket >> Torres <<---------");
				System.out.println("-------2 A la espera del clientSocket ---------");
				clientSocket = serversocket.accept();
				System.out.println("-------3 Llegó el clientSocket");
				 
				//flujos de comunicación --- Por donde se envía el mensaje
				BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(), true);
				
				String opcion = entrada.readLine();
				System.out.println("-------4 Llegó la opción " + opcion);
				switch (opcion) {
				case "Platea": 			salida.println("PEN 50");break;
				case "VIP": 			salida.println("PEN 100");break;
				case "Platinium": 		salida.println("PEN 150");break;
				
			
				}
				
				
				System.out.println("-------5 Finaliza la atención clientSocket");
				clientSocket.close();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
