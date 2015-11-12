package edu.towson.cosc436.cbacco1.Decorator_Pattern;

/**
 *	DE Has No tax
 * @author cbacco1
 */

public class Delaware extends TaxComputation {

	
	@Override
	public float computeTax(ItemsPurchased items) {
		return 0;
	}
	
	@Override
	protected boolean taxHoliday(){
		return true;
	}
}
