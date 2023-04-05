package projectPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Main {

    static final String dataBaseUrl ="jdbc:mysql://localhost:3306/storedb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "1234";
    private static Connection conn;
    
    public static void connect() {
		try {
			conn = DriverManager.getConnection(dataBaseUrl, user, password);
			
			if(conn != null) {
				JOptionPane.showMessageDialog(null, "Database connection stablished!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void createProduct() {
    	String name = JOptionPane.showInputDialog("Type the product's name");
    	String priceStr = JOptionPane.showInputDialog("Type the product's price per unit");
    	double price = Double.parseDouble(priceStr);
    	
    	String sql = "INSERT INTO product (name, unit_price) VALUES (?, ?)";
    	PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
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
		
		menu();
    }
    
    static String everyRow;
    public static void readProducts() {
    	everyRow = "";
    	
    	try {
        	String sql = "SELECT * FROM product";
        	Statement statement = conn.createStatement();
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
    	
    	menu();
    }
    
    public static void updateProduct() {
    	String idStr = JOptionPane.showInputDialog("Type the product's Id to be updated");
    	int id = Integer.parseInt(idStr);
    	
    	String toChangeStr = JOptionPane.showInputDialog("What to do you want to update?\n 1) Product name\n 2) Product unit price");
    	int change = Integer.parseInt(toChangeStr);
    	
    	String newValue = JOptionPane.showInputDialog("Type the new value");

    	try {
	    	switch(change) {
	    		case 1:
	    			String sqlName = "UPDATE product SET name = ? WHERE id = ?";
	    			PreparedStatement statementName = conn.prepareStatement(sqlName);
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
	    			
	    			PreparedStatement statementPrice = conn.prepareStatement(sqlPrice);
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
    	
    	menu();
    }
    
    public static void deleteProduct() {
    	String idStr = JOptionPane.showInputDialog("Type the product's id to delete it");
    	int id = Integer.parseInt(idStr);
    	
    	try {
    		String sql = "DELETE FROM product WHERE id = ?";
    		PreparedStatement statement = conn.prepareStatement(sql);
    		statement.setInt(1, id);
    		int rowsManipulated = statement.executeUpdate();
    		
    		if(rowsManipulated > 0) {
    			JOptionPane.showMessageDialog(null, "Product Successfully deleted!");
    		}
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	menu();
    }
    
    public static void menu() {
    	try {
			String options = "\n 0- Exit\n 1- Create Product\n 2- List Products\n 3- Update Product\n 4- Delete Product";
			
			String opStr = JOptionPane.showInputDialog(options);
			int op = Integer.parseInt(opStr);
			
			switch(op) {
				case 0:
					System.exit(0);
					break;
				case 1:
					createProduct();
						break;
				case 2:
					readProducts();
						break;
				case 3:
					updateProduct();
						break;
				case 4:
					deleteProduct();
						break;
				default:
					JOptionPane.showMessageDialog(null, "Type a valid option...");
					menu();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You probably typed a letter where a number is expected...");
			menu();
		}
    }
	

    
	public static void main(String[] args) {
		connect();
		menu();
	}
}