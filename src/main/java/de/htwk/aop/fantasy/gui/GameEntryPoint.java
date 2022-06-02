package de.htwk.aop.fantasy.gui;

import de.htwk.aop.fantasy.service.entities.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

class GameEntryPoint {
	private Player playerOne;
	private Player playerTwo;
	
	
	public void neuesFenster(Stage menuStage, GUIController guiController) {
  

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(12);
        grid.setHgap(12);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(grid, 600, 350);
        Stage neuesWindow = new Stage();

        neuesWindow.setTitle("Spieler-Eingabe");
        neuesWindow.setScene(scene);
        neuesWindow.initModality(Modality.WINDOW_MODAL);
        neuesWindow.initOwner(menuStage);
        neuesWindow.setX(menuStage.getX() + 250);
        neuesWindow.setY(menuStage.getY() + 10);

        Text titel = new Text("Bitte geben Sie den Namen der Spieler ein: ");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        grid.add(titel, 0, 0, 2, 1);

        Label spielerOneName = new Label("Name des ersten Spieler");
        grid.add(spielerOneName, 0, 2);
        TextField eingabeSpielerOneName = new TextField();
        eingabeSpielerOneName.setText("Max Mustermann");
        grid.add(eingabeSpielerOneName, 1, 2);

        Label spielerTwoName = new Label("Name des zweiten Spieler");
        grid.add(spielerTwoName, 0, 3);
        TextField eingabeSpielerTwoName = new TextField();
        eingabeSpielerTwoName.setText("Otto Player");
        grid.add(eingabeSpielerTwoName, 1, 3);

        Button eingabeSpeichern = new Button("Spiel starten.");
        grid.add(eingabeSpeichern, 1, 8);
        Button eingabeAbbrechen = new Button("Abbrechen");
        grid.add(eingabeAbbrechen, 0, 8);

        eingabeSpeichern.setOnAction(actionEvent -> {
        	playerOne = new Player(eingabeSpielerOneName.getText());
        	playerTwo = new Player(eingabeSpielerTwoName.getText());
        	
            menuStage.close();
            guiController.openGameWindow(menuStage, playerOne, playerTwo);
            neuesWindow.close();

        });
        eingabeAbbrechen.setOnAction(actionEvent -> neuesWindow.close());
        neuesWindow.show();
    }
}
