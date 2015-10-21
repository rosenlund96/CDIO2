package game;

import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_resources.GUI;
import game.util.DiceCup;

public class GameController {
	private  final int GET_NAME_STATE = 0;
	private  final int PLAY_STATE = 1;
	private final int GAME_WON_STATE = 2;

	private int gameState;
	boolean gameRunning;

	private DiceCup diceCup;
	private GameBoard board;

	boolean doubleSixRule;

	String message;

	public GameController(){
		diceCup = new DiceCup();

		gameState = 0;
		gameRunning = true;

		doubleSixRule = false;

		Field[] fields = {new Empty.Builder().build()};
		GUI.create(fields);
	}

	public void Run(){
		while(gameRunning){

			switch(gameState){
			case GET_NAME_STATE:
				addPlayers();
				break;
			case PLAY_STATE:
				roll();
				break;		
			case GAME_WON_STATE:
				showWinner();
			}
		}
	}

	private void addPlayers(){
		Player[] players = new Player[2];

		for(int i = 0; i < 2; i++){
			while(true){
				String playerName = GUI.getUserString("Indtast navnet på spiller " + (i+1));
				if(playerName.length()!=0){
					players[i] = new Player(playerName);
					GUI.addPlayer(playerName, 0);
					break;
				}else{
					GUI.showMessage("Du skal indtaste et navn");
				}					
			}
		}
		board = new GameBoard(players[0], players[1]);	
		setStartingMessage();
		gameState = PLAY_STATE;

	}

	private void setStartingMessage(){
		message = board.getActivePlayerName() + " er blevet valgt til at starte!";
	}
	
	private void roll(){
		
		String activePlayerName;
		String diceResult;
		String nextPlayerMsg;
		
		GUI.getUserButtonPressed(message, "Kast Terningerne");
		int sum = diceCup.roll();
		GUI.setDice(diceCup.getDie1(), diceCup.getDie2());	
		
		
		String doublesMessage = checkDoubles(diceCup.isDoubles());
		
		if(diceCup.isDoubles()==1)
			sum = 0;
		
		board.increaseActivePlayerScore(sum);
		
			
		activePlayerName = board.getActivePlayerName() + ": ";
		diceResult = "En " + diceCup.getDie1() + "\'er og en " + diceCup.getDie2() + "\'er:  " + sum + " er lagt til din score - ";

				
		if(board.getWinner() == 0){			
			GUI.setBalance(board.getActivePlayerName(), board.getActivePlayerScore());

			board.nextTurn();
			
			nextPlayerMsg = "\n" +board.getActivePlayerName() + " det er din tur";
			
			// Build message
			message = activePlayerName + diceResult + doublesMessage + nextPlayerMsg;

		}else
			gameState = GAME_WON_STATE;
	}
	
	private void showWinner(){
		GUI.getUserButtonPressed(board.getWinnerName() + " Vinder med dobbelt " + diceCup.isDoubles() + "ere!", "Omspil");		
			resetGame();
	}

	
	// 
	private String checkDoubles(int doubles){
		switch(doubles){
		case 1:
			// double ones. reset score to zero
			board.resetPlayerScore();
			return "dobbelt " + 1 + "ere! Score er nulstillet! ";
		case 6:
			// double sixes. if hit, the roll before its a win. doublesSixes indicates whether its hit last roll
			if(doubleSixRule){
				board.setWinner();

			}else
				doubleSixRule = true;

			// case 6: goes through this also
			// gives a win if score is bigger or equal to 40
			// otherwise it gives an extra turn.
		case 2:
		case 3:
		case 4:		
		case 5:
			if(board.getActivePlayerScore() >= 40){
				board.setWinner();
			}

			board.setExtraTurn(true);

			return "dobbelt " + doubles + "ere! Du får en ekstra tur ";

		default:		// no doubles no action.
			return "";

		}
	}


	private void resetGame(){
		board.reset();
		GUI.setBalance(board.getActivePlayerName(), 0);
		GUI.setBalance(board.getInactivePlayerName(), 0);
		board.resolveStartingPlayer();
		setStartingMessage();
		gameState = PLAY_STATE;
	}


}
