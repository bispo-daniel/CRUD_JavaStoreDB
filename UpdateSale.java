import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UpdateSale {
    static void updateSaleFunction(long id, String columnName, String newValue){
        try{
            String sql = "UPDATE sale SET %s = ? WHERE id = %d";
            String formatedString = String.format(sql, columnName, id);

            PreparedStatement stt = Connect.connection.prepareStatement(formatedString);
            
            if(columnName == "sale_date"){
                stt.setString(1, newValue);
            } else {
                long newId = Long.parseLong(newValue);
                stt.setLong(1, newId);
            }

            int response = stt.executeUpdate();

            if(response > 0){
                String txt = "%s successfully updated!";
                JOptionPane.showMessageDialog(null, String.format(txt, columnName));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    static void updateSale(){
        String idString = JOptionPane.showInputDialog(null, "Type the sale's id to update");
        long id = Long.parseLong(idString);

        String optionString = JOptionPane.showInputDialog(null, "What do you to update\n 1) Sale date\n 2) Customer id");
        int option = Integer.parseInt(optionString);

        String newValueString = JOptionPane.showInputDialog(null, "Type the new value");

        switch(option){
            case 1:
                updateSaleFunction(id, "sale_date", newValueString);
                break;
            case 2:
                updateSaleFunction(id, "customerid_FK ", newValueString);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option...");
        }

        Main.saleMenu();
    }
}