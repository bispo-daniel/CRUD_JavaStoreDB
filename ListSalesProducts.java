import javax.swing.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListSalesProducts {
    static String allRows;
    static void listSalesProducts(){
        allRows = "";

        try {
            //SQL TO BE UPDATED TO A BETTER VERSION
            String sql = "SELECT * FROM sale_product";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(sql);

            while(res.next()){
                long productId = res.getLong(1);
                long saleId = res.getLong(2);

                String row = "%d - %d \n";
                allRows += String.format(row, productId, saleId);
            }

            JOptionPane.showMessageDialog(null, allRows);
        } catch (SQLException e){
            e.printStackTrace();
        }

        Main.saleProductMenu();
    }
}