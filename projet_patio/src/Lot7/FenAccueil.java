package Lot7;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class FenAccueil extends Stage {
	CtrlAccueil ctrl;
	public FenAccueil() throws IOException {
		
		this.setTitle("Accueil Patio");
		this.setResizable(true);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/AccueilPatio.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
        
     	return root;
	}
}
