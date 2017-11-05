package statChoosers;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class Chooser extends Stage {
	protected int[] stats = new int[6];
	protected String desc = "Generic Chooser";
	protected String name = "Chooser";

	public Chooser(Stage owner, String title) {
		initOwner(owner);
		initStyle(StageStyle.DECORATED);
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

	public final int[] getStats() {
		return stats;
	}

	protected abstract void initContent(GridPane pane);

	protected abstract void generateAction();

	protected abstract void generateAction(String annotation);

	@Override
	public final String toString() {
		return name;
	}
}
