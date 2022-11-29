import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatBot {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		String ServerAdress = System.console().readLine("Introduce la direccion IP del servidor de de la tienda de mascotas:\n");
		// TODO Auto-generated method stub
while(true) {
			
			Socket socket = new Socket(ServerAdress, 9999);
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String answer = input.readLine();
			
			System.out.println(answer);
			
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			String numero = System.console().readLine("Introduce una opcion:");
			
			out.println(numero);
			
			
			answer=input.readLine();			
			System.out.println(answer);
			
			for(int i=0 ; i<4; i++) {
			System.out.println("-------------------------------------");
			}
			socket.close();
			
		}
	}

}
