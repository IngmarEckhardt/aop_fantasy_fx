package de.htwk.aop.fantasy.gui;

import de.htwk.aop.fantasy.service.Market;
import de.htwk.aop.fantasy.service.entities.Player;
import de.htwk.aop.fantasy.service.items.Item;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class GUIController {
	private ObservableList<Item> itemlist;
	private MenuGUI menuGUI;
	private HelpPageGUI helpPageGUI;
	private ExitScreen exitScreen;
	private GameMenu gameMenu;
	private GameEntryPoint gameEntryPoint;
	private MarketMenu marketMenu;
	private PlayerMenu playerMenu;
	private PlayerStats playerStats;
	private Market market;
	
	public GUIController (Market market, MenuGUI menuGUI) {
		this.helpPageGUI = new HelpPageGUI();
		this.exitScreen = new ExitScreen();
		this.gameEntryPoint = new GameEntryPoint();
		this.gameMenu = new GameMenu();
		this.market = market;
		this.marketMenu = new MarketMenu(market);
		this.menuGUI = menuGUI;
		this.playerStats = new PlayerStats();
		
	}
	
    public void openHelpWindow (Stage menuStage) {
        helpPageGUI.neuesFenster(menuStage);
    }

    public void openEndscreen (Stage menuStage) {
        exitScreen.neuesFenster(menuStage);
    }

	public void openGameEntryPoint(Stage menuStage) {
		gameEntryPoint.neuesFenster(menuStage, this);
		
	}
	
	public void openGameWindow(Stage menuStage, Player playerOne, Player playertwo) {
		gameMenu.neuesFenster(menuStage, playerOne, playertwo, market, this);
	}

	public void openMarketMenu(Stage menuStage) {
		marketMenu.showAllTraders(menuStage);
		
	}

	public void openPlayerMenu(Stage menuStage, Player playerOne, Player playerTwo) {
		this.playerMenu = new PlayerMenu(this, playerOne, playerTwo);
		playerMenu.showInventary(menuStage, playerOne);
		
	}

	public void startMenu(Stage menuStage) {
		menuGUI.showMenuPage(menuStage);
	}

	public void openPlayerStats(Stage primaryStage, Player playerOne, Player playerTwo) {
		playerStats.showStats(primaryStage,playerOne, playerTwo);
		
	}


}
