package Servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try (ServerSocket serversocket = new ServerSocket(5500)){
			
			System.out.println("Servidor iniciado");
			
			while(true) {
				Socket socket = serversocket.accept();
				
				System.out.println("Conexión con el cliente iniciada");
				
				Servidor servidor = new Servidor(socket);
				
				servidor.start();
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en el main" + e.getStackTrace());
		}
		
		
	}

}
