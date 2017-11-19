package Entity;

public class Personne {

    private Integer id;
    private String nom;
    private String prenom;
    private String evaluation;
    private Personne pere;

    public Personne() {
    }

    public Integer getI() {
        return id;
    }

    public void setI(Integer i) {
        this.id = i;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Personne getPere() { return pere; }

    public void setPere(Personne pere) { this.pere = pere; }
}
