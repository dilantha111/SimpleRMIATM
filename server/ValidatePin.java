import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ValidatePin extends UnicastRemoteObject implements ValidatationInterface {    
	public ValidatePin() throws RemoteException {     
	}	
	
    public String validate(String pin) throws RemoteException{
        Database _database = Database.getInstace();
		return _database.finduser(pin);
    }
    
}
