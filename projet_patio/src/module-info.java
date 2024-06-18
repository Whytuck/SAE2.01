module projet_patio {
	requires javafx.controls;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens Lot7 to javafx.graphics, javafx.fxml, controls, javafx.base;
}

