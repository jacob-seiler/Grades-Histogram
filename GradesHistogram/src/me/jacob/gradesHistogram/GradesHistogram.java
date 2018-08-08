package me.jacob.gradesHistogram;

import java.util.Scanner;

/*
 * Name: Jacob Seiler
 * Teacher: Mrs. Costin
 * Course: ICS4U
 * Date: 9/20/2017
 */
public class GradesHistogram {

	private static int[] grades; // Array to store the grades.

	private static int[] bins; // Array to store grade ranges

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		readGrades(); // Run the readGrades method.
		computeHistogram(); // Run the computeHistogram method.
		printHistogramHorizontal(); // Run the printHistogramHorizontal method.
		printHistogramVertical(); // Run the printHistogramVertical method.
	}

	/**
	 * Reads the grades from the user input.
	 */
	private static void readGrades() {
		Scanner input = new Scanner(System.in); // Initialize the scanner.
		System.out.print("How many grades will you enter? \t"); // Ask the user how many grades they will enter.

		grades = new int[input.nextInt()]; // Initialize the grades array.

		// Loop until the grades array is full.
		for (int i = 0; i < grades.length; i++) {
			System.out.print("Enter a mark: \t"); // Ask the user to input a mark.
			int mark = input.nextInt(); // Store the inputed value.

			// Check if mark is not valid.
			while (mark < 0 || mark > 100) {
				System.out.println("That is not in the range of 0 - 100"); // Tell the user the mark is invalid.
				System.out.print("Enter a correct mark: \t"); // Ask the user for a new input.
				mark = input.nextInt(); // Store the new value and continue.
			}

			grades[i] = mark; // Set the current index of the grades array to the valid inputed mark.
		}

		input.close(); // Close the scanner.
	}

	/**
	 * Computes the histogram values.
	 */
	private static void computeHistogram() {
		bins = new int[10]; // Initialize the bins array.

		// Loop for every grade in the grades array.
		for (int m : grades) {
			if (m >= 0 && m <= 9) // If the grade is between 0 and 9.
				bins[0]++; // Store value in bin array.
			else if (m >= 10 && m <= 19) // If the grade is between 10 and 19.
				bins[1]++; // Store value in bin array.
			else if (m >= 20 && m <= 29) // If the grade is between 20 and 29.
				bins[2]++; // Store value in bin array.
			else if (m >= 30 && m <= 39) // If the grade is between 30 and 39.
				bins[3]++; // Store value in bin array.
			else if (m >= 40 && m <= 49) // If the grade is between 40 and 49.
				bins[4]++; // Store value in bin array.
			else if (m >= 50 && m <= 59) // If the grade is between 50 and 59.
				bins[5]++; // Store value in bin array.
			else if (m >= 60 && m <= 69) // If the grade is between 60 and 69.
				bins[6]++; // Store value in bin array.
			else if (m >= 70 && m <= 79) // If the grade is between 70 and 79.
				bins[7]++; // Store value in bin array.
			else if (m >= 80 && m <= 89) // If the grade is between 80 and 89.
				bins[8]++; // Store value in bin array.
			else if (m >= 90 && m <= 100) // If the grade is between 90 and 100.
				bins[9]++; // Store value in bin array.
		}
	}

	/**
	 * Prints the histogram horizontally.
	 */
	private static void printHistogramHorizontal() {
		// Find the largest value in the bins array.
		int max = bins[0]; // Initialize the max value as the first value in the bins array.

		// Loop through every value in the bins array.
		for (int i = 1; i < bins.length; i++)
			if (bins[i] > max) // If the value being checked is larger than the value of 'max'.
				max = bins[i]; // Set the value to 'max' to the current index of the bins array.

		// Loop 'max' times.
		for (int i = max; i > 0; i--) {
			// Loop through the bins array.
			for (int b = 0; b < bins.length; b++) {
				// If the value being checked is large enough to display on the current row.
				if (bins[b] >= i) {
					System.out.print("*"); // Print "*".
				}
				System.out.print("\t"); // Skip this column.
			}

			System.out.println(""); // Go to the next row.
		}

		System.out.println("0-9\t10-19\t20-29\t30-39\t40-49\t50-59\t60-69\t70-79\t80-89\t90-100"); // Print the values being displayed at the bottom.
	}

	/**
	 * Prints the histogram vertically.
	 */
	private static void printHistogramVertical() {
		System.out.println("0 - 9: " + getBinAmountVertical(0)); // Prints values from 0 - 9.
		System.out.println("10 - 19: " + getBinAmountVertical(1)); // Prints values from 10 - 19.
		System.out.println("20 - 29: " + getBinAmountVertical(2)); // Prints values from 20 - 29.
		System.out.println("30 - 39: " + getBinAmountVertical(3)); // Prints values from 30 - 39.
		System.out.println("40 - 49: " + getBinAmountVertical(4)); // Prints values from 40 - 49.
		System.out.println("50 - 59: " + getBinAmountVertical(5)); // Prints values from 50 - 59.
		System.out.println("60 - 69: " + getBinAmountVertical(6)); // Prints values from 60 - 69.
		System.out.println("70 - 79: " + getBinAmountVertical(7)); // Prints values from 70 - 79.
		System.out.println("80 - 89: " + getBinAmountVertical(8)); // Prints values from 80 - 89.
		System.out.println("90 -100: " + getBinAmountVertical(9)); // Prints values from 90 - 100.
	}

	/**
	 * Gets the amount of marks stored in the bins at the desired index.
	 *
	 * @param bin the bins index to check
	 * @return the amount stored in the bins index as a string
	 */
	private static String getBinAmountVertical(int bin) {
		String value = ""; // Initialize the string 'value'.

		int amount = bins[bin]; // Loop the value that bins of 'bin' index contains. (ex. if it is 3, loop 3 times).
		while (amount > 0) {
			value = value + "*"; // Add a "*" to the string 'value'.
			amount--; // Deminish the sentinal value.
		}

		return value; // Return the string 'value'.
	}

}
