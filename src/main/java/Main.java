import Oracle.Oracle;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("Oracle.Oracle");
        Connection c = Oracle.getConnection("SAUVALLE", "CooProject");
        c.setAutoCommit(false);



    }

}