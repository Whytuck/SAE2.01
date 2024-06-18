package Lot7;

import java.time.LocalDate;
import java.util.Random;

public class Statistiques {

	private Spectacle spectacle;
	private int annee;
	private String nomSpectacle;
	private int nbRepres;
	private int nbBillet;
	
	public Statistiques(Spectacle s) {
		spectacle = s;
        LocalDate maintenant = LocalDate.now();
        Random random = new Random();

        
        this.annee = maintenant.getYear();
        this.nomSpectacle = s.getNom();
        this.nbRepres = Donnees.getNBrepres(spectacle);
        this.nbBillet = random.nextInt(99) + 1;

	}
	
	public int getAnnee() {	
		return this.annee;
	}
	
	public void setAnnee(int ann) {
        this.annee = ann;
    }
	
	public String getNomSpectacle() {
		
		return this.nomSpectacle;
	}
	
	public int getNbrep() {
		
		return this.nbRepres;
	}
	
	public int getBillet() {
		
		return this.nbBillet;
	}
	
	public String getSpectacle() {
        return spectacle.getNom();
    }
	
	
	
}