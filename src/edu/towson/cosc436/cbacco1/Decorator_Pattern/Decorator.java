package edu.towson.cosc436.cbacco1.Decorator_Pattern;

import edu.towson.cosc436.cbacco1.Interfaces.Applicable;
/* class room stuff posted on BB */ 
/* basic receipt trailer */ 

abstract class Decorator implements Applicable{
    private BasicReceipt trailer;
    
    public void create(BasicReceipt receipt){
        trailer = receipt;
    }
    
    
    public void callTrailer(){
        trailer.printReceipt();
    }
    
    public boolean applies(ItemsPurchased items){
    	return false;
    }
}
