package test;

import java.text.NumberFormat;
import game.util.DiceCup;

/********************************************************
 * Testing the occurrences of each sum in 2 dice.			*
 * testing the occurrences of doubles. and each of them	*
 *******************************************************/
public class DiceCupTest {

	public static void main(String[] args) {

		NumberFormat percentFmt = NumberFormat.getPercentInstance();
		// number of rolls made in the test
		final int NUMBER_OF_ROLLS = 1000;

		// stores number of each sum rolled
		int numbers[] = new int[12];

		// stores number of each kind of doubles rolled and number of times no doubles rolled
		int doubles[] = new int[7];


		// Preconditions
		// initializing a new DiceCup
		DiceCup cup = new DiceCup();

		// Test
		for(int i = 0; i < NUMBER_OF_ROLLS; i++){
			int sum = cup.roll();

			numbers[sum-1]++;
			doubles[cup.isDoubles()]++;			
		}


		// PostConditions
		// show number of each case.
		System.out.println("Number of ones: " + numbers[0] + "\tpercentage " + percentFmt.format((float)numbers[0]/NUMBER_OF_ROLLS));
		System.out.println("Number of twos: " + numbers[1] + "\tpercentage " + percentFmt.format((float)numbers[1]/NUMBER_OF_ROLLS));
		System.out.println("Number of threes: " + numbers[2] + "\tpercentage " + percentFmt.format((float)numbers[2]/NUMBER_OF_ROLLS));
		System.out.println("Number of fours: " + numbers[3] + "\tpercentage " + percentFmt.format((float)numbers[3]/NUMBER_OF_ROLLS));
		System.out.println("Number of fives: " + numbers[4] + "\tpercentage " + percentFmt.format((float)numbers[4]/NUMBER_OF_ROLLS));
		System.out.println("Number of sixes: " + numbers[5] + "\tpercentage " + percentFmt.format((float)numbers[5]/NUMBER_OF_ROLLS));
		System.out.println("Number of sevens: " + numbers[6] + "\tpercentage " + percentFmt.format((float)numbers[6]/NUMBER_OF_ROLLS));
		System.out.println("Number of eights: " + numbers[7] + "\tpercentage " + percentFmt.format((float)numbers[7]/NUMBER_OF_ROLLS));
		System.out.println("Number of nines: " + numbers[8] + "\tpercentage " + percentFmt.format((float)numbers[8]/NUMBER_OF_ROLLS));
		System.out.println("Number of tens: " + numbers[9] + "\tpercentage " + percentFmt.format((float)numbers[9]/NUMBER_OF_ROLLS));
		System.out.println("Number of elevens: " + numbers[10] + "\tpercentage " + percentFmt.format((float)numbers[10]/NUMBER_OF_ROLLS));
		System.out.println("Number of twelves: " + numbers[11] + "\tpercentage " + percentFmt.format((float)numbers[11]/NUMBER_OF_ROLLS));

		// doubles 1/6 of the time appr. 16.6 percent of the times
		int numberOfDoubles = 0;
		for(int i = 1; i < doubles.length; i++){
			numberOfDoubles += doubles[i];
		}
		System.out.println();
		System.out.println("number of doubles: " + numberOfDoubles + "\tPercentage: " + percentFmt.format((float)numberOfDoubles/NUMBER_OF_ROLLS));


		// number of each double should be equal for each
		System.out.println();
		System.out.println("Number of double ones: " + doubles[1] + "\tPercentage: " + percentFmt.format((float)doubles[1]/numberOfDoubles));
		System.out.println("Number of double twos: " + doubles[2] + "\tPercentage: " + percentFmt.format((float)doubles[2]/numberOfDoubles));
		System.out.println("Number of double threes: " + doubles[3] + "\tPercentage: " + percentFmt.format((float)doubles[3]/numberOfDoubles));
		System.out.println("Number of double fours: " + doubles[4] + "\tPercentage: " + percentFmt.format((float)doubles[4]/numberOfDoubles));
		System.out.println("Number of double fives: " + doubles[5] + "\tPercentage: " + percentFmt.format((float)doubles[5]/numberOfDoubles));
		System.out.println("Number of double sixes: " + doubles[6] + "\tPercentage: " + percentFmt.format((float)doubles[6]/numberOfDoubles));
	}

}
