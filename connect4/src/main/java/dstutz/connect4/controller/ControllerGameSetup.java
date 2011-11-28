package dstutz.connect4.controller;

import java.util.Observable;
import java.util.Observer;

public class ControllerGameSetup implements Observer {
	public String[] gameSetupData;

	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ControllerGameSetup() {
		// TODO Auto-generated constructor stub
		status = true;
	}

	public void gameMatchStarted() {

	}

	public void update(Observable o, Object arg) {
		setGameSetupData((String[]) arg);
		setStatus(false);
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
}
