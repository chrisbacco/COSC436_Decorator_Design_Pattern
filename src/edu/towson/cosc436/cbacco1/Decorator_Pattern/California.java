package edu.towson.cosc436.cbacco1.Decorator_Pattern;

import edu.towson.cosc436.cbacco1.Interfaces.Iterator;

/**
 *
 * @author cbacco1
 */


public class California extends TaxComputation {

	@Override
	public float computeTax(ItemsPurchased items) {
		
		float tax = 0;
		
		
		if(!taxHoliday()){
			if(ItemsPurchased.items[0] != null){
				Iterator itr1 = items.getIterator();
				Item i1 = itr1.getItem();
				tax += (i1.getPrice())*(.075);
				while(itr1.hasNext()){
					itr1.next();
					i1 = itr1.getItem();
					
					tax += (i1.getPrice())*(.075);
				}
			}
			return tax;
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
