package Lot7;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;


public class CtrlAccueil {

	@FXML private TableView<Spectacle> tableSpec;
	@FXML private TableView<Representation> tableRep;
    @FXML private Button newSpec;
    @FXML private Button statsB;
    @FXML private Button newRepB;
    
    
    @FXML void newSpectacle(ActionEvent event) throws Exception {
    	
    	Main.closeAccueil();
    	Main.showSpectacleCreation();

    }

    @FXML
    void newRepres(ActionEvent event) throws Exception {
    	Main.closeAccueil();
    	Main.showRepresentationCreation(tableSpec.getSelectionModel().getSelectedItem());/*A corriger, il faut que le spectacle soit celui selectionner*/
    }

    @FXML
    void afficheStat(ActionEvent event) throws Exception {
    	Main.showStatistiques();
    }
    
    @FXML void initialize() {
    	TableColumn<Spectacle,String> specColonne1 = new TableColumn<Spectacle,String>("Nom");
    	specColonne1.setCellValueFactory(new PropertyValueFactory<Spectacle,String>("nom"));	
		tableSpec.getColumns().set(0, specColonne1);
		
    	TableColumn<Spectacle,String> specColonne2 = new TableColumn<Spectacle,String>("Description");
    	specColonne2.setCellValueFactory(new PropertyValueFactory<Spectacle,String>("description"));	
		tableSpec.getColumns().set(1, specColonne2);
		
    	TableColumn<Spectacle,Integer> specColonne3 = new TableColumn<Spectacle,Integer>("Durée");
    	specColonne3.setCellValueFactory(new PropertyValueFactory<Spectacle,Integer>("duree"));	
		tableSpec.getColumns().set(2, specColonne3);
		
    	TableColumn<Spectacle,String> specColonne4 = new TableColumn<Spectacle,String>("Genre");
    	specColonne4.setCellValueFactory(new PropertyValueFactory<Spectacle,String>("genre"));	
		tableSpec.getColumns().set(3, specColonne4);
		
    	TableColumn<Spectacle,Tarif> specColonne5 = new TableColumn<Spectacle,Tarif>("Tarif");
    	specColonne5.setCellValueFactory(new PropertyValueFactory<Spectacle,Tarif>("pleinTarif"));	
		tableSpec.getColumns().set(4, specColonne5);
		
				
		tableSpec.setItems(Donnees.getLesSpectacles());
		
		tableSpec.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		
		
		
		
		TableColumn<Representation,String> repColonne1 = new TableColumn<Representation,String>("Date");
		repColonne1.setCellValueFactory(new PropertyValueFactory<Representation,String>("date"));	
		tableRep.getColumns().set(0, repColonne1);
		
    	TableColumn<Representation,String> repColonne2 = new TableColumn<Representation,String>("Heure");
    	repColonne2.setCellValueFactory(new PropertyValueFactory<Representation,String>("heure"));	
		tableRep.getColumns().set(1, repColonne2);
		
    	TableColumn<Representation,Boolean> repColonne3 = new TableColumn<Representation,Boolean>("Annulee");
    	repColonne3.setCellValueFactory(new PropertyValueFactory<Representation,Boolean>("annulee"));	
		tableRep.getColumns().set(2, repColonne3);
		
    	TableColumn<Representation,String> repColonne4 = new TableColumn<Representation,String>("Spectacle");
    	repColonne4.setCellValueFactory(new PropertyValueFactory<Representation,String>("spectacle"));	
		tableRep.getColumns().set(3, repColonne4);
	
				
		tableRep.setItems(Donnees.getLesRepres());
		
		tableRep.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		
		
		Tooltip.install(newSpec, new Tooltip("Cliquez pour créer un nouveau spectacle."));
        Tooltip.install(statsB, new Tooltip("Cliquez pour afficher les statistiques."));
        Tooltip.install(newRepB, new Tooltip("Cliquez pour créer une nouvelle représentation."));
        Tooltip.install(tableSpec, new Tooltip("Liste des spectacles disponibles."));
        Tooltip.install(tableRep, new Tooltip("Liste des représentations disponibles."));
    }
    

}
