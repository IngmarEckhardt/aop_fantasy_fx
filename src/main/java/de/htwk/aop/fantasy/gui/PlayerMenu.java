package de.htwk.aop.fantasy.gui;

import javax.swing.JOptionPane;

import de.htwk.aop.fantasy.service.SortPrice;
import de.htwk.aop.fantasy.service.Spell;
import de.htwk.aop.fantasy.service.entities.Player;
import de.htwk.aop.fantasy.service.inventory.PlayerInventory;
import de.htwk.aop.fantasy.service.items.Item;
import de.htwk.aop.fantasy.service.items.Ring;
import de.htwk.aop.fantasy.service.items.Scroll;
import de.htwk.aop.fantasy.service.items.Weapon;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class PlayerMenu {
	private GUIController guiController;
	private Player playerOne, playerTwo;
	
	public PlayerMenu(GUIController guiControl, Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.guiController = guiControl;
	}
	
	public void showInventary (Stage primaryStage, Player player) {
        

        VBox vBox = new VBox();
        String intermediateWeaponInfo, intermediateRingInfo, intermediateSpellInfo;
        Text waffenListe,ringListe, spruchListe;
        
        Text titel = new Text ("Inventar Spieler " + player.getName() + " Gold: " + player.getWallet());
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        vBox.getChildren().add(titel);
        
        Text waffenTitel = new Text ("\nWaffen");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        vBox.getChildren().add(waffenTitel);   
       
        for (Weapon weapon: player.getWeapons()) {
            intermediateWeaponInfo = weapon.getTyp() + "(ID:" + weapon.getID() + "): "
            		+ "\nAttackwert: " + weapon.getAttackValue()
            		+ "\nPreis: " + weapon.getPrice();

            waffenListe = new Text (intermediateWeaponInfo);
            vBox.getChildren().add(waffenListe);
            
        }
        
        Text ringTitel = new Text ("\nRinge");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        vBox.getChildren().add(ringTitel);       
        for (Ring ring: player.getRings()) {
            intermediateRingInfo = ring.getTyp() + "(ID:" + ring.getID() + "): "
            		+ "\nPreis: " + ring.getPrice();

            ringListe = new Text (intermediateRingInfo);
            vBox.getChildren().add(ringListe);
            
        }
        
        Text spellTitel = new Text ("\nZaubersprüche");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        vBox.getChildren().add(spellTitel);       
        for (Scroll scroll: player.getScrolls()) {
            intermediateSpellInfo = scroll.getTyp() + "(ID:" + scroll.getID() + "): "
            		+ "\nBeschreibung: " + scroll.getDescription() 
            		+ "\nPreis: " + scroll.getPrice();

            spruchListe = new Text (intermediateSpellInfo);
            vBox.getChildren().add(spruchListe);
            
        }
        Button buttonCalculateItems = new Button("Spielerwerte");
        vBox.getChildren().add(buttonCalculateItems);
        Button buttonSwitch = new Button("Switch Player");
               
        

        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setFitToHeight(true);
        scrollPane.setPadding(new Insets(10));
        BorderPane borderPane = new BorderPane(scrollPane);
        borderPane.setPadding(new Insets(25));
        borderPane.setBottom(buttonSwitch);

        Stage inventoryWindow = new Stage();
        inventoryWindow.setTitle("Spielerinventar");
        inventoryWindow.initModality(Modality.WINDOW_MODAL);
        inventoryWindow.setOnCloseRequest(actionEvent -> inventoryWindow.close());
        inventoryWindow.initOwner(primaryStage);
        inventoryWindow.setX(+ 40);
        inventoryWindow.setY(+ 20);
        
        buttonSwitch.setOnAction(actionEvent -> {
        	
        	if (player == playerOne) {
        		showInventary(primaryStage, playerTwo);
        	} else {
        		showInventary(primaryStage, playerOne);
        	}
        	inventoryWindow.close();
        });
        
        buttonCalculateItems.setOnAction(actionEvent -> {
        	if (player == playerOne) {
        		guiController.openPlayerStats(primaryStage, playerOne, playerTwo);
        	} else {
        		guiController.openPlayerStats(primaryStage, playerTwo, playerOne);	
        	}
        });

        final Scene scene = new Scene(borderPane, 450, 520);
        inventoryWindow.setScene(scene);
        inventoryWindow.show();
    }
}