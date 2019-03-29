import javax.swing.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        boolean isContinue = true;

        String clientMessage;

        Registry registry = LocateRegistry.getRegistry(1089);

        MathOperator mathOperator = (MathOperator) registry.lookup(MathOperator.class.getName());

        System.out.println("Object imported. Details: " + mathOperator);

        while (isContinue) {

            clientMessage = JOptionPane.showInputDialog("Enter operation (example 2 + 2)");
            try {
                String [] strings = clientMessage.split(" ");
                if (strings.length == 3) {
                    double a = Double.parseDouble(strings[0]);
                    double b = Double.parseDouble(strings[2]);
                    char operation = strings[1].charAt(0);
                    double responseMessage = mathOperator.executeOperation(a, b, operation);
                    isContinue = JOptionPane.showConfirmDialog(null, "Answer is "
                            + responseMessage + "\nDo you want to continue?") == 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
