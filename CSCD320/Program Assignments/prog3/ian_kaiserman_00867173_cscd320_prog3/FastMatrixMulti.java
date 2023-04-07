// Author: Ian Kaiserman

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FastMatrixMulti {
	
	// Initialize 2D arrays m and s for tracking optimal subchain time cost and outmost parentheses respectively
	static int[][] m;
	static int[][] s;
	
	// Primary function for finding the chain order
	private static int matrixChainOrder(int[] dims, int n) {
		for(int l = 2; l <= n; l++) { // iterate through subchain lengths
			for(int i = 0; i <= n - l; i++) { // iterate through subchain START positions
				int j = i + l - 1; // END position for this subchain
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i; k <= j-1; k++) { // Try other parentheses locations in this subchain
					int q = m[i][k] + m[k+1][j] + dims[i]*dims[k+1]*dims[j+1]; // Calculate time cost
					if(q < m[i][j]) {
						m[i][j] = q; // Store time cost if smaller than current value
						s[i][j] = k; // Store parentheses position 
					}
				}
			}
		}
		return m[0][n-1]; // return top right value of time cost array, which is effectively the total optimal time cost once loops are done
	}
	
	// Function for printing parentheses order
	// Uses values saved in the s array to find where parentheses and matrices need to be placed
	private static void printOptimalParens(int i, int j) {
		if(i == j) System.out.printf("A%s", i+1); // Print matrix ID if matching value in s found
		else {
			System.out.print("(");
			printOptimalParens(i, s[i][j]); // Find parentheses placement from i to the value in s
			printOptimalParens(s[i][j]+1, j); // Find parentheses placement from the value in s + 1 to j
			System.out.print(")");
		}
	}
	
	// Main function
	public static void main(String[] args) {
		// File reading, array initialization, etc.
		File input = new File(args[0]);
		Scanner lines = null;
		Scanner fscan = null;
		int count = 0;
		try {
			fscan = new Scanner(input);
			lines = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(lines.hasNextInt()) {
			count++;
			lines.nextInt();
		}
		int[] dims = new int[count];
		for(int i = 0; i < dims.length; i++) {
			dims[i] = fscan.nextInt();
		}

		// Initialize m and s with square size of number of matrices
		m = new int[dims.length-1][dims.length-1];
		s = new int[dims.length-1][dims.length-1];
		// Function call to find the optimal chain order
		int cost = matrixChainOrder(dims, dims.length - 1);
        // Initial call gives the starting and ending indices of the s array for printing the order
		printOptimalParens(0, dims.length - 2);
		// Print the cost
		System.out.printf("%n" + cost);
	}


}
