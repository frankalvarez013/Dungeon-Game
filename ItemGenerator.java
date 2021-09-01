import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
* Singleton that generates random items but if asked, can return specifically a key or potion
*/
public class ItemGenerator {
	/**
	 * stores the array list of Items 
	 */
	public ArrayList<Item> itemList;
	/**
	 * stores any instance when the itemGenerator is used in the code
	 */
	private static ItemGenerator instance;
	/**
	 * Constructor ItemGenerator - Creates a new instance of itemGenerator;
	 * Adds items to the itemList array that comes from the txt. file
	 * @throws FileNotFoundException, occurs when there is no file with the given map Number
	 */
	public ItemGenerator() {
		instance = null;
		itemList = new ArrayList<>(10);
		try {
			Scanner read = new Scanner(new File("ItemList.txt"));

			while (read.hasNext()) {
				String itemPrint = read.nextLine();
				String[] itemComponent = itemPrint.split(",");
				Item itemObj = new Item(itemComponent[0],Integer.parseInt(itemComponent[1]),itemComponent[2].charAt(0));
				itemList.add(itemObj);
			}
			read.close();

		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
		}
	}
	/**
	* Initializes the itemGenerator universal pointer or returns the pointer
	* @return instance of the itemGenerator in order to use it anywhere in the code
	*/
	public static ItemGenerator getInstance(){
		if (instance == null) {
			instance = new ItemGenerator();
		}
		return instance;
	}
	/**
	 * Uses random() to return an item from our item arrayList
	 * @return an item from our item arrayList
	 */
	public Item generateItem() {
		Random rand = new Random();
		int randomNum = rand.nextInt(itemList.size());
		return itemList.get(randomNum).clone();
	}

	public Item getPotion(){
		return itemList.get(0);
	}
	/**
	 * accessor for the Key item
	 * @return Key item
	 */
	public Item getKey(){
		return itemList.get(1);
	}
}
