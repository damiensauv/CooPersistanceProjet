package Entity;

import Utils.IDomainObject;
import Utils.Observeur;
import Utils.Visitor;

import java.sql.SQLException;
import java.util.List;

public interface IPersonne extends IDomainObject {

    public IPersonne getPere();

    public void setPere(IPersonne pere);

    public Integer getId();

    public void setId(Integer i);

    public String getNom();

    public void setNom(String nom);

    public String getPrenom();

    public void setPrenom(String prenom);

    public String getEvaluation();

    public void setEvaluation(String evaluation);

    public void add(Observeur o);

    public void notifier();

    public void accepter(Visitor v) throws SQLException;

    public List<IPersonne> getFils();

    public void setFils(List<IPersonne> fils);

}
