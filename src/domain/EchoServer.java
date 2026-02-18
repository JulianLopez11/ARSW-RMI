package domain;

import java.rmi.Remote;
import java.rmi.RemoteException;

//DFefine el contrato de servicios remotos que presta un objeto.
public interface EchoServer extends Remote {
    public String echo(String word) throws RemoteException;
}