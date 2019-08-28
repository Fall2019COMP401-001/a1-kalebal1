package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Store Inventory
		
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
			
			// System.out.println("item: " + items[i] + " price: " + prices[i]);
		}
		
		
	
		//		Customer Info
		
		int customerCount = scan.nextInt();
		String[] firstNames = new String[customerCount];
		String[] lastNames = new String[customerCount];
		int[] itemsBought = new int[customerCount];
		double[] customerTotal = new double[customerCount];
		
		
		for(int i = 0; i < customerCount; i++) {
			firstNames[i] = scan.next();
			
			lastNames[i] = scan.next();
		
			itemsBought[i] = scan.nextInt();
	
			for (int j = 0; j < itemsBought[i]; j++) {
			
				int quan = scan.nextInt();
				
				String name = scan.next();
				customerTotal[i] += findItemTotal(quan, findPlace(name, items), prices);
				
			}
			
		}
		
		int biggest = findTotalMax(customerTotal);
		String big = String.format("%.2f", customerTotal[biggest]);
		
		int smallest = findTotalMin(customerTotal);
		String small = String.format("%.2f", customerTotal[smallest]);
		
		double avg = calculateAverage(customerTotal);
		String avgSt = String.format("%.2f", avg);
		
		
		System.out.println("Biggest: " + firstNames[biggest] + lastNames[biggest] + big);
		System.out.println("Smallest: " + firstNames[smallest] + lastNames[smallest] + small);
		System.out.println("Average: " + avgSt);
		
		
		
		/* 	output:
		 *	Biggest: FIRST LAST (Amount)
		 *	Smallest: FIRST LAST (Amount)
		 *	Average: FIRST LAST (Amount)
		 */
		
		
		
		scan.close();
	}
	
	/*
	 *  input: name of purchased item and the store inventory
	 *  output: location of item that corresponds to price
	 *  preconditions: requires matching item in inventory
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
	 * input: quantity of items purchased, their location in inventory arrays, array of prices
	 * output: calculated total cost of items purchased
	 */
	
	static double findItemTotal(int quan, int place, double[] prices) {
		double total = 0;
		double price = prices[place];
		total = price * quan;
		return total;
	}
	
	
	/*
	 * input: array of customer's total purchases
	 * output: location of least total, which corresponds to name
	 */
	
	static int findTotalMax(double[] totals) {
		int curMax = 0;
		// starts on second value and compares to current
		for (int i = 1; i < totals.length; i++) {
			if(totals[i] > curMax) {
				curMax = i;
			}
		}
		return curMax;
	}
	
	static int findTotalMin(double[] totals) {
		int curMin = 0;
		
		for (int i = 1; i < totals.length; i++) {
			if(totals[i] < curMin) {
				curMin = i;
			}
		}
		return curMin;
	}
	
	/*
	 * adds up all values in totals array
	 * 
	 */
	
	static double calculateTotalSum (double[] totals) {
		double sum = 0;
		for (int i = 0; i < totals.length; i++) {
			sum += totals[i];
		}
		return sum;
	}
	
	/*
	 * takes in totals array
	 * sends to calculateTotalSum
	 * divides by length of array to find average
	 */
	
	static double calculateAverage (double[] totals) {
		double avg = 0;
		avg = calculateTotalSum(totals) / totals.length;
		return avg;
	}
	
	

	}

