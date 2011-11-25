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
		// TODO Auto-generated method stub
		gameSetupData = (String[]) arg;
		for (String str : gameSetupData) {
			System.out.println("was kommt " + str);
		}
		setStatus(false);
	}
}
