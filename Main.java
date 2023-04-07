import javax.swing.*;

public class Main {
    static Connect myConnection = new Connect();

	static void productMenu(){
		String options = "Product menu:\n\n 0- Return\n 1- Create product\n 2- List products\n 3- Update product\n 4- Delete product";
		String opStr = JOptionPane.showInputDialog(options);
		int op = Integer.parseInt(opStr);

		switch(op) {
			case 0:
				menu();
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
	}

	static void customerMenu(){
		String options = "Customer Menu:\n\n 0- Return\n 1- Create customer\n 2- List customers\n 3- Update customer\n 4- Delete customer";
		String opStr = JOptionPane.showInputDialog(options);
		int op = Integer.parseInt(opStr);

		switch(op) {
			case 0:
				menu();
					break;
			case 1:
				CreateCustomer.createCustomer();
					break;
			case 2:
				ListCustomers.listCustomers();
					break;
			case 3:
				UpdateCustomer.updateCustomer();
					break;
			case 4:
				DeleteCustomer.deleteCustomer();
					break;
			default:
				JOptionPane.showMessageDialog(null, "Type a valid option...");
				menu();
		}
	}

static void saleMenu(){
		String options = "Sale menu:\n\n 0- Return\n 1- Create sale\n 2- List sales\n 3- Update sale\n 4- Delete sale";
		String opStr = JOptionPane.showInputDialog(options);
		int op = Integer.parseInt(opStr);

		switch(op) {
			case 0:
				menu();
					break;
			case 1:
				CreateSale.createSale();
					break;
			case 2:
				ListSales.listSales();
					break;
			case 3:
				UpdateSale.updateSale();
					break;
			case 4:
				DeleteSale.deleteSale();
					break;
			default:
				JOptionPane.showMessageDialog(null, "Type a valid option...");
				menu();
		}
	}

	static void saleProductMenu(){
		String options = "Sale menu:\n\n 0- Return\n 1- Create sale product\n 2- List sales products\n 3- Update sale product\n 4- Delete sale product";
		String opStr = JOptionPane.showInputDialog(options);
		int op = Integer.parseInt(opStr);

		switch(op) {
			case 0:
				menu();
					break;
			case 1:
				CreateSaleProduct.createSaleProduct();
					break;
			case 2:
				ListSalesProducts.listSalesProducts();
					break;
			case 3:
				UpdateSaleProduct.updateSaleProduct();
					break;
			case 4:
				DeleteSaleProduct.deleteSaleProduct();
					break;
			default:
				JOptionPane.showMessageDialog(null, "Type a valid option...");
				menu();
		}
	}

    static void menu() {
    	try {
			String options = "Welcome!\n\n 0- Exit\n 1- Manipulate products\n 2- Manipulate customers\n 3- Manipulate sales\n 4- Manipulate sale product";			
			String opStr = JOptionPane.showInputDialog(options);
			int op = Integer.parseInt(opStr);
			
			switch(op) {
				case 0:
					System.exit(0);
					break;
				case 1:
					productMenu();
						break;
				case 2:
					customerMenu();
						break;
				case 3:
					saleMenu();
						break;
				case 4:
					saleProductMenu();
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