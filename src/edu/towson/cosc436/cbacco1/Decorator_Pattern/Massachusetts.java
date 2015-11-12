package edu.towson.cosc436.cbacco1.Decorator_Pattern;

/**
 *
 * @author cbacco1
 */

import java.text.*;

import edu.towson.cosc436.cbacco1.Interfaces.Iterator;



public class Massachusetts extends TaxComputation {

	
	
	@Override
	public float computeTax(ItemsPurchased items) {
		float taxAmount = 0;
		
		if(!taxHoliday()){
			if(ItemsPurchased.items[0] != null){
				Iterator itr1 = items.getIterator();
				Item asdf = itr1.getItem();
				
				taxAmount += (asdf.getPrice())*(.0625);
				
				while(itr1.hasNext()){
					itr1.next();
					asdf = itr1.getItem();
					taxAmount += (asdf.getPrice())*(.0625);
				}
			}
			return taxAmount;
		}
		else{
			return 0;
		}		
	}

	/* Tax Holiday stuff */ 
	/* 08/08 - 08/09 */
	/* are the valid dates for the tax holiday */
	
	@Override
	protected boolean taxHoliday(){
		
		
		DateFormat dF1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String str1 = dF1.format(ReceiptFactory.date);
		
		/* check for chars that are 8, 8, 9 */ 
		/* if found, they qualify */ 
		
		if(str1.charAt(6) == '8' && (str1.charAt(9) == '8' || str1.charAt(9) == '9')){
			return true;
		}
		
		else{
			return false;
		}
	}
}
