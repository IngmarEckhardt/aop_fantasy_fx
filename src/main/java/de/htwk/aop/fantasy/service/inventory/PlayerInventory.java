package de.htwk.aop.fantasy.service.inventory;

import java.util.ArrayList;

import de.htwk.aop.fantasy.service.items.Item;
import de.htwk.aop.fantasy.service.items.Ring;
import de.htwk.aop.fantasy.service.items.Scroll;
import de.htwk.aop.fantasy.service.items.Weapon;

public class PlayerInventory extends Bag {
	
	
	private ArrayList<Weapon> weapons;
	private ArrayList<Ring> rings;
	private ArrayList<Scroll> scrolls;
	
	public PlayerInventory() {
		weapons = new ArrayList<Weapon>();
		rings = new ArrayList<Ring>();
		scrolls = new ArrayList<Scroll>();
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public ArrayList<Ring> getRings() {
		return rings;
	}

	public ArrayList<Scroll> getScrolls() {
		return scrolls;
	}
	
	public ArrayList addItem (Item item) {
		if (item.getClass() == Weapon.class) {
			weapons.add((Weapon) item);
			return weapons;
		} else if (item.getClass() == Ring.class) {
			rings.add((Ring) item);
			return rings;
		} else if (item.getClass() == Scroll.class) {
			scrolls.add((Scroll) item);
			return scrolls;
		}
		System.out.println("Error: item-class wasnt specified: " + item.getClass().toString());
		return null;
	}
	
	public Integer receiveItemAndPay(Item itemToAdd) {
		setWallet(getWallet()-itemToAdd.getPrice());
		addItem(itemToAdd);
		return this.getWallet();
	}
	

	public ArrayList<Item> getItems() {
		ArrayList<Item> itemscollection = new ArrayList<Item>(weapons);
		itemscollection.addAll(rings);
		itemscollection.addAll(scrolls);
		return itemscollection;

	}
}
