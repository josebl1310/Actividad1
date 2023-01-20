package Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Me conecto al servidor y defino las variables
		try (Socket socket = new Socket("localhost", 5500)){
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			Scanner scanner = new Scanner (System.in);
			String userInput;
			String userOutput;
		
			
			
			
			do {
				//Recojo lo que me dice el servidor
				userInput= input.readLine();
				System.out.println(userInput);
				
				System.out.println("---------------");
				System.out.println("Elija una opcion del menú");
				//Recojo por teclado la opcion que quiero y se la envio al servidor
				userOutput = scanner.nextLine();
				output.println(userOutput);
				
				//Recojo la respuesta, si no es la de salir la imprimo y continuo el bucle
				userInput = input.readLine();
				
				if (!userInput.equals("exit"))
					System.out.println(userInput);
				else {
					input.close();
					scanner.close();
					System.out.println("Hasta pronto");
				}
					
				
				
				
			}while(!userInput.equals("exit"));
			
		}catch (Exception e) {
			System.out.println("Error en el main" + e.getStackTrace());
		}
		
	}

}
