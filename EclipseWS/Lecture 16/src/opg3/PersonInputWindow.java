package opg3;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage {

	public PersonInputWindow(String title, Stage owner) {
		initOwner(owner);
		initStyle(StageStyle.UTILITY);
		initModality(Modality.APPLICATION_MODAL);
		setMinHeight(100);
		setMinWidth(200);
		setResizable(false);

		setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	private TextField txfName;
	private TextField txfTitle;
	private CheckBox chkSenior;
	private Person actualPerson;
	private Button btnCreate;

	private void initContent(GridPane pane) {

		pane.setGridLinesVisible(false);

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);
		txfName = new TextField();
		pane.add(txfName, 1, 0);
		Label lblTitle = new Label("Title:");
		pane.add(lblTitle, 0, 1);
		txfTitle = new TextField();
		pane.add(txfTitle, 1, 1);
		chkSenior = new CheckBox("Senior");
		pane.add(chkSenior, 0, 2);
		btnCreate = new Button("Create");
		pane.add(btnCreate, 1, 2);
		btnCreate.setOnAction(event -> createPersonAction());

	}

	private void createPersonAction() {
		setActualPerson(new Person(txfTitle.getText().trim(), txfName.getText().trim(), chkSenior.isSelected()));
		hide();
	}

	public Person getActualPerson() {
		return actualPerson;
	}

	public void setActualPerson(Person actualPerson) {
		this.actualPerson = actualPerson;
	}
}
