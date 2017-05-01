import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankServer {
	public static void startServer() {
		try {
			Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("PinValidation", new ValidatePin());
			System.out.println("Bank Server online ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		startServer();
	}
}
