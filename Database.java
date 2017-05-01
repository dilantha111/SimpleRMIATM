import java.sql.Connection;

public class Database{
    private Connection con;

    public Database(){
        con = null;
    }

    private Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
}