package dstutz.connect4.controller;

import java.util.Observable;
import java.util.Observer;

public class ControllerGameSession implements Observer {
	public String[] gameSetupData;
	private int choosenColumn;
	private boolean status;

	/**
	 * 
	 */
	public ControllerGameSession() {
		// TODO Auto-generated constructor stub
		status = true;
	}

	public void update(Observable o, Object arg) {
		Integer choosenColumn = (Integer) arg;
		setChoosenColumn(choosenColumn.intValue());
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
