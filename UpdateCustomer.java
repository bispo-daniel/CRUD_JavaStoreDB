import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCustomer {
    static void updateCustomerFunction(long customerId, String columnName, String newValue){
        try {
            String sql = "UPDATE customer set %s = ? WHERE id = %d";
            String formatedSQL = String.format(sql, columnName, customerId);

            PreparedStatement stt = Connect.connection.prepareStatement(formatedSQL);

            if(columnName == "phone"){
                long phoneNumber = Long.parseLong(newValue);
                stt.setLong(1, phoneNumber);
            } else {
                stt.setString(1, newValue);
            }

            int res = stt.executeUpdate();
            if(res > 0){
                String msg = "%s successfully updated!";
                JOptionPane.showMessageDialog(null, String.format(msg, columnName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void updateCustomer(){
        String customerIdString  = JOptionPane.showInputDialog(null, "Type the customer's id that you want to update");
        long customerId = Long.parseLong(customerIdString);

        String optionString = JOptionPane.showInputDialog(null, "What do you want to update\n 1) Name\n 2) Address\n 3) Phone\n 4) E-mail");
        int option = Integer.parseInt(optionString);
        
        String newValueString = JOptionPane.showInputDialog(null, "Type the new value");

        switch(option){
            case 1:
                updateCustomerFunction(customerId, "name", newValueString);
                    break;
            case 2:
                updateCustomerFunction(customerId, "address", newValueString);
                    break;
            case 3:
                updateCustomerFunction(customerId, "phone", newValueString);
                    break;
            case 4:
                updateCustomerFunction(customerId, "email", newValueString);
                    break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option...");
        }

        Main.customerMenu();
    }
}