import javax.swing.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DeleteSale {
    static void deleteSale(){
        String saleIdString = JOptionPane.showInputDialog(null, "Type the sale's id to delete it");
        long saleId = Long.parseLong(saleIdString);

        try {
            String sql = "DELETE FROM sale WHERE id = ?";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);

            stt.setLong(1, saleId);
            int effect = stt.executeUpdate();

            if(effect > 0){
                JOptionPane.showMessageDialog(null, "Sale successfully deleted!");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        Main.saleMenu();
    }
}
