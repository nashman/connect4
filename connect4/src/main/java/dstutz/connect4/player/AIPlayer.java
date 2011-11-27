/**
 * 
 */
package dstutz.connect4.player;

import dstutz.connect4.common.SkillLevel;

/**
 * @author Daniel Stutz
 * 
 */
public class AIPlayer extends Player {
	private SkillLevel skillLevel;

	/**
	 * @return the skillLevel
	 */
	public SkillLevel getSkillLevel() {
		return skillLevel;
	}

	/**
	 * @param skillLevel
	 *            the skillLevel to set
	 */
	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}
}
