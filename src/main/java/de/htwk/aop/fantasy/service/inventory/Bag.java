package de.htwk.aop.fantasy.service.inventory;


import de.htwk.aop.fantasy.service.items.Item;

public class Bag {
	
	private int wallet;
	
	public Bag() {
		wallet = 0;
	}

	public int getWallet() {
		return wallet;
	}
	
	public void setWallet(int newWallet) {
		wallet = newWallet;
	}

}
