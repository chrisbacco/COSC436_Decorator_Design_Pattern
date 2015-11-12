package edu.towson.cosc436.cbacco1.Decorator_Pattern;

import edu.towson.cosc436.cbacco1.Interfaces.Applicable;

public class Coupon100get10Dec extends Decorator implements Applicable{
	
	
	public boolean applies(ItemsPurchased items){
		
		if(items.getTotal() >= (float)200){
        	return false;
        }
		
		else if(items.getTotal() >= (float)100){
        	return false;
        }
        
		return false;
    }
    
    public void printReceipt(){
    	
    	/* Coupon add on to receipt */
    	
        System.out.println("\nCongratulations! You spent over $100!");
        System.out.println("Bring this receipt in as a coupon for 10% off your next purchase!");
        System.out.println("Valid for a limited time only");
        System.out.println("\n");
        		
    }
}
