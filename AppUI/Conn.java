package AppUI;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {

        try {
 
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultyFeedback", "root", "rohan@SQL");
            s = c.createStatement();
            

        }
        catch(Exception e) {
            System.out.println(e);
        }

    }

}
