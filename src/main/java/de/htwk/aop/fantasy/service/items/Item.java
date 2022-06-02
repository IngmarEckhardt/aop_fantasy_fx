package de.htwk.aop.fantasy.service.items;

import de.htwk.aop.fantasy.service.Merchandise;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item implements Merchandise {
	private static int counter = 0;
	private final Integer ID;
	private Integer priceInt;
	private String description, typString;
	private SimpleStringProperty desc;
	private SimpleStringProperty typ;
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty price;
    
	
	public void setTypProp(String typ) {
		this.typString = typ;
		this.typ = new SimpleStringProperty(typ);
	}
	
	public SimpleStringProperty typProperty() {
		return this.typ;
	}

	public SimpleStringProperty descProperty() {
		return desc;
	}

	public SimpleIntegerProperty idProperty() {
		return id;
	}
	
	public SimpleIntegerProperty priceProperty() {
		return price;
	}

	public String getTyp() {
		return typString;
	}

	public Item() {
		this.ID = ++counter;
		this.id = new SimpleIntegerProperty(ID);
		priceInt = 0;
		this.price = new SimpleIntegerProperty(0);
	}
	
	public Integer getID() {
		return ID;
	}

	@Override
	public int getPrice() {
		return priceInt;
	}

	@Override
	public void setPrice(int newPrice) {
		priceInt = newPrice;
		this.price = new SimpleIntegerProperty(priceInt);
	}

	@Override
	public String getDescription() {	
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
		this.desc = new SimpleStringProperty(description);
		
	}
	
}
