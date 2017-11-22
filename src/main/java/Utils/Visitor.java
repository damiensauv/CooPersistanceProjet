package Utils;

import Entity.IPersonne;
import Entity.Personne;

import java.sql.SQLException;

public abstract class Visitor<T> {
    public void visiter(IDomainObject o) throws SQLException {
        o.accepter(this);
    }

    abstract public void visiter(IPersonne p) throws SQLException;
}
