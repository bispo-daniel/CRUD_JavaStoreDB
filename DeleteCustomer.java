import javax.swing.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DeleteCustomer {
    static void deleteCustomer(){
        String idString = JOptionPane.showInputDialog(null, "Type the customer's id to remove it");
        long id = Long.parseLong(idString);
        
        try {
            String sql = "DELETE FROM customer WHERE id = ?";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);
    
            stt.setLong(1, id);
            int response = stt.executeUpdate();
            if(response > 0){
                String dialog = "Customer %d successfully removed!";
                JOptionPane.showMessageDialog(null, String.format(dialog, id));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }   
    
        Main.customerMenu();
    }
}