/**
* Entity Class
**/
public abstract class Entity {
	/**
	* Entity name 
	**/
	private String name;
	/**
	* Entity max hp 
	**/
	private int maxHp;
	/**
	* Entity hp 
	**/
	private int hp;
	/**
	 * Creates an entity and set name, hp, and maxHp
	 * @param n sets the name 
	 * @param mHP set the max HP 
	 */
	public Entity(String n, int mHP) {
		name = n;
		maxHp = mHP;
		hp = mHP;
	}

	/**
	 * Makes the entity attack 
	 */
	public abstract int attack();
	/**
	 * name accessor
	 * @return name of entity 
	 */
	public String getName() {
		return (name);
	}
	/**
	 * hp accessor
	 * @return hp of entity
	 */
	public int getHP() {
		return (hp);
	}
	/**
	 * max hp accessor
	 * @return max hp of entity
	 */
	public int getMaxHP() {
		return (maxHp);
	}
	/**
	 * heals the entity
	 * @param heals the entity for that amount 
	 */
	public void heal(int h) {
		hp += h;
		if (hp > 25) {
			hp = 25;
		}
	}
	/**
	 * makes the entity take damage 
	 */
	public void takeDamage(int h) {
		hp -= h;
		if (hp < 0) {
			hp = 0;
		}
	}
	/**
	 * prints our object as a string 
	 * @return returns our object as a string 
	 */
	public String toString() {
		String name = "";
		String decoratedName = getName();
		if (decoratedName.contains("Warlock")){
			if(decoratedName.contains("Froglok")){
				name = "Froglok Warlock";
			} else if (decoratedName.contains("Goblin")){
				name = "Goblin Warlock";
			} else if (decoratedName.contains("Orc")){
				name = "Orc Warlock";
			}else{
				name = "Troll Warlock";
			}
		} else if (decoratedName.contains("Warrior")){
			if(decoratedName.contains("Froglok")){
				name = "Froglok Warrior";
			} else if (decoratedName.contains("Goblin")){
				name = "Goblin Warrior";
			} else if (decoratedName.contains("Orc")){
				name = "Orc Warrior";
			}else{
				name = "Troll Warrior";
			}
		} else {
			name = decoratedName;
		}		
		return name + " has: " + "\nHP: " + getHP() + "/" + getMaxHP();
	}
}
