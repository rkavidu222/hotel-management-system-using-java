package Project;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {

    public static java.sql.Connection c;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Correct driver class
            String url = "jdbc:mysql://localhost:3307/hotel?useSSL=false";
            String un = "root";
            String pw = "root";
            c = DriverManager.getConnection(url, un, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void iud(String q) throws Exception {
        Statement s = c.createStatement();
        s.executeUpdate(q);
    }

    public static ResultSet search(String q) throws Exception {
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(q);
        return rs;
    }
}
