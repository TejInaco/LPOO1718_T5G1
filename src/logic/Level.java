package logic;

public class Level {
	protected char[][] map;
	public boolean isDoorsOpen;
	
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
		if(numb == 2) {
			char [][] mapaToUse = { 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
					{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };
			this.map = mapaToUse;

		}
		if(numb == 3) { //varios guardas
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
		if(numb == 4) { //varios Ogres
			char [][] mapaToUse = { 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
					{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };
			this.map = mapaToUse;
	
		}
		this.isDoorsOpen =false;
	}
	
	public Level(char[][] mp) {
		this.map = mp;
		this.isDoorsOpen =false;
	}
	
	public char[][] getMap() {
		return this.map;
	}
	public boolean getisDoorsOpen() {
		return this.isDoorsOpen;
	}
	
	public int getSize() {
		return this.map[0].length;
	}
	
	public boolean isEmpty(int lin, int col) {
		if ( ( lin < 0 || lin > this.getMap().length ) 
				|| (col < 0 || col > this.getMap().length ) ) throw new IllegalArgumentException();
		
		if (this.map[lin][col] == 'X' || this.map[lin][col] == 'I' )
			return false;
		else 
			return true;	
	}

	public boolean gotKey(int lin, int col) {	
		if (this.map[lin][col] == 'k')
			return true;
		else
			return false;
	}

	public void openDoors() {
		for (int i = 0; i < this.map.length; i++) {
			if (this.map[i][0] == 'I')
				this.map[i][0] = 'S';
				this.isDoorsOpen = true;
		}
	}

	public boolean foundDoor(int lin, int col) {
		if (this.map[lin][col] == 'S')
			return true;
		else
			return false;
	}

	

	
}
