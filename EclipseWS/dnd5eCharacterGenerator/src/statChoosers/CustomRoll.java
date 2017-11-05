package statChoosers;

import dieRoller.AnnotationRoller;
import dieRoller.BadAnnotationException;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CustomRoll extends Chooser {

	public CustomRoll(Stage owner, String title) {
		super(owner, title);
		desc = "A stat Generator";
	}

	@Override
	public void generateAction(String annotation) {
		for (int i = 0; i < 6; i++) {
			try {
				stats[i] = AnnotationRoller.dieAnnotator(annotation);
			} catch (BadAnnotationException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void generateAction() {
		generateAction("4d6dl1");
	}

	@Override
	protected void initContent(GridPane pane) {
		// TODO Auto-generated method stub

	}

}
