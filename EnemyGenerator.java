import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
* Enemy Generator Class
**/
public class EnemyGenerator {
	// private ArrayList<Enemy> enemyList;
	// private ItemGenerator ig;
	/**
	* Enemy Generator instance 
	**/
	private static EnemyGenerator instance;

	/**
	* Enemy Class
	**/
	//SHOULD THIS BE PUBLIC????

	public EnemyGenerator() {
		// ig = ItemGenerator.getInstance();
		instance = null;
	}
	/**
	* Generates a Enemy Generator Instance
	* @return Enemy Generator Instance
	**/
	public static EnemyGenerator getInstance() {
		if (instance == null) {
			instance = new EnemyGenerator();
		}
		return instance;
	}

	/**
	 * Generates enemies for the hero to fight
	 * @param level will determine enemy hp and attacks 
	 * @return randomly generated enemy
	 */
	public Enemy generateEnemy(int level) {
		/*
		Enemy e = new Goblin(ItemGenerator.getInstance().generateItem());
		// if level <1:
			e = new Warrior ( e  );
		else:
		
		System.out.println("Damage: " + e.attack() + e.getName());
		*/
		
		//generate random number for race type
		Random rand = new Random();
		int raceType = (rand.nextInt(4) + 1);
		
		//make enemy 
		Enemy e = new Froglok(ItemGenerator.getInstance().generateItem());
		if (raceType == 1) {
			e = new Froglok(ItemGenerator.getInstance().generateItem());
		};
		if (raceType == 2) {
			e = new Goblin(ItemGenerator.getInstance().generateItem());
		}
		if (raceType == 3) {
			e = new Orc(ItemGenerator.getInstance().generateItem());
		}
		if (raceType == 4) {
			e = new Troll(ItemGenerator.getInstance().generateItem());
		}
		//generate random number for class type
		int classType = (rand.nextInt(2) + 1);
		//Get Random Enemy Decorator
		if (level >= 0){
			if ( classType == 1){
				for(int i = 0; i < level-1; i++) {
					e = new Warrior(e);
				}
			} else {
				//loop
				for(int i = 0; i < level-1; i++) {
					e = new Warlock(e);
		 		}
			}
		}
		return e;
	}
}
