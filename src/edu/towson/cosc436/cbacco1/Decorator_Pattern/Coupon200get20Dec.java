package edu.towson.cosc436.cbacco1.Decorator_Pattern;

import edu.towson.cosc436.cbacco1.Interfaces.Applicable;

public class Coupon200get20Dec extends Decorator implements Applicable{
	
	public boolean applies(ItemsPurchased items){
        
		if(items.getTotal() >= (float)200){
        	return true;
        }
        
		return false;
    }
    
    public void printReceipt(){
       
    	/* Coupon add on to receipt */
    	
    	System.out.println("\nCongratulations! You spent over $200!");
        System.out.println("Bring this receipt in as a coupon for 20% off your next purchase!");
        System.out.println("Valid for a limited time only");
        System.out.println("\n");
       
    
    }
}
