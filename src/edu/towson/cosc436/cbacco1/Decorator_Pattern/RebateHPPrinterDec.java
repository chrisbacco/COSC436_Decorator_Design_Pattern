package edu.towson.cosc436.cbacco1.Decorator_Pattern;

import edu.towson.cosc436.cbacco1.Interfaces.Applicable;

public class RebateHPPrinterDec extends Decorator implements Applicable{
	public boolean applies(ItemsPurchased items){
        
		
		if(items.hasItem(new Item("HP Laser Jet Pro Wireless", (float)135.99))){
        	return true;
        }
        
		
		return false;
    }
    
	public void printReceipt(){
		
		System.out.print("******************************");
		System.out.println("Mail-in rebate available for $45 on your HP Laser Jet Pro Wireless!\n");		
	}
}
