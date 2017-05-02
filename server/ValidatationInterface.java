import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ValidatationInterface extends Remote {
String validate(String pin) throws RemoteException;
}