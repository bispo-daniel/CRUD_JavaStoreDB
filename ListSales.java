import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ListSales {
    static String allRow;
    static void listSales(){
        allRow = "";

        try {
            String sql = "SELECT s.id, s.sale_date, c.name FROM sale s JOIN customer c ON s.customerid_FK = c.id";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(sql);

            while(res.next()){
                long id = res.getLong(1);
                String date = res.getString(2);
                String clientName = res.getString(3);

                String row = "%d - %s - %s \n";
                allRow += String.format(row, id, date, clientName);
            }

            JOptionPane.showMessageDialog(null, allRow);
        } catch (SQLException e){
            e.printStackTrace();
        }

        Main.saleMenu();
    }
}
