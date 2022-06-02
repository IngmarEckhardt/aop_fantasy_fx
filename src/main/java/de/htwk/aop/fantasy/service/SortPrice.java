package de.htwk.aop.fantasy.service;
import java.util.Comparator;

import de.htwk.aop.fantasy.service.items.Item;

public class SortPrice implements Comparator<Item> {
	
	    @Override
	    public int compare(final Item a1, final Item a2) {
	        return a1.getPrice()-a2.getPrice();
	    }		
	}