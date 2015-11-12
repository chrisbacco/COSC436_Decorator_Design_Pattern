package edu.towson.cosc436.cbacco1.Interfaces;

import edu.towson.cosc436.cbacco1.Decorator_Pattern.Item;

public interface Iterator {
	public boolean hasNext();
	public Item getItem();
	public void next();
}
