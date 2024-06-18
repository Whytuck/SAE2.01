package Lot7;


public class Spectacle {
    private String nom;
    private String description;
    private int duree;
    private String genre;
    private Tarif tarif;

    public Spectacle(String nom, String description, int duree, String genre, Tarif tarif) {
        this.nom = nom;
        this.description = description;
        this.duree = duree;
        this.genre = genre;
        this.tarif = tarif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }

    public double getPleinTarif() {
        return tarif.getPleinTarif();
    }

}
