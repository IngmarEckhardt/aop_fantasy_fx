package de.htwk.aop.fantasy.gui;

import de.htwk.aop.fantasy.service.Market;
import javafx.application.Application;
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

public class MenuGUI extends Application {
	private GUIController guiController;
	
	public void startGUI() {
    	
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) {
    	Market market;
		
		market = new Market();
		this.guiController = new GUIController(market, this);
    	
    	
        primaryStage.setTitle("AOP_Fantasy");
        primaryStage.initStyle(StageStyle.UNDECORATED);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15.0);
        grid.setVgap(20.0);
        grid.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));

        Text titel = new Text("AOP_Fantasy");
        titel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(titel,0,0,3,2);

        Button knopfGame = new Button("Neues Spiel");
        grid.add(knopfGame, 0,3);
        Button knopfHelpPage = new Button ("Hilfe");
        grid.add(knopfHelpPage,1,3);
        Button knopfExit = new Button ("Programm verlassen");
        grid.add(knopfExit,2,3);
       

        knopfGame.setOnAction((ActionEvent actionEvent) -> {
            guiController.openGameEntryPoint(primaryStage);
        });
        knopfHelpPage.setOnAction((ActionEvent actionEvent) -> {
            guiController.openHelpWindow(primaryStage);
        });
       
        knopfExit.setOnAction(actionEvent -> {
            guiController.openEndscreen(primaryStage);
        });
        

        Scene meineScene = new Scene(grid, 500, 300);
        primaryStage.setScene(meineScene);
    	showMenuPage(primaryStage);
    }

	void showMenuPage(Stage primaryStage) {
		
        primaryStage.show();
	}
}