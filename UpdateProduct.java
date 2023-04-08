import javax.swing.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UpdateProduct {
	static void updateProductFunction(long id, String columnName, String newValue){
    	try {
			String sql = "UPDATE product SET %s = ? WHERE id = %d";
			String formatedString = String.format(sql, columnName, id);

			PreparedStatement stt = Connect.connection.prepareStatement(formatedString);

			if(columnName == "name"){
				stt.setString(1, newValue);
			} else {
				double newPrice = Double.parseDouble(newValue);
				stt.setDouble(1, newPrice);
			}
			
			int response = stt.executeUpdate();
			if(response > 0) {
				String txt = "Product %s successfully updated!";
				JOptionPane.showMessageDialog(null, String.format(txt, columnName));
			}

		}catch (SQLException e) {
			e.printStackTrace();
    	}
	}

    static void updateProduct() {
    	String idStr = JOptionPane.showInputDialog("Type the product's Id to be updated");
    	long id = Long.parseLong(idStr);

    	String toChangeStr = JOptionPane.showInputDialog("What to do you want to update?\n 1) Product name\n 2) Product unit price");
    	int change = Integer.parseInt(toChangeStr);

    	String newValue = JOptionPane.showInputDialog("Type the new value");

		switch(change) {
			case 1:
				updateProductFunction(id, "name", newValue);
				break;
			case 2:
				updateProductFunction(id, "unit_price", newValue);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Type a valid option...");
		}

    	Main.productMenu();
    }
}