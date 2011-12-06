package dstutz.connect4.controller;

import java.util.Observable;
import java.util.Observer;

import dstutz.connect4.common.DropColor;
import dstutz.connect4.gui.GameScreen;
import dstutz.connect4.gui.SetupScreen;
import dstutz.connect4.model.GameEngine;

public class ControllerGame implements Observer {
	public String[] gameSetupData;
	private int choosenColumn;
	private boolean status;
	private GameEngine gameEngine;
	private SetupScreen gameSetup;
	private ControllerGameSetup cGameSetup;
	private GameScreen gameScreen;
	private boolean firstMove = false;

	public ControllerGame() {
		// TODO Auto-generated constructor stub
		status = true;
		cGameSetup = new ControllerGameSetup();
		gameScreen = new GameScreen();
		gameEngine = new GameEngine();
		gameSetup = new SetupScreen();
	}

	public void startSetup() {
		gameSetup = new SetupScreen();
		gameSetup.setFrame(true);
		gameSetup.addObserver(cGameSetup);

		while (cGameSetup.isStatus()) {
			System.out.println("Status Setup " + cGameSetup.isStatus());
		}
		gameEngine.gameData.setSetupData(cGameSetup.gameSetupData);
	}

	public void startMatch() {
		gameSetupData = gameSetupData;
		gameScreen.setFrame(true);
		gameScreen.addObserver(this);
		gameEngine.addObserver(this);
		gameScreen.setStartData(gameEngine.gameData.getSetupData(),
				DropColor.YELLOW);

		while (this.isStatus()) {

			gameEngine.gameData.setPlayMoveFromUser(this.getChoosenColumn());
			System.out.println("choosen move from user: "
					+ gameEngine.gameData.getPlayMoveFromUser());
			if (!gameEngine.checkMove()) {
				this.setStatus(false);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * 
	 */
	public void update(Observable o, Object arg) {
		if (o instanceof GameScreen) {
			// firstMove = true;
			System.out.println("Nun ist mein Observer informiert: " + "gugus");
			Integer choosenColumn = (Integer) arg;
			setChoosenColumn(choosenColumn.intValue());
		}
		if (o instanceof GameEngine) {
			System.out.println("Nun ist mein Observer informiert: "
					+ arg.toString());
		}
	}

	/**
	 * @return the choosenColumn
	 */
	public int getChoosenColumn() {
		return choosenColumn;
	}

	/**
	 * @param choosenColumn
	 *            the choosenColumn to set
	 */
	public void setChoosenColumn(int choosenColumn) {
		this.choosenColumn = choosenColumn;
	}

	/**
	 * @return the gameSetupData
	 */
	public String[] getGameSetupData() {
		return gameSetupData;
	}

	/**
	 * @param gameSetupData
	 *            the gameSetupData to set
	 */
	public void setGameSetupData(String[] gameSetupData) {
		this.gameSetupData = gameSetupData;
	}

	public boolean gameMoveChanged() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

}
