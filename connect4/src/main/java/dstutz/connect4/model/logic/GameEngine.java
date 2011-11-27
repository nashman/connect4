package dstutz.connect4.model.logic;

import dstutz.connect4.common.DropColor;
import dstutz.connect4.gui.GameScreen;
import dstutz.connect4.gui.SetupScreen;

public class GameEngine {
	public SetupScreen gameSetup;
	public GameScreen gameScreen;
	public String[] gameSetupData;
	private int[] gameData = new int[4];
	private DropColor activeDropColor;
	private int choosenColumn;
	private AILogic ailogic;

	public GameEngine() {
		gameSetup = new SetupScreen();
		gameSetup.setFrame(true);
	}

	public void startMatch(String[] gameSetupData) {
		this.gameSetupData = gameSetupData;
		gameScreen = new GameScreen();
		gameScreen.setFrame(true);
		gameScreen.setStartData(gameSetupData[0], gameSetupData[1], 0, 0,
				DropColor.YELLOW);
	}

	public int[] getGameData() {
		int[] intArr = new int[4];
		intArr[0] = 2; // Spalte
		intArr[1] = 2; // Zeile
		intArr[2] = 3; // turns player 1
		intArr[3] = 4; // turns player 2
		gameData = intArr;
		return gameData;
	}

	public void setGameData() {
		gameData[0] = choosenColumn;
		gameData[1] = 6;
		gameData[2] = 3; // turns player 1
		gameData[3] = 4; // turns player 2
	}

	public DropColor getActiveDropColor() {
		activeDropColor = DropColor.YELLOW;
		return activeDropColor;
	}

	public void setGameMove(int choosenColumn) {
		this.choosenColumn = choosenColumn;
		setGameData();
	}
}
