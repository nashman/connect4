/**
 * 
 */
package dstutz.connect4;

import dstutz.connect4.model.Game;

/**
 * @author Daniel Stutz
 * 
 */
public class Testlauf {

	public static void main(String[] args) {
		Game game = new Game();
		game.startSetup();

		// ----------------- Game start
		game.startMatch();
		// game.gameScreen.addObserver();
	}
}
