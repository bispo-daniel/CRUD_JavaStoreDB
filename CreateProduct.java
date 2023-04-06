import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateProduct {
    static void createProduct() {
    	String name = JOptionPane.showInputDialog("Type the product's name");
    	String priceStr = JOptionPane.showInputDialog("Type the product's price per unit");
    	double price = Double.parseDouble(priceStr);
    	
    	String sql = "INSERT INTO product (name, unit_price) VALUES (?, ?)";
    	PreparedStatement statement;
		try {
			statement = Connect.connection.prepareStatement(sql);
	    	statement.setString(1, name);
	    	statement.setDouble(2, price);
	    	
    		int rowsManipulated = statement.executeUpdate();
    		
    		if(rowsManipulated > 0) {
    			JOptionPane.showMessageDialog(null, "Product Successfully created!");
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Main.menu();
    }
}