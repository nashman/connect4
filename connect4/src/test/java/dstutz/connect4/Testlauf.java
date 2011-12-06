/**
 * 
 */
package dstutz.connect4;

import dstutz.connect4.controller.ControllerGame;

/**
 * @author Daniel Stutz
 * 
 */
public class Testlauf {
	public static void main(String[] args) {
		ControllerGame cGame = new ControllerGame();
		// ----------------- Game Setup
		cGame.startSetup();

		// ----------------- Game start
		cGame.startMatch();
	}
}
