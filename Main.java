import javax.swing.*;

public class Main {
    static Connect myConnection = new Connect();

    static void menu() {
    	try {
			String options = "\n 0- Exit\n 1- Create Product\n 2- List Products\n 3- Update Product\n 4- Delete Product";
			
			String opStr = JOptionPane.showInputDialog(options);
			int op = Integer.parseInt(opStr);
			
			switch(op) {
				case 0:
					System.exit(0);
					break;
				case 1:
					CreateProduct.createProduct();
						break;
				case 2:
					ListProducts.listProducts();
						break;
				case 3:
					UpdateProduct.updateProduct();
						break;
				case 4:
					DeleteProduct.deleteProduct();
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
        myConnection.connect();
        menu();
    }
}