package edu.towson.cosc436.cbacco1.Decorator_Pattern;

import edu.towson.cosc436.cbacco1.Interfaces.Applicable;

public class RebateIpodDec extends Decorator implements Applicable{
	public boolean applies(ItemsPurchased items){
		
		
		if(items.hasItem(new Item("Apple Ipod Touch 64 GB", (float)300.00))){
        	return true;
        }
        
		return false;
    }
    
	public void printReceipt(){
		System.out.print("******************************");
		System.out.println("Mail-in rebate for $50 on your 'Apple Ipod Touch 64 GB'!\n");
	}
}
