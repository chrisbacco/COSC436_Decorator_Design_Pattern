package edu.towson.cosc436.cbacco1.Decorator_Pattern;

/**
 *
 @cbacco1
 */

import java.util.Scanner;

public class Client {
	public static Decorator[] decorators = new Decorator[10];
	private static ItemsPurchased items;
	
	public static void main(String[] args){
		
		/*components of the menu */
		/*items object, boolean, decorator, cin */
		Scanner cin = new Scanner(System.in);
		items = new ItemsPurchased();
		getCurrentDecorators(decorators);
		boolean initialize = true;
		
		/*create menu 1 - new 2 - add 3 - display 4 - terminate */
		while(initialize == true){
			System.out.println("\n");
			System.out.println("*- Decorator Reciept Menu Options -* ");
			System.out.println("**************************************");
			System.out.println("1 -- Begin New Receipt");
			System.out.println("2 -- Add sales items");
			System.out.println("3 -- Display your reciept");
			System.out.println("4 -- Exit the program");
			System.out.println("**************************************");
			System.out.println("\n");
			System.out.print("Enter your selection: ");
			int option = getMenuValue(cin.nextInt());
			
			
			/* Switch Case goes below */ 
			
			
			switch(option){
				case 1 :
					items.clearItems();
					break;

				case 2 : 
					displayItems();
					boolean addItem = true;
					while(addItem){
						
						String choice; 
						
						System.out.print("\n - Please enter the number of the item you wish to purchase: ");
						int item_num = getItemVal(cin.nextInt());
						addItem(item_num);
						System.out.print("\n - Item successfully added.\n");
						System.out.print("\n - Would you like to enter another item? Y or N: ");
						choice = cin.next();
						if(choice.equalsIgnoreCase("y"));
						else{
							addItem = false;
						}
					}
					break;

					/* Case 3: Need a factory here */ 
				case 3 : 
					getCurrentDecorators(decorators);
					ReceiptFactory factory = new ReceiptFactory(items, decorators);
					BasicReceipt receipt = factory.getReceipt();
			        
					System.out.print("\n");
			        //System.out.print("***************************************************************************************");
			        System.out.print("\n");
			        /* prints the store information */
			        
			        factory.printStoreInfo();
					receipt.printReceipt();
					
					System.out.print("\n");
			       // System.out.print("***************************************************************************************");
			        System.out.print("\n");
					break;

				case 4 : /* exit strategy */
					initialize = false;
					break;
			}
		}
		cin.close();
	}

	private static void getCurrentDecorators(Decorator[] decorators) {
		
		/* Decorators for the various receipts */
		/* xmax, summer, coupon codes, rebates */
		
		decorators[0] = new GreetingDecember("*-Happy Holidays from Best Buy-*");
		decorators[1] = new GreetingDecember("*-Summer Sales are Hot at Best Buy-*");
		decorators[2] = new Coupon100get10Dec();
		decorators[3] = new Coupon200get20Dec();
		decorators[4] = new RebateIpodDec();
		decorators[5] = new RebateHPPrinterDec();
		
		for(int i = 6; i < 10; i++){
			decorators[i] = null;
		}
	}
	
	private static int getMenuValue(int val){
		while(val > 4 || val < 1){
			System.out.print("\nInvalid Input, good sir.");
			System.out.print("\nPlease enter alternative option: ");
			Scanner cin = new Scanner(System.in);
			val = cin.nextInt();
		}
		return val;
	}
	
	private static int getItemVal(int val){
		while(val > 9 || val < 1){
			System.out.print("\nInvalid Input, good sir.");
			System.out.print("\nPlease enter alternative option: ");
			Scanner cin = new Scanner(System.in);
			val = cin.nextInt();
		}
		return val;
	}
	
	/* display items */
	/* use .99 for all prices */
	/* format text: left align -- http://stackoverflow.com/questions/15075899/left-aligning-with-printf-in-java */
	/* http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax */
	
	private static void displayItems(){
		System.out.printf("\n%-50s", "1: Apple Ipod Touch 64 GB");
		System.out.print("$299.99");
		System.out.printf("\n%-50s", "2: HP Laser Jet Pro Wireless");
		System.out.print("$135.99");
		System.out.printf("\n%-50s", "3: HP Z Display 34Curved LCD ");
		System.out.print("$849.99");
		System.out.printf("\n%-50s", "4: Samsung Wall Charger");
		System.out.print("29.99");
		System.out.printf("\n%-50s", "5: Monster Black XP Cable");
		System.out.print("$79.99");
		System.out.printf("\n%-50s", "6: Apple Macbook Pro 13 inch ");
		System.out.print("$1299.99");
		System.out.printf("\n%-50s", "7: Apple Macbook Pro 15 inch ");
		System.out.print("$1899.99");
		System.out.printf("\n%-50s", "8: Samsung Galaxy S 16 GB 10.1 inch ");
		System.out.println("$249.99");
		System.out.printf("\n%-50s", "9: Samsung Galaxy Tab 4 8 GB 7 inch ");
		System.out.println("$149.99");
	}
	
	/* add items */ 
	/* implement another switch */ 
	/* items.addItem(new Item("ITEM NAME"), (float)price));
	/* you have to cast a float 
	*/
	
	private static void addItem(int option){
		switch(option){
			
			case 1 :
				items.addItem(new Item("Apple Ipod Touch 64 GB", (float)299.99));
				break;
			
			case 2 :
				items.addItem(new Item("HP Laser Jet Pro Wireless", (float)135.99));
				break;
			
			case 3 :
				items.addItem(new Item(" HP Z Display 34Curved LCD", (float)849.99));
				break;
			
			case 4 :
				items.addItem(new Item("Samsung Wall Charger", (float)29.99));
				break;
			
			case 5 :
				items.addItem(new Item("Monster Black XP Cable", (float)79.99));
				break;
			
			case 6 :
				items.addItem(new Item("Apple Macbook Pro 13 inch ", (float)1299.99));
				break;
			
			case 7 :
				items.addItem(new Item("Apple Macbook Pro 15 inch", (float)1899.99));
				break;
			
			case 8 :
				items.addItem(new Item("Samsung Galaxy S 16 GB 10.1 inch", (float)249.99));
				break;
			
			case 9 :
				items.addItem(new Item("Samsung Galaxy Tab 4 8 GB 7 inch", (float)149.99));
				break;
			
		}
	}
}
