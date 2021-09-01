/**
* Enemy Decorator Class
**/
public abstract class EnemyDecorator extends Enemy{
	/**
	* Enemy that will be decorated 
	**/
	public Enemy enemy;
	/**
	 * MonsterDecorator constructor
	 * @param m monster being updated 
	 * @param newName name being added to the monster 
	 * @param newHP hp being added to the monster 
	 */
	public EnemyDecorator(Enemy e, String n, int mHP) {
		super(n + " " + e.getName() , e.getMaxHP() + mHP, ItemGenerator.getInstance().generateItem() );
		enemy = e;
	}
	/**
	* Attack based on Class Type 
	**/
	@Override
	public int attack( ){
		return enemy.attack();
	}
}