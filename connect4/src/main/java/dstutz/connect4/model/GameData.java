/**
 * 
 */
package dstutz.connect4.model;

/**
 * @author Daniel Stutz
 * 
 */
public class GameData {
	private int playMoveFromUser;
	private int playMoveFromEngine;
	private String[] setupData;

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
}
