import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatbotServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
ServerSocket listener= new ServerSocket(9999);
		
		System.out.println("Servidor iniciado");
		try {
		while(true) {
			
			Socket socket = listener.accept();
				PrintWriter out = new PrintWriter (socket.getOutputStream(), true);
				out.println("Menu Mascotas: 1. Ver tlf | 2. Ver direccion | 3. Lista Perros | 4. Lista gatos | 5. Lista comida");
				
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				
				int menu = 0;
				
				String inputString = input.readLine();
				
				if (isNumeric(inputString)) {
					menu = Integer.parseInt(inputString);
				}
				
				
				switch (menu) {
					case 1:
						out.println("Nuestro numero de telefono es 78892776");
						break;
					case 2:
						out.println("Nuestra direccion es calle Ave del Paraiso 29 nº 57");
						break;
					case 3:
						out.println("1. Jack(Border Collie)2. Turron(Podenco) 3. Kifi(Jack Rusell)");
						break;
					case 4:
						out.println("1. Bola de nieve(Persa) 2. Anakin(Siames) 3. Hercules(Turco)");
						break;
					case 5:
						out.println("1. Royal Canin 2. Purina 3. Whyskas");
						break;
					default:
						out.println("La opcion proporcionada no es valida");
						break;
					
				}
				socket.close();
				
			}
			
			
			
			
		// TODO Auto-generated method stub

	
	} finally {
		listener.close();
	}
}

	public static boolean isNumeric(String str) {
		try {
		Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

}
