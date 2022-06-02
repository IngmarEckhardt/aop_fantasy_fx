package de.htwk.aop.fantasy.gui;

import de.htwk.aop.fantasy.service.Market;
import de.htwk.aop.fantasy.service.entities.Player;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

class GameMenu {

	public void neuesFenster(Stage menuStage, Player playerOne, Player playertwo, Market market,
			GUIController guiController) {
		
		final Stage gameMenuStage = new Stage();
		final GridPane grid = new GridPane();

		gameMenuStage.setTitle("AOP_Fantasy");
		gameMenuStage.initStyle(StageStyle.UNDECORATED);

		grid.setAlignment(Pos.CENTER);
		grid.setHgap(15.0);
		grid.setVgap(20.0);
		grid.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));

		Text titel = new Text("AOP_Fantasy_Game");
		titel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		grid.add(titel, 0, 0, 3, 2);

		Button knopfMarket = new Button("Marktplatz");
		grid.add(knopfMarket, 0, 3);
		Button knopfRandomEinkauf = new Button("Starte Random Einkauf");
		grid.add(knopfRandomEinkauf, 1, 3);
		Button knopfPlayerStats = new Button("Spieler_Stats/Inventar");
		grid.add(knopfPlayerStats, 2, 3);

		Button knopfExit = new Button("Spiel beenden");
		grid.add(knopfExit, 1, 5);

		knopfMarket.setOnAction((ActionEvent actionEvent) -> guiController.openMarketMenu(menuStage));
		knopfRandomEinkauf.setOnAction((ActionEvent actionEvent) -> market.buyRandomItems(playerOne, playertwo));
		knopfPlayerStats.setOnAction(actionEvent -> guiController.openPlayerMenu(menuStage, playerOne, playertwo));
		knopfExit.setOnAction(actionEvent -> {
			gameMenuStage.close();
			guiController.startMenu(menuStage);
		});

		Scene meineScene = new Scene(grid, 500, 300);
		gameMenuStage.setScene(meineScene);
		gameMenuStage.show();
	}

}
