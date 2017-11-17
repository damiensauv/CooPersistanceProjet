package Oracle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Oracle {
    private static Connection connection;

    public static Connection getConnection(String username, String password) throws SQLException {
        if (connection == null) {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fil.univ-lille1.fr:1521:filora", username, password);
            connection.setAutoCommit(false);
            return connection;
        } else {
            return connection;
        }
    }

}
