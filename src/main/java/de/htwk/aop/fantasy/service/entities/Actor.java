package de.htwk.aop.fantasy.service.entities;


public class Actor {
	
	private static int counter = 0;
	private final int ID;
	private String name;
	
		
	public Actor () {
		this.ID = ++counter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

}
