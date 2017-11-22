package Utils;

import java.sql.SQLException;

public interface Visitable {
    void accepter(Visitor v) throws SQLException;
}
