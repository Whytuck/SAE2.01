package Lot7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CtrlStat {

    @FXML private Button annulerButton;

    @FXML private Button refreshButton;

    @FXML private TableView<Statistiques> statistiquesTable;

    @FXML void annulerStat(ActionEvent event) {
    	Main.fermerStatistiques();
    }
    
    @FXML
    void rafraichirStat(ActionEvent event) {
    	Main.fermerStatistiques();
    	Main.showStatistiques();
    }
    
    
    @FXML void initialize() {
    	
       	TableColumn<Statistiques,Integer> statColonne1 = new TableColumn<Statistiques,Integer>("Annee");
       	statColonne1.setCellValueFactory(new PropertyValueFactory<Statistiques,Integer>("annee"));	
       	statistiquesTable.getColumns().set(0, statColonne1);
       	
       	TableColumn<Statistiques,String> statColonne2 = new TableColumn<Statistiques,String>("Spectacle");
       	statColonne2.setCellValueFactory(new PropertyValueFactory<Statistiques,String>("spectacle"));	
       	statistiquesTable.getColumns().set(1, statColonne2);
       	
       	TableColumn<Statistiques,String> statColonne3 = new TableColumn<Statistiques,String>("Total Billet");
       	statColonne3.setCellValueFactory(new PropertyValueFactory<Statistiques,String>("billet"));	
       	statistiquesTable.getColumns().set(2, statColonne3);
       	
       	TableColumn<Statistiques,Integer> statColonne4 = new TableColumn<Statistiques,Integer>("Nombre de representaions");
       	statColonne4.setCellValueFactory(new PropertyValueFactory<Statistiques,Integer>("nbrep"));	
       	statistiquesTable.getColumns().set(3, statColonne4);
    		
    				
       	statistiquesTable.setItems(Donnees.getLesStats());
       	statistiquesTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
       	
       }
}