package Persistance.UOW;

import Entity.Personne;
import Persistance.Mapper.PersonneMapper;
import Utils.Visitor;

public class Committer extends Visitor {
    public void visiter(Personne p) {
        PersonneMapper.getInstance().update(p);
    }
}
