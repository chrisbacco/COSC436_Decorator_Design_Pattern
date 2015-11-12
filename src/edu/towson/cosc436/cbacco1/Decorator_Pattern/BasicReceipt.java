package edu.towson.cosc436.cbacco1.Decorator_Pattern;

import edu.towson.cosc436.cbacco1.Interfaces.Iterator;

public class BasicReceipt {
	
	
	private float salesTotalNoTax = 0; 
	private float amount = 0; 
	private float totalTax = 0; 
		
	
	private ItemsPurchased items;
	private TaxComputation StateTax;
	
	public BasicReceipt(ItemsPurchased items){
		this.items = items;
	}
	
    public void create(){
    	salesTotalNoTax = items.getTotal();
    	if(StateTax != null){
    		totalTax = StateTax.computeTax(items);
    	}
    	amount = salesTotalNoTax + totalTax;
    }
    
    public void addTaxMethod(TaxComputation tax){
        StateTax = tax;
    }
    
    public void printReceipt(){
    	
    	if(Client.decorators[0] != null){
    		((GreetingDecember)Client.decorators[0]).printReceipt();
    	}
    	if(Client.decorators[1] != null){
    		((GreetingDecember)Client.decorators[2]).printReceipt();
    	}
        
        /* Iterator for receipt */
    	
    	if(ItemsPurchased.items[0] != null){
        	create();
            Iterator itr = items.getIterator();
    		Item temp = itr.getItem();
    		System.out.printf("\n%-36s", temp.getName());
    		System.out.printf("$%.2f", temp.getPrice());
            while(itr.hasNext()){
        		itr.next();
        		temp = itr.getItem();
        		System.out.printf("\n%-36s", temp.getName());
        		System.out.printf("$%.2f", temp.getPrice());
        	}
        }
    	
    	/* tax and amount */
        System.out.print("\nTax: ");
        System.out.printf("$%.2f", totalTax);
        System.out.print("\nTotal: ");
        System.out.printf("$%.2f", amount);
        
        if(Client.decorators[2] != null){
    		((Coupon100get10Dec)Client.decorators[2]).printReceipt();
    	}
        if(Client.decorators[3] != null){
    		((Coupon200get20Dec)Client.decorators[3]).printReceipt();
    	}
        if(Client.decorators[4] != null){
    		((RebateIpodDec)Client.decorators[4]).printReceipt();
    	}
        if(Client.decorators[5] != null){
    		((RebateHPPrinterDec)Client.decorators[5]).printReceipt();
    	}
    }
}
