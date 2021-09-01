import java.util.Random;
/**
* Modified version of Enemy that instead of attacking with one method, now has the ability to attack with 3 different types of magical attacks.
*/
public class MagicalEnemy extends Enemy implements Magical {
	/**
	 * Constructor MagicalEnemy - Creates a new instance of a MagicalEnemy;
	 * @param n The given name for the Enemy
	 * @param mHP the max health points of the enemy
	 * @param i the item the enemy is carrying
	 */
	public MagicalEnemy(String n, int mHP, Item i) {
		super(n, mHP, i);
	}
	/**
	* Character that is magical will have three unique ways of attacking but will be random
	* @return A specific attack to execute
	*/
	@Override
	public int attack() {
		Random rand = new Random();
		int randomNum = rand.nextInt(3) + 1;
		if (randomNum == 1) {
			return magicMissile();
		}
		if (randomNum == 2) {
			return fireball();
		}
		if (randomNum == 3) {
			return thunderclap();
		}
		return 0;
	}
	/**
	* Unique Attack - Gives the decorated object an additional type of action to attack the hero with
	* @return integer amount of damage that the attack creates
	*/
	@Override
	public int magicMissile() {
		Random rand = new Random();
		int dmg = rand.nextInt(5) + 1;
		return dmg;
	}
	/**
	* Unique Attack - Gives the decorated object an additional type of action to attack the hero with
	* @return integer amount of damage that the attack creates
	*/
	@Override
	public int fireball() {
		Random rand = new Random();
		int dmg = rand.nextInt(5) + 1;
		return dmg;
	}
	/**
	* Unique Attack - Gives the decorated object an additional type of action to attack the hero with
	* @return integer amount of damage that the attack creates
	*/
	@Override
	public int thunderclap() {
		Random rand = new Random();
		int dmg = rand.nextInt(5) + 1;
		return dmg; 
	}
}
