import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ValidatePin extends UnicastRemoteObject implements ValidatationInterface {    
	public ValidatePin() throws RemoteException {     
	}	
	
    public String validate(String pin) throws RemoteException{
        int[] pins = {1234,6789,3456,3344};
		String[] usernames = {"Dilantha","Nuwan","Januska","Kamal"};
		int userPin = 0;
		try{
			userPin = Integer.parseInt(pin.trim());
		}catch(Exception ex){
			return "-1";
		}

		for(int i = 0; i < pins.length; i++){
			if(pins[i] == userPin){
				return usernames[i];
			}
		}
		return "-2";
    }
    
}
