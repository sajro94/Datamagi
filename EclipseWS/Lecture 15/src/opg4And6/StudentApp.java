package opg4And6;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Student Administration");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private CheckBox chkActive;
	private TextArea txAInf;
	private TextField txfAge;

	private Button btnAdd;
	private Button btnSave;
	private Button btnGet;
	private Button btnDelete;
	private Button btnAgeUp;

	private Controller controller = new Controller();

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(25));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		txAInf = new TextArea();
		txAInf.setEditable(false);
		txAInf.setPrefWidth(230);
		txAInf.setPrefHeight(60);
		pane.add(txAInf, 0, 0, 5, 1);

		Label lblName = new Label("Navn");
		pane.add(lblName, 0, 1);
		Label lblActive = new Label("Aktiv");
		pane.add(lblActive, 0, 3);
		Label lblAge = new Label("Alder");
		pane.add(lblAge, 0, 2);

		txfName = new TextField();
		pane.add(txfName, 1, 1, 3, 1);

		txfAge = new TextField("20");
		pane.add(txfAge, 1, 2, 3, 1);

		chkActive = new CheckBox();
		pane.add(chkActive, 1, 3);

		// add a buttons to the pane
		btnAdd = new Button("Create");
		pane.add(btnAdd, 0, 5);
		btnSave = new Button("Save");
		btnSave.setDisable(true);
		pane.add(btnSave, 1, 5);
		btnGet = new Button("Load");
		btnGet.setDisable(true);
		pane.add(btnGet, 2, 5);
		btnDelete = new Button("Delete");
		pane.add(btnDelete, 3, 5);
		btnDelete.setDisable(true);
		btnAgeUp = new Button("Age Up");
		pane.add(btnAgeUp, 0, 6);
		btnAgeUp.setDisable(true);

		// connect a method to the button
		btnAdd.setOnAction(event -> this.controller.addAction());
		btnSave.setOnAction(event -> this.controller.saveAction());
		btnGet.setOnAction(event -> this.controller.getAction());
		btnDelete.setOnAction(event -> this.controller.deleteAction());
		btnAgeUp.setOnAction(event -> this.controller.ageUpAction());
	}

	/**
	 * This class controls access to the model in this application. In this case,
	 * the model is a single Student object.
	 */
	private class Controller {
		private Student studerende = null;
		private ArrayList<Student> students = new ArrayList<>();

		private void ageUpAction() {
			studerende.increaseAge();
		}

		private void addAction() {
			studerende = new Student(txfName.getText().trim(), Integer.parseInt(txfAge.getText().trim()),
					chkActive.isSelected());
			clearFields();
			txAInf.setText(getDescription());
			btnGet.setDisable(false);
			btnAgeUp.setDisable(false);
			btnAdd.setDisable(false);
			students.add(studerende);
			System.out.println(Arrays.toString(students.toArray()));
		}

		private void saveAction() {
			if (studerende != null) {
				studerende.setName(txfName.getText().trim());
				studerende.setActive(chkActive.isSelected());
				studerende.setAge(Integer.parseInt(txfAge.getText().trim()));
				clearFields();
				txAInf.setText(getDescription());
				btnSave.setDisable(true);
				btnDelete.setDisable(true);
				btnGet.setDisable(false);
				btnAgeUp.setDisable(false);
			}
		}

		private Student findStudent(String name) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getName().equals(name)) {
					return students.get(i);
				}
			}
			return studerende;
		}

		private void getAction() {
			studerende = findStudent(txfName.getText().trim());
			if (studerende != null) {
				txfName.setText(studerende.getName());
				chkActive.setSelected(studerende.isActive());
				txfAge.setText(String.valueOf(studerende.getAge()));
				txAInf.setText(getDescription());
				btnSave.setDisable(false);
				btnDelete.setDisable(false);
				btnGet.setDisable(true);
				btnAgeUp.setDisable(true);
			}
		}

		private void deleteAction() {
			if (studerende != null) {
				students.remove(studerende);
				studerende = null;
				clearFields();
				txAInf.clear();
				btnDelete.setDisable(true);
				btnSave.setDisable(true);
				btnGet.setDisable(true);
				btnAgeUp.setDisable(true);
				btnAdd.setDisable(false);
			}
		}

		private void clearFields() {
			txfName.clear();
			txfAge.clear();
			chkActive.setSelected(false);
		}

		private String getDescription() {
			String result = "Ingen studerende gemt";
			if (studerende != null) {
				result = studerende.toString();
			}
			return result;
		}
	}
}
