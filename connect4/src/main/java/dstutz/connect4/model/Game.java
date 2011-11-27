/**
 * 
 */
package dstutz.connect4.model;

import dstutz.connect4.model.logic.AILogic;
import dstutz.connect4.model.logic.GameEngine;
import dstutz.connect4.player.Player;

/**
 * @author Daniel Stutz
 * 
 */
public class Game {
	private AILogic ailogic;
	private GameEngine gameEngine;
	private Player player1;
	private Player player2;

	/**
	 * @return the ailogic
	 */
	public AILogic getAilogic() {
		return ailogic;
	}

	/**
	 * @param ailogic
	 *            the ailogic to set
	 */
	public void setAilogic(AILogic ailogic) {
		this.ailogic = ailogic;
	}

	/**
	 * @return the gameEngine
	 */
	public GameEngine getGameEngine() {
		return gameEngine;
	}

	/**
	 * @param gameEngine
	 *            the gameEngine to set
	 */
	public void setGameEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}
}
