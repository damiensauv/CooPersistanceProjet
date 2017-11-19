package Persistance.Mapper;

import Entity.Personne;
import Oracle.Oracle;
import Utils.IdentityMap;

import java.sql.Connection;

public class PersonneMapper extends DataMapper<Personne> {

    private static PersonneMapper instance = null;
    private Connection connection;

    private IdentityMap<Personne> idmap;

    private PersonneMapper() {
        // try catch
        connection = Oracle.getInstance();
        idmap = new IdentityMap<Personne>();
    }

    public static PersonneMapper getInstance() {
        if (instance == null) {
            instance = new PersonneMapper();
        }
        return instance;
    }

    Personne find(Integer id)
    {
        Personne p = idmap.get(id);

        return null;
    }

    void insert(Personne o) {

    }

    void delete(Personne o) {

    }

    void update(Personne o) {

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
