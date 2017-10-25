package quickWriter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Gui Demo TextArea");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private TextArea txaInput;
	private TextArea txaOutput;
	private Button btnSubmit;
	private TextField txfColor;
	private Label lblWords;
	private long time = System.currentTimeMillis();
	private String fileName = "store.tmp";
	private Path file = Paths.get(fileName);
	private List<String> lines;

	private void initContent(GridPane pane) {
		lines = new ArrayList<>();
		double width = 900.0;
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		txaInput = new TextArea();
		txaInput.setWrapText(true);
		txaInput.setPrefWidth(width);
		txaInput.setPrefHeight(900);
		String text = "";
		boolean first = true;
		try {
			for (String s : Files.readAllLines(file)) {
				if (first) {
					text += s;
					first = false;
				} else {
					text += String.format("%n%s", s);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			byte[] temp = { 0 };
			try {
				Files.write(file, temp);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		txaInput.setText(text);
		pane.add(txaInput, 0, 1);
		txaOutput = new TextArea();
		txaOutput.setPrefWidth(width);
		pane.add(txaOutput, 0, 2);
		btnSubmit = new Button("Submit");
		pane.add(btnSubmit, 1, 1);
		txfColor = new TextField("#993300");
		pane.add(txfColor, 0, 0);
		lblWords = new Label("-");
		pane.add(lblWords, 1, 2);
		btnSubmit.setOnAction(event -> submitAction());
		txaInput.textProperty().addListener(event -> textListener());
	}

	private void textListener() {
		if (System.currentTimeMillis() - time > 500) {
			System.out.println("Attempting to store text!");
			lines = Arrays.asList(txaInput.getText().trim().split(System.getProperty("line.separator")));
			try {
				Files.write(file, lines, Charset.forName("UTF-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void submitAction() {
		String color = "#993300";
		if (!txfColor.getText().trim().matches("#[0-9a-f]{6}")) {
			color = txfColor.getText().trim();
		}

		String text = txaInput.getText().trim();
		String out = text.replaceAll("\\\"(.*)\"", String.format("[color=%s][b]\"$1\"[/b][/color]", color));
		out = out.replaceAll("\\*(.*)\\*", String.format("[color=%s][i]*$1*[/i][/color]", color));
		txaOutput.setText(out);
		lblWords.setText(String.valueOf(countWords(out)));
	}

	public static int countWords(String s) {

		int wordCount = 0;

		boolean word = false;
		int endOfLine = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {
			// if the char is a letter, word = true.
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				word = true;
				// if char isn't a letter and there have been letters before,
				// counter goes up.
			} else if (!Character.isLetter(s.charAt(i)) && word) {
				wordCount++;
				word = false;
				// last word of String; if it doesn't end with a non letter, it
				// wouldn't count without this.
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				wordCount++;
			}
		}
		return wordCount;
	}

}
