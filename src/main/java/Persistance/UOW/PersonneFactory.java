package Persistance.UOW;

import Entity.IPersonne;
import Persistance.Mapper.PersonneMapper;

public class PersonneFactory implements Factory<IPersonne> {

    private Integer id;

    public PersonneFactory(Integer id) {
        this.id = id;
    }

    public IPersonne create() {
        IPersonne a = PersonneMapper.getInstance().find(this.id);
        return a;
    }
}
