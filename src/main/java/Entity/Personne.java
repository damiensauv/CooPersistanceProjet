package Entity;

import Utils.Observeur;
import Utils.Visitor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Personne implements IPersonne {

    private Integer id;
    private String nom;
    private String prenom;
    private String evaluation;
    private IPersonne pere;
    private List<IPersonne> fils;
    private List<Observeur> obs;

    public Personne() {
        obs = new ArrayList<Observeur>();
        fils = new ArrayList<IPersonne>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer i) {
        this.id = i;
        notifier();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
        notifier();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
        notifier();
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
        notifier();
    }

    public IPersonne getPere() {
        return pere;
    }

    public void setPere(IPersonne pere) {
        this.pere = pere;
        notifier();
    }

    public void add(Observeur o) {
        obs.add(o);
    }


    public void notifier() {
        for (Observeur o : obs)
            o.action(this);
    }

    public void accepter(Visitor v) throws SQLException {
        v.visiter(this);
    }

    public List<IPersonne> getFils() {
        return fils;
    }

    public void setFils(List<IPersonne> fils) {
        this.fils = fils;
    }
}
