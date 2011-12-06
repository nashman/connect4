/**
 * 
 */
package dstutz.connect4.model;

import java.util.Observable;

import dstutz.connect4.common.DropColor;
import dstutz.connect4.model.logic.GameLogic;
import dstutz.connect4.player.Player;

/**
 * @author Daniel Stutz
 * 
 */
public class GameEngine extends Observable {
	private GameLogic gameEngine;
	private Player player1;
	private Player player2;
	public String[] gameSetupData;
	public GameData gameData;
	private GameLogic gameLogic;

	/**
	 * 
	 */
	public GameEngine() {
		// TODO Auto-generated constructor stub
		gameData = new GameData();
		gameLogic = new GameLogic();
	}

	/**
	 * 
	 */
	public boolean checkFreeSlot() {
		// TODO Auto-generated method stub
		if (!gameLogic.checkFreeRow(gameData)) {
			System.out.println("Kein freier Slot mehr");
			return false;
		} else {
			System.out.println("freier slot: " + gameData.getNextFreeSlot());
			notifyObservers();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observable#notifyObservers(java.lang.Object)
	 */
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		super.setChanged(); // Eine Änderung ist aufgetreten
		super.notifyObservers("Benachrichtigung");
	}

	/**
	 * 
	 */
	public boolean checkMove() {
		// TODO Auto-generated method stub
		if (!checkFreeSlot()) {
			gameFinished("Kein Slot mehr frei: Unentschieden");
			return false;
		}
		if (!gameLogic.checkWinConditions()) {
			gameFinished("Kein Slot mehr frei: Unentschieden");
			return false;
		}

		// to debug
		for (DropColor[] s : gameData.getGameBoard()) {
			System.out.println("");
			for (DropColor t : s) {
				System.out.print(" slot: " + t);
			}
		}
		return true;
	}

	public void gameFinished(String str) {
		System.out.println("-----------");
		System.out.println(str);
		System.out.println("-----------");
	}

}
