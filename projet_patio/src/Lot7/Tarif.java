package Lot7;

public class Tarif {
    private double pleinTarif;
    private double tarifReduit;
    private double tarifEnfant;

    public Tarif(double pleinTarif, double tarifReduit, double tarifEnfant) {
        this.pleinTarif = pleinTarif;
        this.tarifReduit = tarifReduit;
        this.tarifEnfant = tarifEnfant;
    }

    public double getPleinTarif() {
        return pleinTarif;
    }

    public void setPleinTarif(double pleinTarif) {
        this.pleinTarif = pleinTarif;
    }

    public double getTarifReduit() {
        return tarifReduit;
    }

    public void setTarifReduit(double tarifReduit) {
        this.tarifReduit = tarifReduit;
    }

    public double getTarifEnfant() {
        return tarifEnfant;
    }

    public void setTarifEnfant(double tarifEnfant) {
        this.tarifEnfant = tarifEnfant;
    }
}

