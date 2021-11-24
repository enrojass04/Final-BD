module ProyectoBD {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	
	opens poli.controller to javafx.graphics, javafx.fxml, javafx.base;
	opens poli.model to javafx.graphics, javafx.fxml,javafx.base;
	opens poli.tablas to javafx.graphics, javafx.fxml, javafx.base;
}