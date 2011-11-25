package dstutz.connect4;

import dstutz.connect4.controller.ControllerGameSession;
import dstutz.connect4.controller.ControllerGameSetup;
import dstutz.connect4.model.logic.GameEngine;

public class Testlauf {

	public static void main(String[] args) {
		GameEngine gameEngine = new GameEngine();
		ControllerGameSetup cGameSetup = new ControllerGameSetup();
		ControllerGameSession cGameSession = new ControllerGameSession();
		gameEngine.gameSetup.addObserver(cGameSetup);

		// ----------------- Game Setup
		// Solange der Setup laueft
		// wie kann man das besser machen ?
		while (cGameSetup.isStatus()) {
			System.out.println("Status " + cGameSetup.isStatus());
		}

		// ----------------- Game start
		gameEngine.startMatch(cGameSetup.gameSetupData);
		gameEngine.gameScreen.addObserver(cGameSession);

		// ----------------- Game Session
		gameEngine.gameScreen.setGameData(gameEngine.getGameData(),
				gameEngine.getActiveDropColor());

		gameEngine.setGameMove(cGameSession.choosenColumn);

		// ----------------- Game Summary

		// ----------------- Game End

	}
}
