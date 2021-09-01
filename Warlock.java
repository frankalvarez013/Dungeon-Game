import java.util.Random;
/**
* A decorator for the enemy which would give additional health, magical attacks, and modification to name
*/
public class Warlock extends EnemyDecorator implements Magical {
	/**
	 * Constructor Warlock - Initialize warrior attributes 
	 * @param e the Enemy that gets returned to the super 
	 */
	public Warlock(Enemy e) {
		super(e, "Warlock", 1);
	}
	/**
	 * aggregates more damage to the original object(EnemyType) attack 
	 * @return an integer that holds the accumulated damage of the decorated item.
	 * @return 0 if the randomNumber returns a number outside the range of 1-3
	 */	
	@Override
	public int attack() {
		Random rand = new Random();
		int randomNum = rand.nextInt(3) + 1;
		if (randomNum == 1) {					
			return magicMissile() + super.attack();
		}
		if (randomNum == 2) {
			return fireball() + super.attack();
		}
		if (randomNum == 3) {
			return thunderclap() + super.attack();
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
		System.out.println("Enemy is using Magic Missile!");
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
		System.out.println("Enemy is using Fireball!");
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
		System.out.println("Enemy is using Thunderclap!");
		return dmg; 
	}

}