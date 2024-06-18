package Lot7;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class FenCrRepresentation extends Stage {
	RepresentationController ctrl;
	public FenCrRepresentation() throws IOException {
		
		this.setTitle("Création d'une représentation");
		this.setResizable(true);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/RepresentationCreation.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}
	
	public void afficherRepresentation(Spectacle spec) {
		ctrl.afficherRepresentation(spec);
    }
}




