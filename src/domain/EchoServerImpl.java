package domain;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class EchoServerImpl implements EchoServer {
    public EchoServerImpl(String ipRMIregistry,
                        int portRMIregistry, String publicationName){
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try{
            EchoServer echoServer = (EchoServer) UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry(ipRMIregistry,portRMIregistry);
            registry.rebind(publicationName,echoServer);
            System.out.println("Echo Server Ready");
        }catch(Exception e){
            System.out.println("Echo Server Exception");
            e.printStackTrace();
        }


    }

    public String echo(String word) throws RemoteException{
        return "From the server" + word;
    }
    
}
