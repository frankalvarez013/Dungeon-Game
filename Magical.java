/**
* Interface that holds 3 different magical attack methods to be considered a magical enemy
*/
public interface Magical {
	public static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball\n3. Thunderclap";
	/**
	* Unique Attack
	* @return integer amount of damage that the attack creates
	*/
	public int magicMissile();
	/**
	* Unique Attack
	* @return integer amount of damage that the attack creates
	*/
	public int fireball();
	/**
	* Unique Attack
	* @return integer amount of damage that the attack creates
	*/
	public int thunderclap();
}
