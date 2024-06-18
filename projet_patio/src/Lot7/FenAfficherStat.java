package Lot7;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class FenAfficherStat extends Stage {
	CtrlStat ctrl;
	public FenAfficherStat() throws IOException {
		
		this.setTitle("Affichage des statistiques");
		this.setResizable(true);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Statistiques.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
        
     	return root;
	}
}

