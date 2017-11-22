package Persistance.UOW;

import Entity.IPersonne;
import Entity.Personne;
import Persistance.Mapper.PersonneMapper;

public class PersonneFactory implements Factory<IPersonne> {

    private Integer id;

    public PersonneFactory(Integer id) {
        this.id = id;
    }

    public Personne create() {
        return PersonneMapper.getInstance().find(id);
    }
}
