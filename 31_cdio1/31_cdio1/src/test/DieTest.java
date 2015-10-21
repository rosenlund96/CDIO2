package test;

import java.text.NumberFormat;

import game.util.Die;

public class DieTest {

	public static void main(String[] args) {

		// Pre Conditions
		// Initialise a new Die Object
		Die die = new Die();
		
		
		// Test
		// Rolling die 1000 times and recording the facevalues
		
		final int NUMBER_OF_ROLLS = 1000;
		
		// for storing rolls;
		int results[] = new int[6];
		
		for(int i = 0; i < NUMBER_OF_ROLLS; i++){
			byte faceValue = die.roll();
			results[faceValue-1]++;
		}
		
		
		// PostConditions
		// percent of each faceValue should be 16.66 percent (rounded to 17%)b
		NumberFormat percentFmt = NumberFormat.getPercentInstance();
		System.out.println("Number of ones: " + results[0] + " \tpercentage: " + percentFmt.format((float)results[0]/NUMBER_OF_ROLLS));
		System.out.println("Number of twos: " + results[1] + " \tpercentage: " + percentFmt.format((float)results[1]/NUMBER_OF_ROLLS));
		System.out.println("Number of threes: " + results[2] + " \tpercentage: " + percentFmt.format((float)results[2]/NUMBER_OF_ROLLS));
		System.out.println("Number of fours: " + results[3] + " \tpercentage: " + percentFmt.format((float)results[3]/NUMBER_OF_ROLLS));
		System.out.println("Number of fives: " + results[4] + " \tpercentage: " + percentFmt.format((float)results[4]/NUMBER_OF_ROLLS));
		System.out.println("Number of sixes: " + results[5] + " \tpercentage: " + percentFmt.format((float)results[5]/NUMBER_OF_ROLLS));

	}

}
