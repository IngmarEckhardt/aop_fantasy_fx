package de.htwk.aop.fantasy.gui;

import de.htwk.aop.fantasy.service.BranchOfArms;
import de.htwk.aop.fantasy.service.entities.Player;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerStats {

	public void showStats(Stage primaryStage, Player player, Player player2) {

		
		Stage statsWindow = new Stage();
        statsWindow.setTitle("Spielerwerte");
        statsWindow.initModality(Modality.WINDOW_MODAL);
        statsWindow.setOnCloseRequest(actionEvent -> statsWindow.close());
        statsWindow.initOwner(primaryStage);
        statsWindow.setX(+ 40);
        statsWindow.setY(+ 20);
        VBox vBox = new VBox();
        
		
		
       
        
        Text titel = new Text ("Werte von:  " + player.getName());
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
        vBox.getChildren().add(titel);
         
        
        int attackCount = player.getAttackValue();
        int attackCountRings = player.getAttackValueWithRings();
        int goldRingCount = player.countGoldenRing();
        boolean hasSchreibfeder = player.hasSchreibfederScroll();
        boolean hasHypnos = player.hasHypnosScroll();
  
        Text attackAuswertung = new Text ("\nAngriffswert mit Ring (Grundwert ohne Ringe):" + attackCountRings + " (" + attackCount + ")");
        vBox.getChildren().add(attackAuswertung);
        
        String goldring = (goldRingCount > 0) ? "Es wurden die Monster gezähmt, " + goldRingCount + " Goldringe in Besitz\n" : "Es konnten keine Monster gezähmt werden.\n";
        Text goldRingAuswertung = new Text (goldring);
        vBox.getChildren().add(goldRingAuswertung);
        
        String schriftrollenAuswertung = "";
        if (hasSchreibfeder) {
        	schriftrollenAuswertung += "Alle Schwerter des anderen Spieler wurden vernichtet als der Fluch der Schreibfeder angewandt wurde.\n";
        	player2.getWeapons().removeIf(e -> e.getBranch() == BranchOfArms.SWORD);
        } else {
        	schriftrollenAuswertung += "Kein Fluch der Schreibfeder in Besitz.\n";
        }
        if (hasHypnos) {
        	schriftrollenAuswertung += "Es konnten Monster gelähmt werden als die Augen von Hypnos angewandt wurden.\n ";
        } else {
        	schriftrollenAuswertung += "Keine Monster wurden gelähmt, da die Augen von Hypnos nicht im Besitz.\n";
        }
        
        Text schriftRollenText = new Text(schriftrollenAuswertung);
        vBox.getChildren().add(schriftRollenText);
        ScrollPane scrollPane = new ScrollPane(vBox);
        
        Button buttonExit = new Button("Schließen");
        buttonExit.setOnAction(actionEvent -> statsWindow.close());
        
       
        scrollPane.setFitToHeight(true);
        scrollPane.setPadding(new Insets(10));
        BorderPane borderPane = new BorderPane(scrollPane);
        borderPane.setPadding(new Insets(25));
        borderPane.setBottom(buttonExit);
        
        final Scene scene = new Scene(borderPane, 680, 320);
        statsWindow.setScene(scene);
        statsWindow.show();
	}

}
