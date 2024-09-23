import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    Connection co;

    Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_page?useSSL=false", "root", "admin");
            System.out.println("Success");
        } catch (Exception e) {
            e.printStackTrace(); // Prints detailed stack trace for easier debugging
        }
    }

    public void closeConnection() {
        try {
            if (co != null && !co.isClosed()) {
                co.close();
                System.out.println("Connection closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
