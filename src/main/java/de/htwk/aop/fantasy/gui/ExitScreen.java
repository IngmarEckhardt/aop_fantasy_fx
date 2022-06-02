package de.htwk.aop.fantasy.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExitScreen {
	
    public void neuesFenster(Stage menustage) {

        final GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(12);
        grid.setHgap(12);
        grid.setPadding(new Insets(10, 10, 10, 10));

        final Scene scene = new Scene(grid, 400, 120);
        final Stage thisStage = new Stage();
        
        
        thisStage.setScene(scene);
        thisStage.setOnCloseRequest(actionEvent -> {System.exit(0);});

        thisStage.setTitle("Auf Wiedersehen");
        thisStage.initModality(Modality.WINDOW_MODAL);
        thisStage.initOwner(menustage);
        thisStage.setX(menustage.getX() + 40);
        thisStage.setY(menustage.getY() + 20);

        final Text abschiedstext = new Text("Das Programm wird geschlossen");
        abschiedstext.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        grid.add(abschiedstext, 0, 0, 4, 1);
        thisStage.show();

        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(ExitScreen::closeCatControl, 800, TimeUnit.MILLISECONDS);
    }

    protected static void closeCatControl()
    {System.exit(0);}
}