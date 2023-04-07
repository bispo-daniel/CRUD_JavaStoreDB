import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateProduct {
    static void createProduct() {
    	String name = JOptionPane.showInputDialog("Type the product's name");
    	String priceStr = JOptionPane.showInputDialog("Type the product's price per unit");
    		double price = Double.parseDouble(priceStr);
    	
		try {
			String sql = "INSERT INTO product (name, unit_price) VALUES (?, ?)";
			PreparedStatement statement;

			statement = Connect.connection.prepareStatement(sql);
	    	statement.setString(1, name);
	    	statement.setDouble(2, price);
	    	
    		int response = statement.executeUpdate();
    		
    		if(response > 0) {
				String dialog = "Product %s Successfully created!";
    			JOptionPane.showMessageDialog(null, String.format(dialog, name));
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Main.productMenu();
    }
}