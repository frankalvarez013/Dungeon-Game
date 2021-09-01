import java.util.Random;
/**
* Base class of an enemy Goblin that contains a health and attack stat for hero fights.
*/
public class Goblin extends Enemy {
	/**
	 * Constructor Goblin - Initialize troll attributes, has 2 additional health
	 * @param i - The generated item that the Troll needs to put in the parameter of its superclass in order for it to function
	 */
	public Goblin(Item i) {
		super("Goblin", 2, i);
	}
	/**
	* The base objects natural attack method against the hero, prints out a unique attack statement
	* @return integer amount of damage that the attack creates
	*/
	@Override
	public int attack() {
		Random rand = new Random();
		//int randomNum = rand.nextInt((max - min) + 1) + min;
		int dmg = rand.nextInt(5) + 1;
		System.out.println("Enemy now shanks the hero!");
		return dmg;
	}
}