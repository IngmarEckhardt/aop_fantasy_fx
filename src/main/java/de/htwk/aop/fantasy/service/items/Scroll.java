package de.htwk.aop.fantasy.service.items;

import java.util.Random;

import de.htwk.aop.fantasy.service.Metal;
import de.htwk.aop.fantasy.service.Spell;

public class Scroll extends Item {
	private final Spell spell;
	private static Random random  = new Random(System.nanoTime());
	
	public Scroll (Spell spell) {
		this.spell = spell;
	}

	public Scroll() {
		String intermediateSpell;
		
		this.spell = random.nextBoolean() ? Spell.HYPNOS : Spell.SCHREIBFEDER;
		this.setPrice((random.nextInt(150)+175));
		
		if (spell == Spell.HYPNOS) {
			setDescription("Augen von Hypnos");
			setTypProp("Hypnos_Rolle");
		} else {
			setDescription("Fluch der Schreibfeder");
			setTypProp("Schreibfeder-Rolle");
		}
	}

	public Spell getSpell() {
		return spell;
	}
}
