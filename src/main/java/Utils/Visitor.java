package Utils;

import Entity.Personne;

public abstract class Visitor<T> {
    public void visiter(IDomainObject o) {
        o.accepter(this);
    }

    abstract public void visiter(Personne p);
}
