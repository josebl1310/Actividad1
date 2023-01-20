package Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servidor extends Thread {
	//Creo los atributos del servidor
	private Socket socket;
	private PrintWriter output;
	private BufferedReader input;
	
	private String respuesta;
	private int opcion;

	//Le paso al constructor el socket del cliente
	public Servidor(Socket socket) {
		this.socket = socket;
	}
	//Funcion para controlar errores en la respuesta del cliente
	public static boolean isNumeric(String str) {
		try {
		Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	//Implemento la interfaz runneable para iniciar cada hilo del servidor
	public void run() {
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
			
			
			while (true) {
				//Envio las opciones al cliente
				output.println("\"Menu Mascotas: 1. Ver tlf | 2. Ver direccion | 3. Lista Perros | 4. Lista gatos | 5. Lista comida | 6. Salir\"");
				//Leo su respuesta y la convierto a un entero
				respuesta = input.readLine();
				if (isNumeric(respuesta))
					opcion = Integer.parseInt(respuesta);
				else
					opcion = 7;
				//Envio la opcion seleccionada por el cliente
				switch (opcion) {
					case 1:
						output.println("Nuestro numero de telefono es 78892776");
						break;
					case 2:
						output.println("Nuestra direccion es calle Ave del Paraiso 29 nº 57");
						break;
					case 3:
						output.println("1. Jack(Border Collie)2. Turron(Podenco) 3. Kifi(Jack Rusell)");
						break;
					case 4:
						output.println("1. Bola de nieve(Persa) 2. Anakin(Siames) 3. Hercules(Turco)");
						break;
					case 5:
						output.println("1. Royal Canin 2. Purina 3. Whyskas");
						break;
					case 6:
						System.out.println("Se cerro la conexion con el cliente");
						output.println("exit");
						break;
					default:
						output.println("La opcion proporcionada no es valida");
						break;
			}
			}
			
		}catch (Exception e) {
			System.out.println("Error en el servidor" + e.getStackTrace());
		}
		
		
	}
	

}
