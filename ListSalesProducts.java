import javax.swing.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListSalesProducts {
    static String allRows;
    static void listSalesProducts(){
        allRows = "";

        try {
            String sql = "SELECT s.sale_date, p.name, p.unit_price, c.name FROM sale_product sp JOIN sale s ON sp.saleid_FK = s.id JOIN product p ON sp.productid_FK = p.id JOIN customer c ON s.customerid_FK = c.id ORDER BY s.sale_date desc";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(sql);

            while(res.next()){
                String saleDate = res.getString(1);
                String productName = res.getString(2);
                double productPrice = res.getDouble(3);
                String customerName = res.getString(4);

                String row = "%s - %s - %.2f - %s \n";
                allRows += String.format(row, saleDate, productName, productPrice, customerName);
            }

            JOptionPane.showMessageDialog(null, allRows);
        } catch (SQLException e){
            e.printStackTrace();
        }

        Main.saleProductMenu();
    }
}