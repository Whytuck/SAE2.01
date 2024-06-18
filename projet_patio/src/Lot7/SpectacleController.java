package Lot7;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpectacleController {

    @FXML private Button cancelButton;
    @FXML private TextField tarifEnfantField;
    @FXML private TextField tarifReduitField;
    @FXML private TextField nomSpectacleField;
    @FXML private TextField tarifPleinField;
    @FXML private TextArea descriptionField;
    @FXML private Button saveButton;
    @FXML private TextField dureeField;
    @FXML private ComboBox<String> genreChoiceBox;
    @FXML private Label erreurLabel;

    @FXML
    void initialize() {
    	
    	genreChoiceBox.setItems(Donnees.getLibellesDesGenres());
    	
    	
    	BooleanBinding nothingSelected = Bindings.or(
    		    Bindings.equal(genreChoiceBox.getSelectionModel().selectedIndexProperty(), -1),
    		    Bindings.isEmpty(descriptionField.textProperty())
    		    );
    	BooleanBinding nothingSelected2 = Bindings.or(
    			nothingSelected,
    			Bindings.isEmpty(nomSpectacleField.textProperty())
    			
    			);
    	BooleanBinding nothingSelected3 = Bindings.or(
    			nothingSelected2,
    			Bindings.isEmpty(dureeField.textProperty())
    			
    			);
    	BooleanBinding nothingSelected4 = Bindings.or(
    			nothingSelected3,
    			Bindings.isEmpty(tarifPleinField.textProperty())
    			
    			);	
    	BooleanBinding nothingSelected5 = Bindings.or(
    			nothingSelected4,
    		Bindings.isEmpty(tarifReduitField.textProperty())
    			
    			);
    	BooleanBinding nothingSelected6 = Bindings.or(
    			nothingSelected5,
    			Bindings.isEmpty(tarifEnfantField.textProperty())
    			
    			);
    	
    	saveButton.disableProperty().bind(nothingSelected6);
    	
    	
    	
    	Tooltip.install(cancelButton, new Tooltip("Cliquez pour annuler et fermer cette fenêtre."));
        Tooltip.install(saveButton, new Tooltip("Cliquez pour sauvegarder le spectacle."));
        Tooltip.install(tarifEnfantField, new Tooltip("Entrez le tarif pour les enfants."));
        Tooltip.install(tarifReduitField, new Tooltip("Entrez le tarif réduit."));
        Tooltip.install(nomSpectacleField, new Tooltip("Entrez le nom du spectacle."));
        Tooltip.install(tarifPleinField, new Tooltip("Entrez le tarif plein."));
        Tooltip.install(descriptionField, new Tooltip("Entrez la description du spectacle."));
        Tooltip.install(dureeField, new Tooltip("Entrez la durée du spectacle en minutes."));
        Tooltip.install(genreChoiceBox, new Tooltip("Choisissez le genre du spectacle."));
    	
    	
    }

    @FXML
    void saveSpectacle(ActionEvent event) {
        try {
            String nomSpectacle = nomSpectacleField.getText();
            if (nomSpectacle.isEmpty()) {
                throw new Exception("Nom du spectacle est requis");
            }

            String description = descriptionField.getText();
            if (description.isEmpty()) {
                throw new Exception("Description est requise");
            }

            int duree = Integer.parseInt(dureeField.getText());
            if (duree <= 0) {
                throw new Exception("Durée doit être un entier positif");
            }

            String genre = genreChoiceBox.getValue();
            if (genre == null) {
                throw new Exception("Genre est requis");
            }

            double tarifPlein = Double.parseDouble(tarifPleinField.getText());
            double tarifReduit = Double.parseDouble(tarifReduitField.getText());
            double tarifEnfant = Double.parseDouble(tarifEnfantField.getText());

            Tarif newTar = new Tarif(tarifPlein, tarifReduit, tarifEnfant);

            Main.validerSpectacle(nomSpectacle, description, duree, genre, newTar);
            Main.showAccueil();
        } catch (NumberFormatException e) {
            erreurLabel.setText("Erreur de format de nombre: " + e.getMessage());
            erreurLabel.setVisible(true);
        } catch (Exception e) {
            erreurLabel.setText("Erreur: " + e.getMessage());
            erreurLabel.setVisible(true);
        }
    }

    @FXML
    void cancelSpectacle(ActionEvent event) {
    	
    	Main.fermerSpectacleCreation();

    }

}