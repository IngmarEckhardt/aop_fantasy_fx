package de.htwk.aop.fantasy;

import de.htwk.aop.fantasy.gui.GUIController;
import de.htwk.aop.fantasy.gui.MenuGUI;
import de.htwk.aop.fantasy.service.Market;
import de.htwk.aop.fantasy.service.entities.Player;

public class Application {
	private String winner;


	public static void main(String[] args) {
		MenuGUI menuGUI = new MenuGUI();
		
        menuGUI.startGUI();
		
		System.out.println("Programm wird beendet.");
	
    

}
}
