package edu.towson.cosc436.cbacco1.Decorator_Pattern;

public abstract class TaxComputation {
	public abstract float computeTax(ItemsPurchased items);
	protected abstract boolean taxHoliday();
}
