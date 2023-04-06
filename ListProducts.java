import javax.swing.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ListProducts {
    static String everyRow;
    public static void listProducts() {
    	everyRow = "";
    	
    	try {
        	String sql = "SELECT * FROM product";
        	Statement statement = Connect.connection.createStatement();
        	ResultSet res = statement.executeQuery(sql);
        	
        	while(res.next()) {
        		int id = res.getInt(1);
        		String productName = res.getString(2);
        		double price = res.getDouble(3);
        		
        		String data = "Id: %d - Product: %s - Price: %.2f \n";
        		everyRow += String.format(data, id, productName, price);
        	}
        	
        	JOptionPane.showMessageDialog(null, everyRow);
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	Main.menu();
    }
}