import java.util.Random;
/**
* Enemy Class
**/
public abstract class Enemy extends Entity {
	/**
	* Item that Enemy will hold
	**/
	public Item item;

	/**
	 * Enemy constructor
	 * @param n name of enemy 
	 * @param mHp max hp of enemy 
	 * @param i item the enemy holds 
	 */
	public Enemy(String n, int mHP, Item i) {
		super(n, mHP);
		item = i;
	}

	/**
	 * item accessor
	 * @return item of the enemy 
	 */
	public Item getItem() {
		return item;
	}

	/**
	* Abstract attack class
	*/
	public abstract int attack();

}
