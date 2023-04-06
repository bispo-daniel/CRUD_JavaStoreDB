import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.*;

public class Connect {
    private String dbUrl = "jdbc:mysql://localhost:3306/storedb";
    private String user = "root";
    private String pass = "1234";

    static Connection connection;
    
    public void connect(){
        try {
            connection = DriverManager.getConnection(dbUrl, user, pass);

            if (connection != null){
                JOptionPane.showMessageDialog(null, "Database connected!");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
