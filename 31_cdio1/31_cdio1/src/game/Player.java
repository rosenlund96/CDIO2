package game;
/************************************************************
 * Player.java												*
 * 															*
 * Data entity class holding data related to the dice game	*
 ***********************************************************/
public class Player {
	
	private String name;
	private int score;
	
	// Constructors
	
	/********************************************************
	 * initializes a Player object with a specified name	*
	 * @param name to initialize player with				*
	 *******************************************************/
	public Player(String name){
		this.name = name;
		this.score = 0;
	}
	
	
	// Mutators
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	

	/********************************************************
	 * @param deltaScore - increases score by deltaScore	*	
	 * can only be positive increase						*
	 *******************************************************/	
	public void increaseScore(int deltaScore){
		if(deltaScore >= 0)
			score += deltaScore;
	}
	
	/****************************
	 * reset score to zero		*
	 ***************************/
	public void resetScore(){
		score = 0;
	}
	
	
	public int getScore(){
		return score;
	}
	
}
