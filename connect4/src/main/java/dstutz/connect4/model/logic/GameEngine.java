package dstutz.connect4.model.logic;

import dstutz.connect4.common.DropColor;
import dstutz.connect4.gui.GameScreen;

public class GameEngine {
	public GameScreen gameScreen;
	public String[] gameSetupData;
	private int[] gameData;
	private DropColor activeDropColor;
	private int choosenColumn;
	private AILogic ailogic;
	private int playMoveFromUser;

	public GameEngine() {
	}

	public DropColor getActiveDropColor() {
		activeDropColor = DropColor.YELLOW;
		return activeDropColor;
	}

	public void setGameMove(int choosenColumn) {
		this.choosenColumn = choosenColumn;
	}

	/**
	 * @param playMoveFromUser
	 */
	public void checkUserMove(int playMoveFromUser) {
		this.playMoveFromUser = playMoveFromUser;
		// TODO Auto-generated method stub
	}
}
