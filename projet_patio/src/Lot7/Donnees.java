package Lot7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




public class Donnees {
	
	static private ObservableList<Spectacle> 			lesSpectacles = FXCollections.observableArrayList();
	static private ObservableList<Representation> 		lesRepresentations 	= FXCollections.observableArrayList();
	static private ObservableList<Genre> 		lesGenres 	= FXCollections.observableArrayList();
	static private ObservableList<String> 		lesLibelleGenres 	= FXCollections.observableArrayList();
	static private ObservableList<Statistiques> 			lesStats 	= FXCollections.observableArrayList();
	
	static public void chargementDonnees() {
		
		Genre danse = new Genre("Danse");
		Genre opera = new Genre("Opera");
		Genre musique = new Genre("Musique");
		Genre cirque = new Genre("Cirque");
		Genre marionnette = new Genre("Marionnette");
		Genre theatre = new Genre("Theatre");
		
		lesGenres.add(danse);
		lesGenres.add(opera);
		lesGenres.add(musique);
		lesGenres.add(cirque);
		lesGenres.add(marionnette);
		lesGenres.add(theatre);
		
		
		Tarif tar1 = new Tarif(50, 40, 25);
		
		Tarif tar2 = new Tarif(20, 15, 10);
		
		Tarif tar3 = new Tarif(100, 75, 50);

		
		
		Spectacle spec1 = new Spectacle("Les Cheveux","Spectacle de marionnette",60,"Marionnette", tar1);
		lesSpectacles.add(spec1);
		
		Spectacle spec2 = new Spectacle("Circus","Spectacle de cirque",90,"Cirque", tar2);
		lesSpectacles.add(spec2);
		
		Spectacle spec3 = new Spectacle("Les Ténors","Le plus grand Opéra",60,"Opera", tar3);
		lesSpectacles.add(spec3);
		
		
		Representation rep1 = new Representation("12/09/2024","15:00",spec1);
		lesRepresentations.add(rep1);
		
		Representation rep2 = new Representation("12/09/2024","16:15",spec1);
		lesRepresentations.add(rep2);
		
		Representation rep3 = new Representation("12/09/2024","17:30",spec1);
		lesRepresentations.add(rep3);
		
		Representation rep4 = new Representation("13/09/2024","13:15",spec2);
		lesRepresentations.add(rep4);
		
		Representation rep5 = new Representation("13/09/2024","15:00",spec2);
		lesRepresentations.add(rep5);
		
		Representation rep6 = new Representation("14/09/2024","20:00",spec3);
		lesRepresentations.add(rep6);
		
		Representation rep7 = new Representation("14/09/2024","21:15",spec3);
		lesRepresentations.add(rep7);
		
		for (Spectacle s : lesSpectacles) {
		    	lesStats.add(new Statistiques(s));
		    }
	}
	
	static public ObservableList<Spectacle> getLesSpectacles() {
		
		return lesSpectacles;
		
	}
	
	static public void ajouterSpectacle(Spectacle s) {
		lesSpectacles.add(s);
	}
	
	static public ObservableList<Representation> getLesRepres() {
		
		return lesRepresentations;
		
	}
	
	
	static public void ajouterRepresentation(Representation r) {
		lesRepresentations.add(r);
	}
	
	static public void ajouterGenre(Genre g) {
		lesGenres.add(g);
	}

	static public ObservableList<Genre> getLesGenres() {
		
		return lesGenres;
		
	}
	
	public static ObservableList<String> getLibellesDesGenres() {
		
	    for (Genre genre : lesGenres) {
	    	lesLibelleGenres.add(genre.getLibelle());
	    }
	    return lesLibelleGenres;
	}
	
	public static ObservableList<Statistiques> getLesStats() {
		
		return lesStats;
		
	}
	
	public static int getNBrepres(Spectacle spectacle) {
		
		int nbRepres = 0;
		
		for (Representation repres: lesRepresentations) {
			
			if (repres.getSpec().equals(spectacle)) {
				
				nbRepres = nbRepres + 1;
				
			}
		}
		
		return nbRepres;
	}

	
}
