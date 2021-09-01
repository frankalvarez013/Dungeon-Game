import java.util.Random;
/**
* Base class of an enemy Froglok that contains a health and attack stat for hero fights.
*/
public class Froglok extends Enemy {
	/**
	 * Constructor Froglok - Initialize troll attributes, has 4 additional health
	 * @param i - The generated item that the Troll needs to put in the parameter of its superclass in order for it to function
	 */
	public Froglok(Item i) {
		super("Froglok", 2,i);
	}
	/**
	* The base objects natural attack method against the hero, prints out a unique attack statement
	* @return integer amount of damage that the attack creates
	*/
	@Override
	public int attack(){
		Random rand = new Random();
		//int randomNum = rand.nextInt((max - min) + 1) + min;
		int dmg = rand.nextInt(5) + 1;
		System.out.println("Enemy now kicks the hero!");
		return dmg;
	}
}