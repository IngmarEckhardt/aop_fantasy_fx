package de.htwk.aop.fantasy.service.entities;

import java.util.ArrayList;

import de.htwk.aop.fantasy.service.Metal;
import de.htwk.aop.fantasy.service.Spell;
import de.htwk.aop.fantasy.service.inventory.PlayerInventory;
import de.htwk.aop.fantasy.service.items.Item;
import de.htwk.aop.fantasy.service.items.Ring;
import de.htwk.aop.fantasy.service.items.Scroll;
import de.htwk.aop.fantasy.service.items.Weapon;

public class Player extends Actor {
	private PlayerInventory bag;

	public Player(String name) {
		this.setName(name);
		bag = new PlayerInventory();
		bag.setWallet(1000);
	}
	
	public ArrayList<Weapon> getWeapons() {
		return bag.getWeapons();
	}

	public ArrayList<Ring> getRings() {
		return bag.getRings();
	}

	public ArrayList<Scroll> getScrolls() {
		return bag.getScrolls();
	}
	
	public Integer getWallet() {
		return bag.getWallet();
	}
	
	public Integer receiveItemAndPay(Item itemToAdd) {
		return bag.receiveItemAndPay(itemToAdd);
	}

	public int getAttackValue() {
		return bag.getWeapons().stream().mapToInt(Weapon::getAttackValue).sum();
	}
	
	public int getAttackValueWithRings() {
		int multiplier = 10;
		for (Ring ring : bag.getRings()) {
			if (ring.getMetal() == Metal.SILVER) {
				multiplier += 2;
			}
		}
		return (int)((multiplier/10.0) * getAttackValue());
	}
	
	public int countGoldenRing() {
		int count = 0;
		
		for (Ring ring: bag.getRings()) {
			if (ring.getMetal() == Metal.GOLD) {count++;}
		}
		
		return count;
	}
	
	public boolean hasSchreibfederScroll() {
		
		for (Scroll scroll : bag.getScrolls()) {
			if (scroll.getSpell() == Spell.SCHREIBFEDER) {return true;}
		}
		
		return false;
	}
	
	public boolean hasHypnosScroll() {
		
		for (Scroll scroll : bag.getScrolls()) {
			if (scroll.getSpell() == Spell.HYPNOS) {return true;}
		}
		
		return false;
	}
	
}