import javax.swing.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProduct {
    public static void deleteProduct() {
    	String idStr = JOptionPane.showInputDialog("Type the product's id to delete it");
    	int id = Integer.parseInt(idStr);
    	
    	try {
    		String sql = "DELETE FROM product WHERE id = ?";
    		PreparedStatement statement = Connect.connection.prepareStatement(sql);
    		statement.setInt(1, id);
    		int rowsManipulated = statement.executeUpdate();
    		
    		if(rowsManipulated > 0) {
    			JOptionPane.showMessageDialog(null, "Product Successfully deleted!");
    		}
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	Main.menu();
    }
}