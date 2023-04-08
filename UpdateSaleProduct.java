import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSaleProduct {
    static void updateSaleProductFunction(long productid_FK, long saleid_FK, String columnName, long newValue){
        try {
            String sql = "UPDATE sale_product SET %s = ? WHERE productid_FK = %d AND saleid_FK = %d";
            String formatedString = String.format(sql, columnName, productid_FK, saleid_FK);

            PreparedStatement stt = Connect.connection.prepareStatement(formatedString);

            stt.setLong(1, newValue);

            int res = stt.executeUpdate();

            if(res > 0){
                String txt = "Sale product [%s] successfully updated!";
                JOptionPane.showMessageDialog(null, String.format(txt, columnName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void updateSaleProduct(){
        String productid_FKString  = JOptionPane.showInputDialog(null, "Type the productid_FK that you want to update");
        long productid_FK = Long.parseLong(productid_FKString);

        String saleid_FKString  = JOptionPane.showInputDialog(null, "Type the saleid_FK that you want to update");
        long saleid_FK  = Long.parseLong(saleid_FKString);

        String optionString = JOptionPane.showInputDialog(null, "What do you want to update\n 1) Product id\n 2) Sale id");
        int option = Integer.parseInt(optionString);

        String newValueString = JOptionPane.showInputDialog(null, "Type the new value");
        long newValue  = Long.parseLong(newValueString);

        switch(option){
            case 1:
                updateSaleProductFunction(productid_FK, saleid_FK, "productid_FK", newValue);
                    break;
            case 2:
                updateSaleProductFunction(productid_FK, saleid_FK, "saleid_FK", newValue);
                    break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option...");
        }

        Main.saleProductMenu();
    }
}