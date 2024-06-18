package Lot7;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class RepresentationController {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField heureField;

    @FXML
    private TextField nomSpec;

    @FXML
    private TextField dateSpec;

    @FXML
    private Button saveButton;
    
    @FXML
    private Label erreurLabel1;

    private Spectacle s;

    public void afficherRepresentation(Spectacle spec) {
        this.s = spec;
        dateSpec.clear();
        heureField.clear();
        nomSpec.textProperty().setValue(spec.getNom());
    }

    @FXML
    void choixSave(ActionEvent event) {
        try {
            String date = dateSpec.getText();
            if (date.isEmpty()) {
                throw new Exception("Date est requise");
            }

            String heure = heureField.getText();
            if (heure.isEmpty()) {
                throw new Exception("Heure est requise");
            }

            String[] dateParts = date.split("/");
            if (dateParts.length!= 3) {
                throw new Exception("Format de date incorrect (JJ/MM/AAAA)");
            }

            String[] heureParts = heure.split(":");
            if (heureParts.length!= 2) {
                throw new Exception("Format d'heure incorrect (HH:MM)");
            }

            int jour = Integer.parseInt(dateParts[0]);
            int mois = Integer.parseInt(dateParts[1]);
            int annee = Integer.parseInt(dateParts[2]);
            

            if (jour < 1 || jour > 31) {
                throw new Exception("Jour doit être entre 1 et 31");
            }

            if (mois < 1 || mois > 12) {
                throw new Exception("Mois doit être entre 1 et 12");
            }
            
            LocalDate maintenant = LocalDate.now();
            int anneeActuel = maintenant.getYear();
            int moisActuel = maintenant.getMonthValue();
            int jourActuel = maintenant.getDayOfMonth();
            
            
            if (annee < anneeActuel || mois < moisActuel || jour < jourActuel ) {
                throw new Exception("La date  ne peut pas être antérieur à celle actuelle");
            }

            int heureInt = Integer.parseInt(heureParts[0]);
            int minuteInt = Integer.parseInt(heureParts[1]);

            if (heureInt < 0 || heureInt > 23) {
                throw new Exception("Heure doit être entre 0 et 23");
            }

            if (minuteInt < 0 || minuteInt > 59) {
                throw new Exception("Minute doit être entre 0 et 59");
            }

            Main.validerRepresentation(date, heure, s);

            Main.showAccueil();

        } catch (Exception e) {
            erreurLabel1.setText(e.getMessage());
            erreurLabel1.setVisible(true);
        }
    }

    @FXML
    void cancel(ActionEvent event) {
        Main.fermerRepresentationCreation();
    }

    public void initialize() {
        saveButton.disableProperty().bind(heureField.textProperty().isEmpty().or(dateSpec.textProperty().isEmpty()));
        
        Tooltip.install(cancelButton, new Tooltip("Cliquez pour annuler et fermer cette fenêtre."));
        Tooltip.install(saveButton, new Tooltip("Cliquez pour sauvegarder la représentation."));
        Tooltip.install(heureField, new Tooltip("Entrez l'heure de la représentation (HH:MM)."));
        Tooltip.install(dateSpec, new Tooltip("Entrez la date de la représentation (JJ/MM/AAAA)."));
        Tooltip.install(nomSpec, new Tooltip("Nom du spectacle."));
    }
}