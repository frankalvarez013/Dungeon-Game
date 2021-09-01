/**
* Project 2
* @author Frank Alvarez 
* @author Francisco Rivera
*/
import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class Main {
	/**
	* Main Method
	* @param args
	*/
	public static void main(String[] args) {
		// ask user for name
		System.out.print("What is your name traveler? ");
		Scanner in = new Scanner(System.in); // Create a Scanner object
		String userName = in.nextLine(); // Read user input
		// creates map
		Map map = Map.getInstance();
		Map.getInstance().loadMap(1);
		
		// create hero
		Hero hero = new Hero(userName, map);
		
		// to let user know what level they complete
		int counter = 1;
		outerloop: for (int i = 1; i <= 5; i++) {
			if (i % 3 == 0) {
				Map.getInstance().loadMap(3);
			} else {
				Map.getInstance().loadMap(i % 3);
			}
			hero.heal(25);
			//if hero isnt on level 1 then show store
			if (counter != 1) {
				store(hero);
			}
			while (Map.getInstance().getCharAtLoc(hero.getLocation()) != 'f' || !hero.hasKey()) {	
				System.out.println("");
				// reveal initial location
				Map.getInstance().reveal(hero.getLocation());
				// display hero name, hp, and inventory
				System.out.println(hero.toString());
				System.out.println("");
				// displays the map
				Map.getInstance().displayMap(hero.getLocation());
				

				// direction
				System.out.println("");
				System.out.println("1. Go North");
				System.out.println("2. Go South");
				System.out.println("3. Go East ");
				System.out.println("4. Go West");
				System.out.println("5. Quit");
				int choice = CheckInput.getIntRange(1, 5);
				if (choice == 1) {
					hero.goNorth();
					Map.getInstance().reveal(hero.getLocation());
				} else if (choice == 2) {
					hero.goSouth();
					Map.getInstance().reveal(hero.getLocation());
				} else if (choice == 3) {
					hero.goEast();
					Map.getInstance().reveal(hero.getLocation());
				} else if (choice == 4) {
					hero.goWest();
					Map.getInstance().reveal(hero.getLocation());
				} else if (choice == 5) {
					break outerloop;
				}

				while (Map.getInstance().getCharAtLoc(hero.getLocation()) == 'm') {
	
					if (monsterRoom(hero,(i))) {	
						// if monster is defeated then remove letter from map
						Map.getInstance().removeCharAtLoc(hero.getLocation());
					} else {
						// if monster isnt defeated then move to a random location

						// check to see if player is any of the corners bacause this will limit which
						// room they get sent to

						// check to see if player is top left
						if (hero.getLocation().getX() == 0 && hero.getLocation().getY() == 0) {
							Random rand = new Random();
							int randomNum = rand.nextInt(2) + 1;
							if (randomNum == 1) {
								hero.goSouth();
							} else if (randomNum == 2) {
								hero.goEast();
							}
						}
						// check to see if player bottom left
						else if (hero.getLocation().getX() == 4 && hero.getLocation().getY() == 0) {
							Random rand = new Random();
							int randomNum = rand.nextInt(2) + 1;
							if (randomNum == 1) {
								hero.goNorth();
							} else if (randomNum == 2) {
								hero.goEast();
							}
						}
						// check to see if player top right
						else if (hero.getLocation().getX() == 0 && hero.getLocation().getY() == 4) {
							Random rand = new Random();
							int randomNum = rand.nextInt(2) + 1;
							if (randomNum == 1) {
								hero.goSouth();
							} else if (randomNum == 2) {
								hero.goWest();
							}
						}
						// check to see if player bottom right
						else if (hero.getLocation().getX() == 4 && hero.getLocation().getY() == 4) {
							Random rand = new Random();
							int randomNum = rand.nextInt(2) + 1;
							if (randomNum == 1) {
								hero.goNorth();
							} else if (randomNum == 2) {
								hero.goEast();
							}
						}

						// otherwise check to see if player is hugging a wall

						// check to see player is hugging north wall
						else if (hero.getLocation().getX() == 0) {
							Random rand = new Random();
							int randomNum = rand.nextInt(3) + 1;
							if (randomNum == 1) {
								hero.goSouth();
							} else if (randomNum == 2) {
								hero.goEast();
							} else if (randomNum == 3) {
								hero.goWest();
							}
						}
						// check to see if player is hugging south wall
						else if (hero.getLocation().getX() == 4) {
							Random rand = new Random();
							int randomNum = rand.nextInt(3) + 1;
							if (randomNum == 1) {
								hero.goNorth();
							} else if (randomNum == 2) {
								hero.goEast();
							} else if (randomNum == 3) {
								hero.goWest();
							}
						}
						// check to see if player is hugging west wall
						else if (hero.getLocation().getY() == 0) {
							Random rand = new Random();
							int randomNum = rand.nextInt(3) + 1;
							if (randomNum == 1) {
								hero.goNorth();
							} else if (randomNum == 2) {
								hero.goSouth();
							} else if (randomNum == 3) {
								hero.goEast();
							}
						}
						// check to see if player is hugging east wall
						else if (hero.getLocation().getY() == 4) {
							Random rand = new Random();
							int randomNum = rand.nextInt(3) + 1;
							if (randomNum == 1) {
								hero.goNorth();
							} else if (randomNum == 2) {
								hero.goSouth();
							} else if (randomNum == 3) {
								hero.goWest();
							}
						}

						else {
							Random rand = new Random();
							int randomNum = rand.nextInt(4) + 1;
							if (randomNum == 1) {
								hero.goNorth();
							} else if (randomNum == 2) {
								hero.goSouth();
							} else if (randomNum == 3) {
								hero.goWest();
							} else if (randomNum == 4) {
								hero.goEast();
							}
						}

						// reveal location player has been moved to
						Map.getInstance().reveal(hero.getLocation());

						// if we run into another monster, let player know where his location is
						if (Map.getInstance().getCharAtLoc(hero.getLocation()) == 'm') {
							System.out.println(hero.toString());
							Map.getInstance().displayMap(hero.getLocation());
						}
					}
				}
				// check to see if player is on item spot
				if (Map.getInstance().getCharAtLoc(hero.getLocation()) == 'i') {

					// generate item
					itemRoom(hero);
					Map.getInstance().removeCharAtLoc(hero.getLocation());

				}
				if (Map.getInstance().getCharAtLoc(hero.getLocation()) == 'f' && !hero.hasKey()) {
					System.out.println("You are in front of the finish location!\nHowever, you need a key to reach the next world...");
				}
			}
			System.out.println("");
			System.out.println("Level " + counter + " Complete!");
			hero.useKey();
			counter++;
	
		}

	}

	/**
	 * Hero encounters a enemy on the map
	 * @param h hero
	 * @param level used the generate an enemy based on the level of the map
	 */
	static boolean monsterRoom(Hero h, int level) {
		// generate random enemy
		Enemy newEnemy = EnemyGenerator.getInstance().generateEnemy(level);
		String name = "";
		String decoratedName = newEnemy.getName();
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
		System.out.println("You've encountered a " + name + "!");
		// loop while monster is still alive
		while (newEnemy.getHP() != 0) {
			System.out.println(newEnemy.toString());

			// check to see if player has health potion in inventory
			boolean printHP = false;
			if (h.hasPotion()) {
				printHP = true;
			}

			int choice = 0;

			// ask user if they want to fight, runaway, drink potion
			System.out.println("1.Fight\n2.Runaway");
			if (printHP) {
				System.out.println("3.Drink Health Potion");
				choice = CheckInput.getIntRange(1, 3);
			} else {
				choice = CheckInput.getIntRange(1, 2);
			}
			if (choice == 1) {
				fight(h, newEnemy);
			}
			// Runaway
			if (choice == 2) {
				System.out.println("You runaway from the " + name + "!");
				return false;
			}
			if (choice == 3) {
				h.drinkPotion();
				System.out.println("You recovered 25 health!");
			}
		}
		return true;
	}

	/**
	 * Hero and Enemy will fight each other 
	 * @param h hero
	 * @param e enemy that is fighting our hero
	 * @return returns true if hero is alive 
	 */
	static boolean fight(Hero h, Enemy e) {
		String name = "";
		String decoratedName = e.getName();
		System.out.println("1. Physical\n2. Magic Attack");
		int choice = CheckInput.getIntRange(1, 2);
		//checks to see if the decorator has any additional warrior or warlock names 
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
		if (choice == 1) {
			//hero attacks enemy
			int heroDmg = h.attack();
			e.takeDamage(heroDmg);
			System.out.println(h.getName() + " attacks " + name + " for " + heroDmg + " damage!");

		}
		if (choice == 2) {
			System.out.println(Magical.MAGIC_MENU);
			choice = CheckInput.getIntRange(1, 3);
			if (choice == 1) {
				int heroDmg = h.attack();
				e.takeDamage(heroDmg);
				System.out.println(h.getName() + " hits " + name + " with Magic Missiles for " + heroDmg + " damage!");
			}
			if (choice == 2) {
				int heroDmg = h.attack();
				e.takeDamage(heroDmg);
				System.out.println(h.getName() + " hits " + name + " with Fireball for " + heroDmg + " damage!");
			}
			if (choice == 3) {
				int heroDmg = h.attack();
				e.takeDamage(heroDmg);
				System.out.println(h.getName() + " hits " + name + " with Thunderclap for " + heroDmg + " damage!");
			}
		}
		// if monster is defeated then take item
		if (e.getHP() == 0) {
			System.out.println("You defeated the " + name + "!");
			if (h.pickUpItem(e.getItem())) {
				System.out.println("You received " + e.getItem().name + " from its corpse!");
			} else {
				System.out.println("You received " + name + " from its corpse, but your inventory is full!");
				// ask user if they would like to replace or drop item
				System.out.println("Which would you like to do?");
				System.out.println("1. Replace an Item\n2. Drop this item");
				choice = CheckInput.getIntRange(1, 2);
				if (choice == 1) {
					System.out.println("Which item would you like to replace?");
					System.out.println(h.itemsToString());
					choice = CheckInput.getIntRange(1, 5);
					h.dropItem(choice - 1);
					h.pickUpItem(e.getItem());
				}
				// else do nothing
			}
		}
		// if monster isnt defeated then monster attacks
		// STILL HAVE TO CODE FOR MULTIPLE ATTACKS 
		if (e.getHP() != 0) {
			//if hero has an armor item then block the attack 
			int armorIndex = h.hasArmorItem();
			if(armorIndex >= 0) { 
			//consume armor item
			Item consumedItem = h.dropItem(armorIndex);	
				System.out.println(name + "'s attack was blocked with your " + consumedItem.getName() + "!");
			}
			else {
				int enemyDmg = e.attack();
				h.takeDamage(enemyDmg);
				System.out.println("The " + name + " attacks " + h.getName() + " for a total of " + enemyDmg + " damage!");
			}
		}

		// if hero dies then end the game
		if (h.getHP() == 0) {
			System.out.println("You are dead!");
			System.exit(0);
		}
		return true;
	}
	/**
	 * Hero encounters an item on the map 
	 * @param h hero
	 */
	static void itemRoom(Hero h) {
		// generate item
		Item newItem = ItemGenerator.getInstance().generateItem();
		Item newKey = ItemGenerator.getInstance().getKey();

		// if player is able to pick it up then just print
		if(!h.hasKey()){
			if (h.pickUpItem(newKey)){
				System.out.println("You have found " + newKey.getName() + "!");
			} else {
				System.out.println("You have found " + newKey.getName() + ", but your inventory is full!");
				// ask user if they would like to replace or drop item
				System.out.println("Which would you like to do?");
				System.out.println("1. Replace an Item\n2. Drop this item");
				int choice = CheckInput.getIntRange(1, 2);
				if (choice == 1) {
					System.out.println("Which item would you like to replace?");
					System.out.println(h.itemsToString());
					choice = CheckInput.getIntRange(1, 5);
					h.dropItem(choice - 1);
					h.pickUpItem(newKey);
				}
			}
		} else {
			if (h.pickUpItem(newItem)) {
				System.out.println("You have found " + newItem.getName() + "!");
			} else {
				System.out.println("You have found " + newItem.getName() + ", but your inventory is full!");
				// ask user if they would like to replace or drop item
				System.out.println("Which would you like to do?");
				System.out.println("1. Replace an Item\n2. Drop this item");
				int choice = CheckInput.getIntRange(1, 2);
				if (choice == 1) {
					System.out.println("Which item would you like to replace?");
					System.out.println(h.itemsToString());
					choice = CheckInput.getIntRange(1, 5);
					h.dropItem(choice - 1);
					h.pickUpItem(newItem);
				}
			}
		} 
	
	}

	/**
	 * Hero encounters the store 
	 * @param h hero
	 */
	static void store(Hero h) {
	//set choice to default value 
	int choice = 0;
		do {
			System.out.println("You are in the shop: Do you want to buy or sell?\nYou have " + h.getGold() + " Gold.");
			System.out.println("1. Buy\n2. Sell\n3. Exit");
			choice = CheckInput.getIntRange(1, 3);
			if (choice == 1) {
				//check if hero has enough inventory space to buy 
				if(h.getNumItems() != 5) {
					System.out.println("\nBuy one of these items:\n1. Health Potions\n2. Keys");
					int buyItem = CheckInput.getIntRange(1, 2);
					//user wants to buy health potion 
					if (buyItem == 1) {
						// check if hero has enough gold
						if(h.getGold() >= 25) {
							h.spendGold(25);
							h.pickUpItem(ItemGenerator.getInstance().getPotion()); //SINGLETON
							System.out.println("You purchased a Health Potion!");
						}
						else {	
							System.out.println("You do not have enough gold to purchase a Health Potion!");
						}	
					} else {
						// check if hero has enough gold
						if(h.getGold() >= 50) {
							h.spendGold(50);
							h.pickUpItem(ItemGenerator.getInstance().getKey()); //SINGLETON
							System.out.println("You purchased a Key!");
						}
						else {	
							System.out.println("You do not have enough gold to purchase a Key!");
						}	
					}
				}
				//if hero doesn't have enough space
				else {
					System.out.println("Inventory full!");
				}
			// Sell Item
			} else if (choice == 2) {
				//check to see if user has items to sell
				if(h.getNumItems() != 0) {
					System.out.println("Which item would you like to sell?");
					System.out.println(h.itemsToString());
					choice = CheckInput.getIntRange(1, h.getNumItems());
					Item soldItem = h.dropItem(choice - 1);
					h.collectGold(soldItem.getValue());
					System.out.println("You sold " + soldItem.getName() + " for " + soldItem.getValue() + " gold!");
					//reset choice to avoid glitch
					choice = 0;

					}
				//if user has no items to sell
				else {
					System.out.println("You have no items to sell!");
				}
			}
		} while (choice != 3);

	}
}
