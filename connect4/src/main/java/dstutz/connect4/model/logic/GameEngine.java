package dstutz.connect4.model.logic;

import dstutz.connect4.common.DropColor;
import dstutz.connect4.gui.GameScreen;
import dstutz.connect4.model.GameData;

public class GameEngine {
	public GameScreen gameScreen;
	public String[] gameSetupData;
	private int[] gameData;
	private DropColor activeDropColor;
	private int choosenColumn;
	private AILogic ailogic;

	public GameEngine() {
	}

	public DropColor getActiveDropColor() {
		activeDropColor = DropColor.YELLOW;
		return activeDropColor;
	}

	public void setGameMove(int choosenColumn) {
		this.choosenColumn = choosenColumn;
	}

	public boolean checkFreeRow(GameData gameData) {
		String[][] str = gameData.getGameBoard();
		for (int i = 0; i < 6; ++i) {
			if (str[gameData.getPlayMoveFromUser()][i] == null) {
				gameData.setNextFreeSlot(gameData.getPlayMoveFromUser(), i);
				return true;
			}
		}
		return false;
	}
}
