package edu.towson.cosc436.cbacco1.Decorator_Pattern;

/**
 *
 * @author cbacco1
 */

/* Item Class -- similar to the menu item class used last time */

public class Item {
    private String itemName;
    private float price;
    
    public Item(String name, float price){
    	this.itemName = name;
    	this.price = price;
    }
    
    public String getName(){
        return itemName;
    }
    
    public float getPrice(){
        return price;
    }
}
