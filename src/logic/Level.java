package logic;

public class Level {
	protected char[][] map;
	public boolean isDoorsOpen;
	/**
	 * Default Level Costructor
	 * @param number of level
	 * */
	public Level(int numb) {
		if(numb == 1) {
			char [][] mapaToUse =  { 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
					{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
					{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, 
					{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
			this.map = mapaToUse;
			
		}
		else if(numb == 2) {
			char [][] mapaToUse = { 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
					{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };
			this.map = mapaToUse;

		}
		else if(numb == 3) { //varios guardas
			char [][] mapaToUse =  { 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
					{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
					{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, 
					{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
			this.map = mapaToUse;
	
		}
		else if(numb == 4) { //varios Ogres
			char [][] mapaToUse = { 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
					{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };
			this.map = mapaToUse;
	
		}
		else { 
			throw new IllegalArgumentException();
		}
		this.isDoorsOpen =false;
	}
	/**
	 * Constuctor with a defined map.
	 * For tests purpose
	 * @param map of the board game 
	 */
	public Level(char[][] mp) {
		this.map = mp;
		this.isDoorsOpen =false;
	}
	/**
	 * Get attribute map
	 * @return a double array representing the map
	 */
	public char[][] getMap() {
		return this.map;
	}
	/**
	 * Get attribute isDoorsOpen
	 * @return true if the door is open false if the door still closed
	 */
	public boolean getisDoorsOpen() {
		return this.isDoorsOpen;
	}
	/**
	 * Get attribute map size
	 * @return size integer
	 */
	public int getSize() {
		return this.map[0].length;
	}
	/**
	 * Checks if selected line and column is a empty cell or not
	 * @return true if cell is empty, false otherwise
	 */
	public boolean isEmpty(int lin, int col) {
		if ( ( lin < 0 || lin > this.getMap().length ) 
			|| (col < 0 || col > this.getMap().length ) ) throw new IllegalArgumentException();
		
		if (this.map[lin][col] == 'X' || this.map[lin][col] == 'I' )
			return false;
		else 
			return true;	
	}
	/**
	 * Verifies if a cell has the key or not
	 * @return true if cell is key or false otherwise
	 */
	public boolean gotKey(int lin, int col) {	
		if (this.map[lin][col] == 'k')
			return true;
		else
			return false;
	}
	/**
	 * Verifies where are the doors and change symbol to symbol 'S' meaning open doors
	 */
	public void openDoors() {
		for (int i = 0; i < this.map.length; i++) {
			if (this.map[i][0] == 'I')
				this.map[i][0] = 'S';
				this.isDoorsOpen = true;
		}
	}
	/**
	 * Verifies if Hero position is the door
	 * @param hero line number
	 * @param hero line column
	 * @return true if hero found the door or false otherwise
	 */
	public boolean foundDoor(int lin, int col) {
		if (this.map[lin][col] == 'S')
			return true;
		else
			return false;
	}

	
}
