package edu.towson.cosc436.cbacco1.Decorator_Pattern;

/**
 *
 * @author cbacco1
 */

import java.text.*;

import edu.towson.cosc436.cbacco1.Interfaces.Applicable;

public class GreetingDecember extends Decorator implements Applicable{
	private String sGreet;
		
	public GreetingDecember(String greet){
		this.sGreet = greet;
	}
	
	public boolean applies(ItemsPurchased items){
		
		/* date formatting */
		/* "year/m/d hh mm ss */
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String strDate = dateFormat.format(ReceiptFactory.date);

		/* Important Dates: 12/1 - 12/31 */
		/* June - August */
		
		if(sGreet.equalsIgnoreCase("Happy Holidays from Best Buy")){
			
			if((strDate.charAt(5) == '1') && (strDate.charAt(6) == '2')){
				return true;
			}
		}
		else if(sGreet.equalsIgnoreCase("Summer Sales are Hot at Best Buy")){
			
			/* char == 6 or 7 or 8 */
			
			if(strDate.charAt(6) == '6' || strDate.charAt(6) == '7' || strDate.charAt(6) == '8'){
				return true;
			}			
		}
		return false;
    }
	
    public void printReceipt(){
        System.out.println("\n" + sGreet);
        
    }
}
