package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Oracle {

    private static Connection connection;

    private Oracle() {
        try {
            initConnexion();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initConnexion() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fil.univ-lille1.fr:1521:filora", "SAUVALLE", "CooProject");
        connection.setAutoCommit(false);
    }

    public static Connection getInstance() {
        if (connection == null) {
            new Oracle();
        }
        return connection;
    }

}
