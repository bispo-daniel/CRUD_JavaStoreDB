import javax.swing.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class CreateSale {
    static void createSale(){
        String dateString = JOptionPane.showInputDialog(null, "Type the sale's date (YYYY-MM-DD)");
        String customerIdString = JOptionPane.showInputDialog(null, "Type the customer's id");
        int customerId = Integer.parseInt(customerIdString);

        try {
            String sql = "INSERT INTO sale (sale_date, customerid_FK) values (?, ?)";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);

            stt.setString(1, dateString);
            stt.setLong(2, customerId);
            int effect = stt.executeUpdate();

            if(effect > 0){
                JOptionPane.showMessageDialog(null, "Sale successfully created!");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        Main.saleMenu();
    }
}