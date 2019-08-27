package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		
		String[] firstNames = new String[count];
		
		String[] lastNames = new String[count];
		
		int[] itemsEach = new int[count];
		
		double[] customerTotals = new double[count];
		
		String[] customerTotalsString = new String[count];
		
		// inputs first name, last name, items into separate arrays based on count
		
		for(int i = 0; i < count; i++) {
			
			firstNames[i] = scan.next();
			
			lastNames[i] = scan.next();
			
			itemsEach[i] = scan.nextInt();
			
			// for loop to calculate customers totals based on itemsEach
			
			for(int j = 0; j < itemsEach[i]; j++) {
				
				int quantity = scan.nextInt();
				
				String item = scan.next(); // skips over item name
				
				double price = scan.nextDouble();
				
				customerTotals[i] += quantity * price;
				
			}
			customerTotalsString[i] = String.format("%.2f", customerTotals[i]);
			
			// prints formatted names and totals 
			
			System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " + customerTotalsString[i]);
		}
		
		
		
		

	
		scan.close();
	}
}
