import java.util.Random;
/**
* A decorator for the enemy which would give additional health, attack, and modification to name
*/
public class Warrior extends EnemyDecorator {
	/**
	 * Constructor Warrior - Initialize warrior attributes 
	 * @param e the Enemy that gets returned to the super 
	 */
	public Warrior(Enemy e){
			super(e, "Warrior", 2);
		}
	/**
	 * aggregates more damage to the original object(EnemyType) attack 
	 * @return an integer that holds the accumulated damage of the decorated item.
	 */	
	@Override
	public int attack(){
		Random rand = new Random();
		//int randomNum = rand.nextInt((max - min) + 1) + min;
		int dmg = rand.nextInt(5) + 1;
		System.out.println("Enemy swings sword at you!");
		return dmg + super.attack();
	}	
}