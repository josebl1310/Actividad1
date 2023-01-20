package Servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creo el servidor
		try (ServerSocket serversocket = new ServerSocket(5500)){
			
			System.out.println("Servidor iniciado");
			
			while(true) {
				//Recojo el socket del cliente
				Socket socket = serversocket.accept();
				
				System.out.println("Conexión con el cliente " +socket.getPort()+ " iniciada");
				//Creo el hilo y le paso el socket del cliente
				Servidor servidor = new Servidor(socket);
				
				servidor.start();
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en el main" + e.getStackTrace());
		}
		
		
	}

}
