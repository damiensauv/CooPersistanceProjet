package Persistance.Mapper;

import Entity.IPersonne;
import Entity.Personne;
import Oracle.Oracle;
import Persistance.UOW.PersonneFactory;
import Persistance.UOW.UnitOfWork;
import Persistance.UOW.VirtualProxyGenerique.VirtualProxyBuilder;
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

    private Personne createPersonne(ResultSet rs) throws SQLException {

        Personne p = new Personne();
        p.setId(Integer.getInteger(rs.getString(1)));
        p.setNom(rs.getString(2));
        p.setPrenom(rs.getString(3));
        p.setEvaluation(rs.getString(4));

        PersonneFactory fp = new PersonneFactory(5);
        p.setPere(new VirtualProxyBuilder<IPersonne>(IPersonne.class, fp).getProxy());

        return p;
    }

    public Personne find(Integer id) {
        // check if personne already exist
        Personne p = idMap.get(id);
        if (p != null){
            System.out.println("Get from IdMap");
            return p;
        }


        String req = "SELECT id, nom, prenom, eval, id_pere FROM coo_tp_personne WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("not in bd " + id);
                return null;
            }

            p = this.createPersonne(rs);
            // get all childs
            PreparedStatement ps2= connection.prepareStatement("select id, nom, prenom, eval, id_pere from coo_tp_personne where id_pere = ?");
            ps2.setInt(1, id);
            rs = ps2.executeQuery();

            while(rs.next()) {
                p.getFils().add(new VirtualProxyBuilder<IPersonne>(IPersonne.class, new PersonneFactory(rs.getInt("id"))).getProxy());
            }
            idMap.put(id,p);
            p.add(UnitOfWork.getInstance());

            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insert(Personne o) {

    }

    public void delete(Personne o) {

    }

    public void update(Personne o) {

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
