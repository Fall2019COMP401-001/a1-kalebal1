package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// https://github.com/Fall2019COMP401-001/a1-kalebal1.git
		/*
		 * output report NUMBER customers bought NUMBER ITEM  ((ex 2 customers bought 5 Banana))
		 * reported in the same order as specified in the beginning of the input
		 * if no customers bought, output == No customers bought ITEM
		 */
		
		int countItm = scan.nextInt();
		
		String[] items = new String[countItm];
		double[] prices = new double[countItm];
		

		
		/* 
		 * for each item in the store...
		 * creates inventory of names with corresponding prices in separate arrays
	    */ 
		
		for(int i = 0; i < items.length; i++) {
			items[i] = scan.next();
			prices[i] = scan.nextDouble();
			
		}
		
//		Customer Info
		
		int customerCount = scan.nextInt();
		
		// 2D array, a column for every item and a row for each customer
		int [][] itemsBought = new int [items.length][customerCount];
		String[] firstNames = new String[customerCount];
		String[] lastNames = new String[customerCount];
		int [] customerItemCount = new int[items.length];
	
		for (int i = 0; i < customerCount; i++) {
			
			// adds names to separate arrays 
			firstNames[i] = scan.next();
		
			lastNames[i] = scan.next();
			
			//creates counter for number of different items customer bought
			int cItems = scan.nextInt();
		
			
			// loops through number of customer items 
			for(int j = 0; j < cItems; j++) {
				int localQuan = scan.nextInt();
				String itemName = scan.next();
				
				
				itemsBought [findPlace(itemName, items)][i] += localQuan;
				
				customerItemCount[findPlace(itemName, items)] += localQuan;
				
				
			}
		}
			
			
		int[] itmBCust = new int[items.length];
		quanCust(itemsBought, customerCount, items.length, itmBCust);
		int[] quanBItem = new int[items.length];
		totalBought(itemsBought, customerCount, items.length, quanBItem);
		for(int i = 0; i < items.length; i++) {
			if(itmBCust[i] == 0) {
				System.out.println("No customers bought " + items[i]);
			} else {
				System.out.println(itmBCust[i] + " customers bought " + quanBItem[i] + " " + items[i]);
			}
		}


		
		
		
		scan.close();
	}
	/*
	 * input: item name
	 * output: place of matching item in inventory
	 */
	
	static int findPlace(String name, String[] items) {
		int place = 0;
		for (int i = 0; i < items.length; i++) {
			if(items[i].contentEquals(name)) {
				place = i;
				return place;
			}
		}
		return place;
	}
	
	/* 
	 * calculates number of customers that bought an item
	 * input: 2D array of itemsxcustomers, number of customers, number of items in inventory, and an output array
	 * 
	 */
	static int[] quanCust(int[][] arr, int customerCount, int numItems, int[] input) {
		
		int[] total = input;
		
		for(int j = 0; j < customerCount; j++) {
			
			for ( int i = 0; i < numItems; i++) {
				int c = arr[i][j];
				if( c > 0) {
					total[i] ++;
				}
			
			}	
		
		}
		return total;
	}
	
	/*
	 * calculates total quantity of an item bought across all customers
	 * 
	 */
	
	static int[] totalBought(int[][] arr, int customerCount, int numItems, int[] input) {
		int [] total = input;
		for(int j = 0; j < customerCount; j++) {
			for (int i = 0; i < numItems; i++) {
				int c = arr[i][j];
				total[i] += c;
			}
		}
		return total;
}
}
	
		