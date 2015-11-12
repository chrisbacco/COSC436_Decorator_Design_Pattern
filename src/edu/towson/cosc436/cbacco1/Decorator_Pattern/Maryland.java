package edu.towson.cosc436.cbacco1.Decorator_Pattern;

import edu.towson.cosc436.cbacco1.Interfaces.Iterator;

/**
 *
 * @author cbacco1
 */

public class Maryland extends TaxComputation {

	/* There is no special tax holiday in MD
	/* for electronics. This is for BB, so there is no
	/* tax holiday to worry about - use overrides
	*/

	
	
	@Override
	public float computeTax(ItemsPurchased items){
		float taxAmount = 0;
		
		if(!taxHoliday()){
			if(ItemsPurchased.items[0] != null){
				/* asdf is the name of the item b/c i'm too tired to create something better */
				
				Iterator itr1 = items.getIterator();
				Item asdf = itr1.getItem();
				
				//add to total 
				taxAmount +=  (asdf.getPrice())*(.06);
				
				while(itr1.hasNext()){
					itr1.next();
					asdf = itr1.getItem();
					taxAmount += (asdf.getPrice())*(.06);
				}
			}
			return taxAmount;
		}
		else{
			return 0;
		}
	}
	
	@Override
	protected boolean taxHoliday(){
		return false;
	}
}
