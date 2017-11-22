package Entity;

import Utils.IDomainObject;

public interface IPersonne extends IDomainObject {

    public IPersonne getPere();

    public void setPere(IPersonne pere);

    public String getPrenom();

}
