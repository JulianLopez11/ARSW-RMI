package domain;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EchoClient{
    public void executeService(String ipRMIregistry, int portRMIregistry, String serviceName){
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try{
            Registry registry = LocateRegistry.getRegistry(ipRMIregistry,portRMIregistry);
            EchoServer echoServer = (EchoServer) registry.lookup(serviceName);
            System.out.println(echoServer.echo("Hello How Are U?"));
        }catch(Exception e){
            System.err.println("There is a problem");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] string){
        EchoClient client = new EchoClient();
        client.executeService("127.0.0.1", 23000, "echoServer");
    }
}