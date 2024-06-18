package Lot7;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
    static private FenCrSpectacle fSpectacle;
    static private FenCrRepresentation fRepresentation;
    static private FenAfficherStat fStat;
    static private FenAccueil faccueil;
    

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	Donnees.chargementDonnees();
    	
		fSpectacle = new FenCrSpectacle();
		fSpectacle.initModality(Modality.NONE);
		fRepresentation = new FenCrRepresentation();
		fRepresentation.initModality(Modality.NONE);
		fStat = new FenAfficherStat();
		fStat.initModality(Modality.NONE);
		faccueil = new FenAccueil();
		faccueil.initModality(Modality.NONE);


		faccueil.show();

    }
    
    
    public static void showAccueil() {
    	faccueil.show();
    }

    public static void closeAccueil() {
    	faccueil.close();
    }
    
    public static void showSpectacleCreation() {
    	fSpectacle.show();
    }

    public static void fermerSpectacleCreation(){
    	fSpectacle.close();
    	faccueil.show();
    }
    
    public static void showRepresentationCreation(Spectacle spec) throws Exception {
    	fRepresentation.show();
    	fRepresentation.afficherRepresentation(spec);
    }
    
    public static void fermerRepresentationCreation() {
    	fRepresentation.close();
    	faccueil.show();
    }

    public static void showStatistiques(){
        fStat.show();
    }
    
    public static void fermerStatistiques() {
    	fStat.close();
    	faccueil.show();
    }

    
    public static void validerSpectacle(String nom, String description, int duree,String genre, Tarif tarif) {
    	
    	Spectacle s = new Spectacle(nom, description, duree, genre, tarif);
    	
    	Donnees.ajouterSpectacle(s);
    	fermerSpectacleCreation();
    	
    	
    }
    
    public static void validerRepresentation(String date, String heure, Spectacle spectacle) {
    	
    	Representation r = new Representation(date, heure, spectacle);
    	
    	Donnees.ajouterRepresentation(r);
    	fermerRepresentationCreation();
    	
    	
    }

    public static void main(String[] args) {
        launch(args);
    }
}
