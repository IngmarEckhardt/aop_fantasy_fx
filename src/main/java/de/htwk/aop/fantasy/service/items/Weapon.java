package de.htwk.aop.fantasy.service.items;

import java.util.Random;

import de.htwk.aop.fantasy.service.BranchOfArms;

public class Weapon extends Item {

	private int attackValue;
	private BranchOfArms branch;
	private static Random random  = new Random(System.nanoTime());
	

	public Weapon() {
		this.branch = random.nextBoolean() ? BranchOfArms.SWORD : BranchOfArms.BOW;
		this.attackValue = random.nextInt(81)+20;
		this.setPrice((random.nextInt(150)+15));
		setDescription("attack: " + attackValue);
		if (this.branch == BranchOfArms.SWORD) {setTypProp("Schwert");}
		else {setTypProp("Bogen");}
	}


	public BranchOfArms getBranch() {
		return branch;
	}


	public int getAttackValue() {
		return attackValue;
	}
}
