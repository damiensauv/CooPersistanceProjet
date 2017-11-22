package Persistance.UOW;

import Entity.IPersonne;
import Entity.Personne;
import Persistance.Mapper.PersonneMapper;
import Utils.Visitor;

import java.sql.SQLException;

public class Committer extends Visitor {
    public void visiter(IPersonne p) throws SQLException {
        PersonneMapper.getInstance().update(p);
    }
}
