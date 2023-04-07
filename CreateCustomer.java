import javax.swing.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class CreateCustomer {
    static void createCustomer(){
        String name = JOptionPane.showInputDialog(null, "Type the new customer's name");
        String address = JOptionPane.showInputDialog(null, "Type the new customer's address");
        String phoneString = JOptionPane.showInputDialog(null, "Type the new customer's phone");
            long phone = Long.parseLong(phoneString);
        String email = JOptionPane.showInputDialog(null, "Type the new customer's email");

        try {
            String sql = "INSERT INTO customer (name, address, phone, email) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = Connect.connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, address);
            statement.setLong(3, phone);
            statement.setString(4, email);

            int response = statement.executeUpdate();
            if(response > 0){
                String dialog = "Customer %s successfully created!";
                JOptionPane.showMessageDialog(null, String.format(dialog, name));
            }
    
        } catch (SQLException e){
            e.printStackTrace();
        }

        Main.customerMenu();
    }
}