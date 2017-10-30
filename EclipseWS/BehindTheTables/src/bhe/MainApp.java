package bhe;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Behind the Tables Roller");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	ArrayList<Table> tables;
	ListView<Table> lstTables;
	Button btnSearch;
	TextField txfSearch;
	WebView txaResult;

	private void initContent(GridPane pane) {
		tables = new ArrayList<>();
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		txfSearch = new TextField();
		pane.add(txfSearch, 0, 0, 2, 1);
		btnSearch = new Button("Search");
		pane.add(btnSearch, 2, 0);
		lstTables = new ListView<>();
		pane.add(lstTables, 0, 1);
		txaResult = new WebView();
		pane.add(txaResult, 1, 1);
		try {
			createStartList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lstTables.getSelectionModel().selectedItemProperty().addListener(event -> {
			try {
				tableSelectAction();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

	private void tableSelectAction() throws IOException {
		Table temp = lstTables.getSelectionModel().getSelectedItem();

		Document doc = Jsoup.connect(temp.getLink()).get();
		Element content = doc.select(".usertext-body.may-blank-within.md-container").get(1);
		txaResult.getEngine().loadContent(content.toString());
	}

	private void createStartList() throws IOException {
		Document doc;
		doc = Jsoup.connect("https://www.reddit.com/r/BehindTheTables/wiki/index").get();
		Elements inner = doc.select(".md.wiki");
		Elements uls = inner.get(0).select("ul");
		uls.remove(0);
		uls.remove(0);
		uls.remove(uls.size() - 1);
		for (Element u : uls) {
			Elements lis = u.select("li");
			for (Element l : lis) {
				Elements a = l.select("a");
				if (a.size() != 0) {
					tables.add(new Table(a.get(0).attr("href"), a.get(0).html()));
				}
			}
		}
		lstTables.getItems().setAll(tables);
	}

}
