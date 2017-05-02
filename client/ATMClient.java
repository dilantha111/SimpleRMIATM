import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ATMClient {
	final static String host = "localhost";
	public static void startClient(String host){
		try {
			Registry registry = LocateRegistry.getRegistry(host, 5000);
            ValidatationInterface _validatePin = (ValidatationInterface) registry.lookup("PinValidation");
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter pin number");
			String input = scanner.nextLine();   
			String returnedStr = _validatePin.validate(input);    			

			if(returnedStr.equals("-1")){
				System.out.println("Your pin can only included numbers ...");
			}else if(returnedStr.equals("-2")){
				System.out.println("Wrong pin number user is not in the Bank database ...");
			}else{
				System.out.println("User identified. Username : "+returnedStr);
			}

		} catch (Exception e) { 
            System.out.println("error"+e.toString());
        }
	}
	public static void main(String[] args) {
        startClient(host);
	}
}
