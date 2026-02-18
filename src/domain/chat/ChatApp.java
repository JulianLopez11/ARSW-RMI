package domain.chat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ChatApp {
    
    public void startChat() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el PUERTO para recibir mensajes: ");
            int myPort = Integer.parseInt(sc.nextLine());
            
            new ChatServerImpl(myPort, "chatService");

            System.out.print("\nIngrese la IP del contacto remoto: ");
            String remoteIp = sc.nextLine();
            System.out.print("Ingrese el PUERTO del contacto remoto: ");
            int remotePort = Integer.parseInt(sc.nextLine());

            System.out.println("Conectando...");
            Registry registry = LocateRegistry.getRegistry(remoteIp, remotePort);
            ChatServer remoteContact = (ChatServer) registry.lookup("chatService");

            System.out.println("¡Conexión establecida! (Escribe 'salir' para terminar)");
            while (true) {
                System.out.print("Tú: ");
                String msg = sc.nextLine();
                
                if (msg.equalsIgnoreCase("salir")) break;
                
                remoteContact.receiveMessage(msg);
            }

        } catch (Exception e) {
            System.err.println("Error en la conexión: " + e.getMessage());
        } finally {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ChatApp app = new ChatApp();
        app.startChat();
    }
}