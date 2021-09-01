/**
* has the ability to be interactive with the hero, map, or shop depending on the type of item
*/
public class Item {
	/**
	 * stores the name of the item
	 */
	public String name;
	/**
	 * stores the value of the item 
	 */
	public int value;
	/**
	 * stores the type of the item 
	 */
	public char type;
	/**
	 * constructor - Creates a new instance of the map
	 * @param n the name of the item
	 * @param v the value of the item
	 * @param t the type of the item
	 */
	public Item(String n,int v, char t) {
		name = n;
		value = v;
		type = t;
	}
	/**
	 * constructor for the item
	 * @param i Item that is to be copied from
	 */
	public Item( Item i){

		name = i.getName();
		value = i.getValue();
		type =  i.getType();
		
	}

	/**
	 * accessor for the item name
	 * @return name of the item
	 */
	public String getName() {
		return name;
	}
	/**
	 * accessor for the item value
	 * @return value of the item
	 */
	public int getValue(){
		return value;
	}
	/**
	 * accessor for the item type
	 * @return type of the item
	 */
	public char getType(){
		return type;
	}
	/**
	 * creates a deep clone for the item
	 * @return clone of the current item
	 */
	public Item clone(){
		return new Item( this ) ;
	}
}
