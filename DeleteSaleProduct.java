import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteSaleProduct {
    static void deleteSaleProduct(){
        String productIdString = JOptionPane.showInputDialog(null, "Type the product's id");
            long productId = Long.parseLong(productIdString);
        String saleIdString = JOptionPane.showInputDialog(null, "Type the sale's id");
            long saleId = Long.parseLong(saleIdString);

        try {
            String sql = "DELETE FROM sale_product WHERE productid_FK = ? AND saleid_FK = ?";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);

            stt.setLong(1, productId);
            stt.setLong(2, saleId);
            int res = stt.executeUpdate();

            if(res > 0){
                JOptionPane.showMessageDialog(null, "Sale product successfully deleted!");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        Main.saleProductMenu();
    }
}