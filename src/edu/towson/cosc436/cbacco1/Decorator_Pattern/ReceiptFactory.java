package edu.towson.cosc436.cbacco1.Decorator_Pattern;

/**
 *
 * @author cbacco1
 */

import java.util.Date;
import java.io.*;
import java.util.*;

/* receipt factory */
/* date to print out date/time */ 
/* need: store number, store addr, store phone, state code for tax calculations */ 

public class ReceiptFactory {
	
	
	/* Purchased Items, Decorator, basic receipt and a DATE OBJECT */ 
	
	private ItemsPurchased items;
	private Decorator[] decorators;
	private BasicReceipt receipt;
	
	/* Use this link for date() later: 
	/* http://docs.oracle.com/javase/7/docs/api/java/util/Date.html
	*/
	public static Date date = new Date();   
	
	/* The Strings for creating the store info */ 
	private String storeNum = ""; 		
	private String storeAddr = ""; 			
	private String storePhone = ""; 		
	private String stateCode = ""; 			
	
	
	/* pull from config file */
	
	public ReceiptFactory(ItemsPurchased items, Decorator[] decorators){
		this.items = items;
		this.decorators = decorators;
		readConfigFile();
		
		receipt = new BasicReceipt(this.items);
		addTaxComputation(stateCode);
		addDecorators();
	}
	
	public BasicReceipt getReceipt(){
		return receipt;
	}
	
	/*equalsIgnoreCase (state) */
	
	public void addTaxComputation(String location){
		if(location.equalsIgnoreCase("MD")){
			receipt.addTaxMethod(new Maryland());
		}
		
		else if(location.equalsIgnoreCase("MA")){
			receipt.addTaxMethod(new Massachusetts());
		}
		
		else if(location.equalsIgnoreCase("CA")){
			receipt.addTaxMethod(new California());
		}
		
		else if(location.equalsIgnoreCase("DE")){
			receipt.addTaxMethod(new Delaware());
		}
	}
	
	private void addDecorators(){
		for(int i = 0; i < decorators.length; i++){
			
			if(decorators[i] != null){
				if(!decorators[i].applies(items)){
					decorators[i] = null;
				}
			}
			else{
				break;
			}
		}
	}
	
	public void printStoreInfo(){
        System.out.print(date + "\n");
		System.out.println("Best Buy " + storeNum);
		System.out.println(storeAddr);
		System.out.println(storePhone);
	}
	
	
	/* Read from config file */
	/* Random number generator and file set */ 
	
	public void readConfigFile(){
		
		try{
            /* scanner and random object */
			
			Scanner buffer;
            Random rand = new Random();
                    
            int randomNumber = rand.nextInt(4);
            
            /* JRE System Library */
            /* https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html */
            /* reference for getProperty() and user.dir stuff */
            /* System.getProperty("user.dir") user local directory*/
            
            
            if(randomNumber == 0){
            	buffer = new Scanner(new File(System.getProperty("user.dir") + "/" + "config1"));
            }
            
            else if(randomNumber == 1){
            	buffer = new Scanner(new File(System.getProperty("user.dir") + "/" + "config2"));
            }
            
            else if(randomNumber == 2){
            	buffer = new Scanner(new File(System.getProperty("user.dir") + "/" + "config3"));
            }
            
            else{
            	buffer = new Scanner(new File(System.getProperty("user.dir") + "/" + "config4"));
            }
            
            
            storeNum = buffer.nextLine();
            storeAddr = buffer.nextLine();
            storePhone = buffer.nextLine();
            stateCode = buffer.nextLine();
            buffer.close();
        }
		
		/*Don't forget the Exception */ 
		
        catch(IOException i){
            System.out.println("Error: " + i.getMessage());
        }
	}
}