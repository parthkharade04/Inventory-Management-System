package inventory_db1;

import java.sql.*;

public class Conn {
 Connection c;
    Statement s;

    Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///collegemanagementsystem", "root", "Parth4ndk#flamingfisher");
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}    
    

