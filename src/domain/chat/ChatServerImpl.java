package domain.chat;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatServerImpl implements ChatServer {
    
    public ChatServerImpl(int localPort, String publicationName) {
        try {
            ChatServer chatServer = (ChatServer) UnicastRemoteObject.exportObject(this, 0);            
            Registry registry = LocateRegistry.createRegistry(localPort);
            registry.rebind(publicationName, chatServer);
            
            System.out.println("Servidor listo en el puertoooo " + localPort);
        } catch (Exception e) {
            System.err.println("Error al iniciar el servidor l");
            e.printStackTrace();
        }
    }

    @Override
    public void receiveMessage(String message) throws RemoteException {
        System.out.println("\n[Usuario]: " + message);
        System.out.print("Tú: "); 
    }
}