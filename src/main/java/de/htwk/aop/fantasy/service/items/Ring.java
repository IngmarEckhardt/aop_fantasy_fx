package de.htwk.aop.fantasy.service.items;

import java.util.Random;

import de.htwk.aop.fantasy.service.BranchOfArms;
import de.htwk.aop.fantasy.service.Metal;

public class Ring extends Item {
	private final Metal metal;
	private static Random random  = new Random(System.nanoTime());
	
	
	
	public Ring (Metal metal) {
		this.metal = metal;
	}

	public Ring() {
	
		this.metal = random.nextBoolean() ? Metal.GOLD : Metal.SILVER;
		this.setPrice((random.nextInt(150)+15));
		this.setDescription("Ring made of " + metal.toString() + " with the price: " + getPrice());
		if (this.metal == Metal.GOLD) {
			setTypProp("Goldring");
			setDescription("zähmt Monster");
			}
		else {
			setTypProp("Silberring");
			setDescription("Kampfstärke +20%");
			}
	}

	public Metal getMetal() {
		return metal;
	}
}
