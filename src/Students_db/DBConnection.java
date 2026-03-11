package Students_db;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    static final String url = "jdbc:mysql://localhost:3306/students_db";
    static final String username = "root";
    static final String password = "NITish@12345";
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url, username, password);
    }
}
