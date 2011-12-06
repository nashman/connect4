/**
 * 
 */
package dstutz.connect4.model;

import dstutz.connect4.common.DropColor;

/**
 * @author Daniel Stutz
 * 
 */
public class GameData {
	private int playMoveFromUser;
	private int playMoveFromEngine;
	private int[] nextFreeSlot = new int[2];
	private String[] setupData;
	private DropColor[][] gameBoard = new DropColor[7][6];

	public String[] getSetupData() {
		return setupData;
	}

	public void setSetupData(String[] setupData) {
		// inital value for new game
		setupData[2] = "0";
		setupData[3] = "0";
		this.setupData = setupData;
	}

	public int getPlayMoveFromUser() {
		return playMoveFromUser;
	}

	public void setPlayMoveFromUser(int playMoveFromUser) {
		this.playMoveFromUser = playMoveFromUser;
	}

	/**
	 * @return the gameBoard
	 */
	public DropColor[][] getGameBoard() {
		return gameBoard;
	}

	public int[] getNextFreeSlot() {
		return nextFreeSlot;
	}

	public void insertMove(int column, int row, DropColor dropColor) {
		// TODO Auto-generated method stub
		this.nextFreeSlot[0] = column;
		this.nextFreeSlot[1] = row;
		this.gameBoard[column][row] = dropColor;
	}
}
