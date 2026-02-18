package domain.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServer extends Remote {
    public void receiveMessage(String message) throws RemoteException;
}