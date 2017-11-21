package Entity;

import Utils.IDomainObject;
import Utils.Visitor;
import Utils.Observeur;


import java.util.ArrayList;
import java.util.List;


public class Personne implements IDomainObject {

    private Integer id;
    private String nom;
    private String prenom;
    private String evaluation;
    private Personne pere;
    private List<Observeur> obs;

    public Personne() {
        obs = new ArrayList<Observeur>();
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

    public Personne getPere() { return pere; }

    public void setPere(Personne pere) { this.pere = pere;
        notifier();
    }

    public void add(Observeur o) {
        obs.add(o);
    }


    public void notifier() {
        for (Observeur o : obs)
            o.action(this);
    }

    public void accepter(Visitor v) {
        v.visiter(this);
    }
}
