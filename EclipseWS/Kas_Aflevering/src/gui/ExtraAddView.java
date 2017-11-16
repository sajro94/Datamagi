package gui;

import application.model.ExtraService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExtraAddView extends Stage {

	private ExtraService extra;

	public ExtraService getExtra() {
		return extra;
	}

	public ExtraAddView(Stage owner) {
		initOwner(owner);
		initStyle(StageStyle.DECORATED);
		initModality(Modality.APPLICATION_MODAL);
		setMinHeight(100);
		setMinWidth(300);
		setResizable(false);

		setTitle("Tilføj Ekstra Service");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	// -----Labels-----
	private Label lblName = new Label("Navn");
	private Label lblPrice = new Label("Pris");
	// -----TextFields-----
	private TextField txfName = new TextField();
	private TextField txfPrice = new TextField("50.00");
	// -----Buttons-----
	private Button btnAdd = new Button("Tilføj");

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);
		// -----Pane placement-----
		pane.add(lblName, 0, 0);
		pane.add(lblPrice, 0, 1);
		pane.add(txfName, 1, 0);
		pane.add(txfPrice, 1, 1);
		pane.add(btnAdd, 0, 2);
		// -----Button Actions-----
		btnAdd.setOnAction(event -> addExtraAction());
	}

	private void addExtraAction() {
		if (isAllFilledCorrectly()) {
			String name = txfName.getText().trim();
			double price = Double.parseDouble(txfPrice.getText().trim());
			extra = new ExtraService(name, price);
			hide();
		}
	}

	private boolean isAllFilledCorrectly() {
		boolean tester = true;
		String contentText = "";
		if (txfName.getText().trim().equals("")) {
			tester = false;
			contentText += String.format("Navn er tomt.%n");
		}
		if (!txfPrice.getText().trim().matches("^\\d+\\.\\d{2}$")) {
			tester = false;
			contentText += String.format("Pris skal være et komma tal med maks to cifre efter komma(.).%n");
		}
		if (!tester) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Fejl i udfyldelse");
			alert.setContentText(contentText);
			alert.showAndWait();
		}
		return tester;
	}
}
