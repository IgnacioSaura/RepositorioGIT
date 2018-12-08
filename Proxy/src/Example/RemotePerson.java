package Example;
import java.io.*;
import java.net.*;

public class RemotePerson implements Runnable{
	private Thread thread;
	ServerSocket socket;
	PrintWriter salida;
	Socket communicationSocket;

	
		
	
public RemotePerson() {
	try {
		socket = new ServerSocket(45454);
		communicationSocket = socket.accept();
		salida = new PrintWriter(communicationSocket.getOutputStream(), true);
		thread = new Thread(this);
		thread.start();
	}catch (Exception e) {
		System.out.println("Ha ocurrido un error: "+e.getMessage());
	
		
	}
}



@Override
public void run() {
	String textoEntrada;
	try {
		BufferedReader in = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
		while((textoEntrada = in.readLine()) != null) {
			if(textoEntrada.equals("saludar")) {
				saludar();
			} else if(textoEntrada.equals("Decir Estado")) {
				decirEstado();
			} else if(textoEntrada.equals("despedirse")) {
				despedirse();
			}
		}
				
	} catch(Exception e) {
		System.out.println("Error general: "+e.getMessage());
	}
}
	
	public void saludar() {
		salida.println("HOLA");
	}
	
	public void decirEstado() {
		salida.println("Estoy feliz");
	}
	public void despedirse() {
		salida.println("Chau");
		
	}
	}
	
