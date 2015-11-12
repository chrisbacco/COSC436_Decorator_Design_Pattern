package edu.towson.cosc436.cbacco1.Decorator_Pattern;

import edu.towson.cosc436.cbacco1.Interfaces.Iterator;

public class ItemsIterator implements Iterator{
	
	private int current = 0;
	
	public boolean hasNext(){
		
		if(ItemsPurchased.items[current + 1] == null){
			return false;
		}
	
		else return true;
	}
	
	public Item getItem(){
		return ItemsPurchased.items[current];
	}
	
	
	public void next(){
		current++;
	}
}
