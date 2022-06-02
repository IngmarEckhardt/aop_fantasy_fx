package de.htwk.aop.fantasy.service.entities;

import java.util.ArrayList;
import java.util.Random;

import de.htwk.aop.fantasy.service.SortPrice;
import de.htwk.aop.fantasy.service.inventory.PlayerInventory;
import de.htwk.aop.fantasy.service.inventory.ShopInventory;
import de.htwk.aop.fantasy.service.items.Item;

public class Trader<TypA extends Item> extends Actor {
	private ShopInventory<TypA> bag;

	
	public Trader(String name) {
		setName(name);
		bag = new ShopInventory<TypA>();
	}



	public Item removeItemFromInventory(int ID) {
		Item itemToReturn = null;
		bag.getWallet();
		for (Item item : bag.getItems()) {
			if (item.getID() == ID) {
				itemToReturn = item;
				break;
			}
		}
		bag.getItems().remove(itemToReturn);
		return itemToReturn;
	}
	
	public Item getItemFromInventory(int ID) {
		for (Item item : bag.getItems()) {
			if (item.getID() == ID) {return item;}
		}
		return null;
	}
	
	public PlayerInventory sellItem (int ID, PlayerInventory playerInventory) {
		
		if (getItemFromInventory(ID).getPrice()> playerInventory.getWallet()) {return null;}
		
		playerInventory.addItem(removeItemFromInventory(ID));
		
		return playerInventory;
		
	}
	
	public Player sellRandomItem (Player playerOne) {
		boolean flag = false;
		Random random = new Random(System.nanoTime());
		
		bag.getItems().sort(new SortPrice());
		if (playerOne.getWallet() < bag.getItems().get(0).getPrice()) {return playerOne;}
		while (!flag) {
			Item itemToReturn = bag.getItems().get(random.nextInt(bag.getItems().size()));
			if (itemToReturn.getPrice() > playerOne.getWallet()) {continue;}
			else {	
				playerOne.receiveItemAndPay(itemToReturn);
				sellItem(itemToReturn);	
				flag = true;
			}
		}
		return playerOne;
		
	}	

	private Integer sellItem(Item itemToReturn) {
		bag.getItems().remove(itemToReturn);
		bag.setWallet(bag.getWallet()+itemToReturn.getPrice());
		return bag.getWallet();
	}


	public void addItem(TypA item) {
		bag.add(item);
	}
	
	public ArrayList<TypA> getItems() {
		return bag.getItems();
	}


	public int getCheapestItem() {
		bag.getItems().sort(new SortPrice());
		return bag.getItems().get(0).getPrice();
	}
}
