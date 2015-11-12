package edu.towson.cosc436.cbacco1.Decorator_Pattern;

/**
 *
 * @author cbacco11
 */

public class ItemsPurchased {
    public static Item[] items = new Item[100];
     
    
    /* add item */
    /* stackoverflow helped here */
    
    public void addItem(Item i){
    	int x = 0;
        while(items[x] != null){
        	x++;
        }
        items[x] = i;
    }
    
    public boolean hasItem(Item i){
    	int x = 0;
    	//Item i1 = items[x];
    	
    	while(items[x] != null){
        	Item i1 = items[x];
        	
        	
        	if((i1.getName()).equalsIgnoreCase(i.getName()) && (i1.getPrice()) == (i.getPrice())){
        		return true;
        	}
        	x++;
        }
    	return false;
    }
    
    /* ITERATOR */
    
    public ItemsIterator getIterator(){
    	return new ItemsIterator();
    }
    
    /* accumulating total needs to be kept */
    
    public float getTotal(){
    	float accumulatingTotal = 0;
    	
    	int z = 0;
    	
    	while(items[z] != null){
        	Item i = items[z];
        	accumulatingTotal += i.getPrice();
        	z++;
        }
    	return accumulatingTotal;
    }
    
    public void clearItems(){
    	for(int i = 0; i < items.length; i++){
    		items[i] = null;
    	}
    }
}
