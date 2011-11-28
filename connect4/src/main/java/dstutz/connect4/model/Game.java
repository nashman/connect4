/**
 * 
 */
package dstutz.connect4.model;

import dstutz.connect4.common.DropColor;
import dstutz.connect4.controller.ControllerGameSession;
import dstutz.connect4.controller.ControllerGameSetup;
import dstutz.connect4.gui.GameScreen;
import dstutz.connect4.gui.SetupScreen;
import dstutz.connect4.model.logic.GameEngine;
import dstutz.connect4.player.Player;

/**
 * @author Daniel Stutz
 * 
 */
public class Game {
	private GameEngine gameEngine;
	public SetupScreen gameSetup;
	public GameScreen gameScreen;
	private Player player1;
	private Player player2;
	ControllerGameSetup cGameSetup = new ControllerGameSetup();
	ControllerGameSession cGameSession = new ControllerGameSession();
	public String[] gameSetupData;
	public GameData gameData;

	public void startSetup() {
		gameSetup = new SetupScreen();
		gameSetup.setFrame(true);
		gameSetup.addObserver(cGameSetup);
		gameData = new GameData();

		while (cGameSetup.isStatus()) {
			System.out.println("Status Setup " + cGameSetup.isStatus());
		}
		gameData.setSetupData(cGameSetup.gameSetupData);
	}

	public void startMatch() {
		gameSetupData = gameSetupData;
		gameScreen = new GameScreen();
		gameScreen.setFrame(true);
		gameScreen.setStartData(gameData.getSetupData(), DropColor.YELLOW);

		// while (cGameSession.isStatus()) {
		// System.out.println("Status Game " + cGameSetup.isStatus());
		// }

	}

}
