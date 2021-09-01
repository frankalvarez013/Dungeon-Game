import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
* Hero Class
*/
public class Hero extends Entity implements Magical {
	/**
	* Stores an array of items 
	**/
	private ArrayList<Item> items;
	/**
	* Map that the hero is on
	**/
	private Map map;
	/**
	* Saves the location of the hero 
	**/
	private Point location;
	/**
	* Hero gold wallet 
	**/
	private int gold;

	/**
	 * creates Hero with name and sets the hero in the map
	 * @param n A string of the Hero's name
	 * @param m A map that the hero will use to wander
	 */
	public Hero(String n, Map m) {
		super(n, 25);
		map = m;
		items = new ArrayList<Item>();
		location = map.findStart();
	}

	/**
	 * Generates a random damage number for the hero 
	 * @return the damage generated for the hero 
	 */
	@Override
	public int attack() {
		Random rand = new Random();
		int dmg = rand.nextInt(5) + 1;
		// e.takeDamage(dmg);
		// return getName() + " attacks " + e.getName() + " for " + dmg + " damage!";
		return dmg;
	}

	/**
	 * should display hero's name, health, Inventory, map
	 * @return the display for hero stats 
	 */
	@Override
	public String toString() {
		String heroString = "";
		heroString += super.toString() + "\n\n";
		heroString += itemsToString();
		return heroString;
	}

	/**
	 * display list of items that player has
	 * @return the list of items
	 */
	public String itemsToString() {
		String inventoryList = "Inventory:";
		for (int i = 0; i < getNumItems(); i++) {
			inventoryList += "\n" + (i + 1) + ". " + items.get(i).getName();
		}
		return inventoryList;
	}

	/**
	 * gets the number of items the hero has
	 * @return the number of items the hero has
	 */
	public int getNumItems() {
		return items.size();
	}

	/**
	 * Hero picks up the item
	 * @param i - The item the hero wants to pick up
	 * @return true if item is able to picked up or false if they cant
	 */
	public boolean pickUpItem(Item i) {
		final int TOTAL_ITEMS = 5;
		if (items.size() == TOTAL_ITEMS) {
			return false;
		}
		items.add(i);
		return true;
	}

	/**
	 * Hero drinks the potion if he has the potion in Inventory
	 */
	public void drinkPotion() {
		final String HEALTH_POTION = "Health Potion";
		final int HEAL_VALUE = 25;

		for (int i = 0; i < items.size(); i++) {
			if (HEALTH_POTION.equals(items.get(i).getName())) {
				super.heal(HEAL_VALUE);
				items.remove(i);
				break;
			}
		}
	}

	/**
	 * Hero drops a specific item
	 * @param index - the location of the specific item
	 * @return return the item removed from item inventory 
	 */
	public Item dropItem(int index) {
		return items.remove(index);

	}

	/**
	 * checks to see if the hero has a potion
	 * @return returns false or true if the Hero has the potion
	 */
	public boolean hasPotion() {
		final String HEALTH_POTION = "Health Potion";
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(HEALTH_POTION)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * gets the location of the hero
	 * @return Hero location
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * Hero goes North
	 * @return returns the location of the character at the hero's previous location
	 */
	public char goNorth() {

		char charLocation = map.getCharAtLoc(location);
		if (location.getX() == 0) {
			System.out.println("Cannot go out of Bounds");
			location.setLocation(0, location.getY());
		}

		else {
			location.translate(-1, 0);
		}

		return charLocation;
	}

	/**
	 * Hero goes South
	 * @return returns the location of the character at the hero's previous location
	 */
	public char goSouth() {
		char charLocation = map.getCharAtLoc(location);
		if (location.getX() == 4) {
			System.out.println("Cannot go out of Bounds");
			location.setLocation(4, location.getY());
		} else {
			location.translate(1, 0);
		}
		return charLocation;
	}

	/**
	* Hero goes East
	* @return returns the location of the character at the hero's previous location
	*/
	public char goEast() {
		char charLocation = map.getCharAtLoc(location);
		if (location.getY() == 4) {
			System.out.println("Cannot go out of Bounds");
			location.setLocation(location.getX(), 4);
		} else {
			location.translate(0, 1);
		}
		return charLocation;
	}

	/**
	* Hero goes West
	* @return returns the location of the character at the hero's previous location
	*/
	public char goWest() {
		char charLocation = map.getCharAtLoc(location);
		if (location.getY() == 0) {
			System.out.println("Cannot go out of Bounds");
			location.setLocation(location.getX(), 0);
		} else {
			location.translate(0, -1);
		}
		return charLocation;
	}

	/**
	* Hero attacks the enemy with magicMissile using magical attacks
	* @return damage generated from spell
	*/
	@Override
	public int magicMissile() {
		Random rand = new Random();
		int dmg = rand.nextInt(7) + 1;
		// e.takeDamage(dmg);
		// return getName() + " hits " + e.getName() + " with Magic Missiles for " + dmg + " damage!";
		return dmg;
	}

	/**
	* Hero attacks the enemy with fireball using magical attacks
	* @return damage generated from spell
	*/
	@Override
	public int fireball() {
		Random rand = new Random();
		int dmg = rand.nextInt(7) + 1;
		// e.takeDamage(dmg);
		// return getName() + " hits " + e.getName() + " with Fireball for " + dmg + " damage!";
		return dmg;
	}

	/**
	 * Hero attacks the enemy with thunderclap using magical attacks
	 * @return damage generated from spell
	 */
	@Override
	public int thunderclap() {
		Random rand = new Random();
		int dmg = rand.nextInt(7) + 1;
		// e.takeDamage(dmg);
		// return getName() + " hits " + e.getName() + " with Thunderclap " + dmg + " damage!";
		return dmg;
	}

	/**
	* Returns hero gold value 
	*	 @return hero gold value
	* 
	**/
	public int getGold(){
		return gold;
	}
	/**
	* Adds value to gold wallet
	*	@param g value being added to gold wallet 
	**/
	public void collectGold(int g){
		gold += g;
	}
	/**
	* Removes value from gold wallet
	*	@param g value being removed from gold wallet  
	**/
	public void spendGold(int g){
		//Not sure what to do here so Im guessing we just take away from the purse
		gold -= g;
	}
	/**
	* Returns the index if hero has an armor item
	*	@return the index of the armor item  
	**/
	public int hasArmorItem(){
		for ( Item x : items){
			if(x.getType() == 'a'){
				return items.indexOf(x);
			}
		}
		return -1;
	}
	/**
	* Check to see if hero has key
	*	return true if hero has key 
	**/
	public boolean hasKey(){
		for ( Item x : items){
			if(x.getType() == 'k'){
				return true;
			}
		}
		return false;
	}
	/**
	* Removes key from inventory
	**/
	public void useKey(){
		for( Item removeKey : items){
			if(removeKey.getType() == 'k'){
				items.remove(removeKey);
				break;
			}
		}
	}
}