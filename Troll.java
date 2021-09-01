import java.util.Random;
/**
* Base class of an enemy Troll that contains a health and attack stat for hero fights.
*/
public class Troll extends Enemy {
	/**
	 * Constructor Troll - Creates a new instance of Troll, has 5 additional health
	 * @param i - The generated item that the Troll needs to put in the parameter of its superclass in order for it to function
	 */
	public Troll(Item i) {
		super("Troll", 5, i);
	}
	/**
	* The base objects natural attack method against the hero, prints out a unique attack statement
	* @return integer amount of damage that the attack creates
	*/
	@Override
	public int attack() {
		Random rand = new Random();
		int dmg = rand.nextInt(5) + 1;
		System.out.println("Enemy now smacks the hero around!");
		return dmg;
	}
}