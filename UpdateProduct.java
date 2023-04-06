import javax.swing.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UpdateProduct {
    static void updateProduct() {
    	String idStr = JOptionPane.showInputDialog("Type the product's Id to be updated");
    	int id = Integer.parseInt(idStr);
    	
    	String toChangeStr = JOptionPane.showInputDialog("What to do you want to update?\n 1) Product name\n 2) Product unit price");
    	int change = Integer.parseInt(toChangeStr);
    	
    	String newValue = JOptionPane.showInputDialog("Type the new value");

    	try {
	    	switch(change) {
	    		case 1:
	    			String sqlName = "UPDATE product SET name = ? WHERE id = ?";
	    			PreparedStatement statementName = Connect.connection.prepareStatement(sqlName);
	    			statementName.setString(1, newValue);
	    			statementName.setInt(2, id);
	        		int rowsManipulated01 = statementName.executeUpdate();
	        		
	        		if(rowsManipulated01 > 0) {
	        			JOptionPane.showMessageDialog(null, "Product Successfully updated!");
	        		}
	    				break;
	    		case 2:
	    			String sqlPrice = "UPDATE product SET unit_price = ? WHERE id = ?";
	    			double newValueDouble = Double.parseDouble(newValue);
	    			
	    			PreparedStatement statementPrice = Connect.connection.prepareStatement(sqlPrice);
	    			statementPrice.setDouble(1, newValueDouble);
	    			statementPrice.setInt(2, id);
	        		int rowsManipulated02 = statementPrice.executeUpdate();
	        		
	        		if(rowsManipulated02 > 0) {
	        			JOptionPane.showMessageDialog(null, "Product Successfully updated!");
	        		}
	        			break;
	    		default:
	    			JOptionPane.showMessageDialog(null, "Type a valid option...");
	    	}
    	}catch (SQLException e) {
    		// TODO Auto-generated catch block
			e.printStackTrace();
    	}
    	
    	Main.menu();
    }
}
