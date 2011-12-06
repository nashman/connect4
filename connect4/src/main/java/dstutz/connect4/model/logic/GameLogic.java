package dstutz.connect4.model.logic;

import dstutz.connect4.common.DropColor;
import dstutz.connect4.gui.GameScreen;
import dstutz.connect4.model.GameData;

public class GameLogic {
	public GameScreen gameScreen;
	public String[] gameSetupData;
	// private int[] gameData;
	private DropColor activeDropColor;
	private int choosenColumn;
	private AILogic ailogic;
	private int turnCounter;
	private GameData gameData;

	public GameLogic() {
	}

	public DropColor getActiveDropColor() {
		activeDropColor = DropColor.YELLOW;
		return activeDropColor;
	}

	public void setGameMove(int choosenColumn) {
		++turnCounter;
		this.choosenColumn = choosenColumn;
	}

	public boolean checkFreeRow(GameData gameData) {
		DropColor[][] board = gameData.getGameBoard();
		for (int i = 0; i < 6; ++i) {
			if (board[gameData.getPlayMoveFromUser()][i] == null) {
				gameData.insertMove(gameData.getPlayMoveFromUser(), i,
						DropColor.YELLOW);
				return true;
			}
		}
		return false;
	}

	/**
	 * @return
	 */
	public boolean checkWinConditions() {
		// TODO Auto-generated method stub
		if (checkYAxis()) {

			return true;
		}
		if (checkXAxis()) {

			return true;
		}
		if (checkDiagAxis()) {

			return true;
		}

		return false;
	}

	/**
	 * 
	 */
	private boolean checkDiagAxis() {
		// TODO Auto-generated method stub

		return false;
	}

	/**
	 * 
	 */
	private boolean checkXAxis() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	private boolean checkYAxis() {
		// TODO Auto-generated method stub
		return false;
	}
}
