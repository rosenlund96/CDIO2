package game;

public class GameBoard {
	public static final int PLAYER_1 = 1;
	public static final int PLAYER_2 = 2;


	private Player player1, player2;
	private Player activePlayer;

	private boolean extraTurn;

	private int winner;

	public GameBoard(Player p1, Player p2){
		player1 = p1;
		player2 = p2;

		winner = 0;


		resolveStartingPlayer();
	}

	public void resolveStartingPlayer(){
		// random select starting player
		int randomNumber = (int)(Math.random()*2)+1;
		activePlayer = randomNumber == 1 ? player1 : player2;
	}
	public void resetPlayerScore(){
		activePlayer.resetScore();
	}

	public int getActivePlayerScore(){
		return activePlayer.getScore();
	}

	public String getActivePlayerName(){
		return activePlayer.getName();
	}

	public String getInactivePlayerName(){
		return activePlayer == player1 ? player2.getName() : player1.getName();
	}

	public void increaseActivePlayerScore(int deltaScore){
		activePlayer.increaseScore(deltaScore);

	}

	public int getWinner(){
		return winner;
	}

	public void setWinner(){
		this.winner = activePlayer == player1 ? 1: 2;
	}

	public void setExtraTurn(boolean extraTurn){
		this.extraTurn = extraTurn;
	}



	public String getWinnerName(){
		switch(winner){
		case 1: return player1.getName();
		case 2: return player2.getName();
		default: return "Ingen vinder";		// Should not be able to get to here

		}
	}

	public void nextTurn(){
		if(!extraTurn)
			activePlayer = activePlayer == player1 ? player2 : player1;
		else
			extraTurn = false;
	}

	public void reset(){
		player1.resetScore();
		player2.resetScore();
		extraTurn = false;
		winner = 0;

	}

}
