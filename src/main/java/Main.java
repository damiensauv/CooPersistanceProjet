import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Personne;
import Oracle.Oracle;
import Persistance.Mapper.PersonneMapper;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Personne p;
        PersonneMapper pm = PersonneMapper.getInstance();

        p = pm.find(1);

        System.out.println(p.getPrenom());

    }

}