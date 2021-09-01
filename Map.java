import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
* Used as the template that the hero will have to traverse where unique variables create different environments for the hero
*/
public class Map {
	/**
	 * stores the private map matrix with specific variables in each coordinate
	 */
	private char[][] map;
	/**
	 * stores the private map matrix that holds the variables that the user/hero has discovered
	 */
	private boolean[][] revealed;
	/**
	 * stores any instance when the map is used in the code
	 */
	private static Map instance;
	/**
	 * Constructor Map - Creates a new instance of the map;
	 * The locally held data defaults to the integer 5.
	 */
	public Map() {
		instance = null;
		map = new char[5][5];
		revealed = new boolean[5][5];
	}
	/**
	* loads a specific map from txt to an Obj.
	* @param mapNum - The map number you will load
	* @throws FileNotFoundException, occurs when there is no file with the given map Number
	*/
	public void loadMap(int mapNum) {
		try {
			Scanner read = new Scanner(new File("Map" + mapNum + ".txt"));
			int x;
			int y = 0;
			while (read.hasNext()) {
				x = 0;
				String mapPrint = read.nextLine();
				String[] mapList = mapPrint.split(" ");
				for (int i = 0; i <= 4; i++) {
					char mapChar = mapList[i].charAt(0);
					map[y][x] = mapChar;
					revealed[y][x] = false;
					x++;
				}
				y++;
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
		}
	}
	/**
	* Initializes the map universal pointer or returns the pointer
	* @return instance of the Map in order to use it anywhere in the code
	*/
	public static Map getInstance(){
		if (instance == null) {
			instance = new Map();
		}
		return instance;
	}
	/**
	* Gets a specific character letter on the map
	* @param p - The location where we get the character in the map
	* @return character in the p location
	*/
	public char getCharAtLoc(Point p) {
		return map[(int) p.getX()][(int) p.getY()];
	}
	/**
	* displays the map
	* @param p -gets the p location and makes sure that it is shown uniquely in the map
	*/
	public void displayMap(Point p) {
		// double loop to print map
		for (int y = 0; y <= 4; y++) {
			for (int x = 0; x <= 4; x++) {
				// map is revealed then print the object thats there
				if (y == p.getX() && x == p.getY()) {
					System.out.print("* ");
				} else if (revealed[y][x]) {
					System.out.print(map[y][x] + " ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}

	}
	/**
	* finds the Start position of the map and returns it
	* @return Object with the location of the S
	*/
	public Point findStart() {
		Point obj = new Point();
		for (int col = 0; col <= 4; col++) {
			for (int row = 0; row <= 4; row++) {
				if (map[col][row] == 's') {
					obj.setLocation(col, row);
				}
			}
		}
		return obj;
	}
	/**
	* reveals the location of where the hero goes over
	* @param p - gets the hero object
	*/
	public void reveal(Point p) {
		char symbol = getCharAtLoc(p);
		if (symbol == 'm') {
			revealed[(int) p.getX()][(int) p.getY()] = true;
		} else if (symbol == 'i') {
			revealed[(int) p.getX()][(int) p.getY()] = true;
		} else if (symbol == 'f') {
			revealed[(int) p.getX()][(int) p.getY()] = true;
		} else if (symbol == 'n') {
			revealed[(int) p.getX()][(int) p.getY()] = true;
		} else if (symbol == 's') {
			revealed[(int) p.getX()][(int) p.getY()] = true;
		}
	}
	/**
	* removes the object from from the map
	* @param p - gets the hero object
	*/
	public void removeCharAtLoc(Point p) {
		map[(int) p.getX()][(int) p.getY()] = 'n';

	}

}
