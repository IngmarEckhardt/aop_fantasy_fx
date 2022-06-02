package de.htwk.aop.fantasy.service.inventory;

import java.util.ArrayList;
import de.htwk.aop.fantasy.service.items.Item;

public class ShopInventory<Type extends Item> extends Bag {
	protected ArrayList<Type> inventory;
	
	public ShopInventory () {
		inventory = new ArrayList<Type>();
	}
	
	public ArrayList<Type> getItems() {
		return inventory;
	}
	
	public boolean add(Type item) {
		return inventory.add(item);
	}
}