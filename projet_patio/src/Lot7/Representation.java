package Lot7;


public class Representation {
    private String date;
    private String heure;
    private boolean annulee;
    private Spectacle spectacle;

    public Representation(String date, String heure, Spectacle spectacle) {
        this.date = date;
        this.heure = heure;
        this.annulee = false;
        this.spectacle = spectacle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public String getSpectacle() {
        return spectacle.getNom();
    }
    
    public Spectacle getSpec() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }
    
    public Boolean getAnnulee() {
        return annulee;
    }
    
}
