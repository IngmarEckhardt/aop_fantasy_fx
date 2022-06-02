package de.htwk.aop.fantasy.service;

import java.util.Random;

import de.htwk.aop.fantasy.service.entities.Player;
import de.htwk.aop.fantasy.service.entities.Trader;
import de.htwk.aop.fantasy.service.inventory.PlayerInventory;
import de.htwk.aop.fantasy.service.items.Item;
import de.htwk.aop.fantasy.service.items.Ring;
import de.htwk.aop.fantasy.service.items.Scroll;
import de.htwk.aop.fantasy.service.items.Weapon;

public class Market {

	private Trader<Weapon> smith;
	private Trader<Ring> jeweler;
	private Trader<Scroll> bookstore;

	public Market() {
		this.smith = new Trader<Weapon>("Schmied");
		this.jeweler = new Trader<Ring>("Juwelier");
		this.bookstore = new Trader<Scroll>("Buchladen");
		fillSortiment();
	}

	private void fillSortiment() {

		Random random = new Random(System.nanoTime());
		int amount = random.nextInt(20) + 10;
		for (int i = 0; i < amount; i++) {
			smith.addItem(new Weapon());
		}

		amount = random.nextInt(20) + 10;
		for (int i = 0; i < amount; i++) {
			jeweler.addItem(new Ring());
		}

		amount = random.nextInt(10) + 10;
		for (int i = 0; i < amount; i++) {
			bookstore.addItem(new Scroll());
		}
	}

	public Trader<Weapon> getSmith() {
		return smith;
	}

	public Trader<Ring> getJeweler() {
		return jeweler;
	}

	public Trader<Scroll> getBookstore() {
		return bookstore;
	}

	public void buyRandomItems(Player playerOne, Player playertwo) {
		Integer walletPlayerOne = playerOne.getWallet();
		Integer walletPlayerTwo = playertwo.getWallet();
		Random random = new Random(System.nanoTime());
		
		
		smith.sellRandomItem(playerOne);
		jeweler.sellRandomItem(playerOne);
		bookstore.sellRandomItem(playerOne);
		
		smith.sellRandomItem(playertwo);
		jeweler.sellRandomItem(playertwo);
		bookstore.sellRandomItem(playertwo);
		
		
		while (isAbleToBuyAnything(playerOne)) {
			int choice = random.nextInt(3);
			switch (choice) {
			case 0:
				smith.sellRandomItem(playerOne);
				break;
			case 1:
				jeweler.sellRandomItem(playerOne);
				break;
			case 2:
				bookstore.sellRandomItem(playerOne);
				break;
			default:
				break;
			}
						
		}
		
		while (isAbleToBuyAnything(playertwo)) {
			int choice = random.nextInt(3);
			switch (choice) {
			case 0:
				smith.sellRandomItem(playertwo);
				break;
			case 1:
				jeweler.sellRandomItem(playertwo);
				break;
			case 2:
				bookstore.sellRandomItem(playertwo);
				break;
			default:
				break;
			}
						
		}
		
	}

	private boolean isAbleToBuyAnything(Player player) {
		
		return player.getWallet() > 0 && (player.getWallet() > jeweler.getCheapestItem() || 
				player.getWallet() > smith.getCheapestItem() || 
				player.getWallet() > bookstore.getCheapestItem());
	}

}
