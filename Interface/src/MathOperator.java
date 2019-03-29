import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathOperator extends Remote  {
    double executeOperation(double a, double b, char operation) throws RemoteException;
}
