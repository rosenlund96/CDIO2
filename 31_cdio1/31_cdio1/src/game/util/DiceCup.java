package game.util;

/********************************************
 *  Simulates the function of a dice cup	*
 *  containing 2 dice.						*
 *******************************************/
public class DiceCup {

	private Die die1, die2;


	// Constructors

	/************************************************	
	 * Initializes a new diecup containing 2 dice.	*
	 ***********************************************/
	public DiceCup(){
		die1 = new Die();
		die2 = new Die();
	}

	// Mutators

	/********************************
	 * @return faceValue of die1	*
	 *******************************/
	public byte getDie1(){
		return die1.getFaceValue();
	}

	/********************************
	 * @return faceValue of die2	*
	 *******************************/
	public byte getDie2(){
		return die2.getFaceValue();
	}
	// Service methods

	/************************************************
	 * roll dice and returning the sum				*
	 * @return sum of dice rolled					*
	 ***********************************************/
	public int roll(){
		return die1.roll() + die2.roll();
	}

	/************************************
	 * @return the sum of the two dice	*
	 ***********************************/
	public int getSum(){
		return die1.getFaceValue() + die2.getFaceValue();
	}

	/****************************************************
	 * Return a byte depending on whether the dice are	*
	 * equal or not										*
	 * @return 0: if the two dice are not equal.		*
	 * if doubles it returns the number corresponding 	*
	 * to the facevalue of the doubles					*					
	 ***************************************************/
	public byte isDoubles(){

		if(die1.getFaceValue() == die2.getFaceValue()){
			// returns 1,2,3,4,5 or 6 depending on the type of doubles
			return die1.getFaceValue();
		}else{
			// returns 0 if not doubles
			return 0;	
		}
	}
}
