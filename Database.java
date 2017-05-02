import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database{
    private final String connStr = "jdbc:mysql://localhost/atmbank";
    private final String username ="root";
    private final String password = "";
    private Connection con;
    private static Database _database = null;

    private Database(){        
        this.con = this.connect();
    }

    private Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(connStr,this.username,this.password);            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return this.con;
    }

    public static Database getInstace(){
        if(_database == null){
            _database = new Database();            
        }
        return _database;
    }

    public String finduser(String pin){
        try{
            String query = "SELECT username from users where pin = "+pin;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString(1);
            }else{
                return "-2";
            }
        }catch(Exception ex){
            return "-1";
        }                
    }

    /* to test the database class itself*/
    public static void main(String[] args){
        Database _database = Database.getInstace();
        System.out.println(_database.finduser("fadfadf"));
        System.out.println(_database.finduser("1234"));
    }
}