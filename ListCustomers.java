import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ListCustomers {
    private static String everyRow;

    static void listCustomers(){
        everyRow = "";

        try {
            String sql = "SELECT * FROM customer";
            Statement statement = Connect.connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            while(res.next()){
                long id = res.getLong("id");
                String name = res.getString("name");
                String address = res.getString("address");
                long phone = res.getLong("phone");
                String email = res.getString("email");

                String row = "Id: %d - Name: %s - Address: %s - Phone: %d - E-mail: %s \n";
                everyRow += String.format(row, id, name, address, phone, email);
            }

            JOptionPane.showMessageDialog(null, everyRow);
        } catch (SQLException e){
            e.printStackTrace();
        }

        Main.customerMenu();
    }
}