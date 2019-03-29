import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException {
        System.out.println("Server started..");

        MathOperator instance = new MathOperatorImpl();

        MathOperator stub = (MathOperator) UnicastRemoteObject.exportObject(instance, 0);
        System.out.println("Exporting object. Details: " + stub);

        Registry registry = LocateRegistry.createRegistry(1089);

        System.out.println("Registry created. Details: " + registry);
        registry.rebind(MathOperator.class.getName(), stub);
    }
}
