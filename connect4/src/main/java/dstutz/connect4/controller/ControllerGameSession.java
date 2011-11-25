package dstutz.connect4.controller;

import java.util.Observable;
import java.util.Observer;

public class ControllerGameSession implements Observer {
	public String[] gameSetupData;
	public int choosenColumn;

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

	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void update(Observable o, Object arg) {
		Integer choosenColumn = (Integer) arg;
		setChoosenColumn(choosenColumn.intValue());
	}
}
