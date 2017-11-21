package Persistance.Mapper;

import Entity.Personne;
import Oracle.Oracle;
import Utils.IdMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneMapper extends DataMapper<Personne> {

    private static PersonneMapper instance = null;
    private Connection connection;
    private IdMap<Personne> idMap;

    private PersonneMapper() {
        // try catch
        connection = Oracle.getInstance();
        idMap = new IdMap<Personne>();
    }

    public static PersonneMapper getInstance() {
        if (instance == null) {
            instance = new PersonneMapper();
        }
        return instance;
    }

    public Personne find(Integer id) {
        Personne p = idMap.get(id);
        if (p != null)
            return p;

        String req = "SELECT id, nom, prenom, eval, id_pere FROM coo_tp_personne WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            p = new Personne();
            p.setId(Integer.getInteger(rs.getString(1)));
            p.setNom(rs.getString(2));
            p.setPrenom(rs.getString(3));
            p.setEvaluation(rs.getString(4));

                // add on idMAp, Uow

            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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
