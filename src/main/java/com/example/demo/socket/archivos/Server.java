package com.example.demo.socket.archivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private final Integer PORT = 13;
	
	
	public Server() {
		Socket clientSocket;
		try {
			ServerSocket serversocket = new ServerSocket(PORT);
			while(true) {
				System.out.println("-------1 Iniciando serverSocket >>Francois << ---------");
				System.out.println("-------2 A la espera del clientSocket ---------");
				clientSocket = serversocket.accept();
				System.out.println("-------3 Llegó el clientSocket");
				
				//File captura el archivo
				File  fileDestino = new File("D:/server/Java2.jpeg");
				FileOutputStream fos = new FileOutputStream(fileDestino);
				//DataOutput envia el archivo
				DataInputStream entrada = new DataInputStream(clientSocket.getInputStream());
				
				int byteLeidos;
				while( (byteLeidos = entrada.read()) != -1) {
					fos.write(byteLeidos);
				}
				fos.close();
				entrada.close();
				
				
				System.out.println("-------4 Finaliza la atención clientSocket");
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
