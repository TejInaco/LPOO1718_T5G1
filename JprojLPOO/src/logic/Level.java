package logic;

public class Level {
	protected char[][] map;

	public Level(int numb) {
		if(numb == 1) {
			char [][] mapaToUse =  { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
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
			char [][] mapaToUse = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
					{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };
			this.map = mapaToUse;
		}
	}
	
	public Level(char[][] mp) {
		this.map = mp;
	}
	
	public char[][] getMap() {
		return map;
	}
	public void setMap(char[][] mp) {
		this.map = mp;
	}
	public boolean isEmpty(int lin, int col) {
		if (map[lin][col] == 'X' || map[lin][col] == 'I' || lin < 0 || lin >= 10 || col < 0 || col >= 10)
			return false;
		else 
			return true;
	}

	public boolean gotKey(int lin, int col) {
		
		if (map[lin][col] == 'k')
			return true;
		else
			return false;
	}

	public void openDoors() {
		for (int i = 0; i < 10; i++) {
			if (map[i][0] == 'I')
				map[i][0] = 'S';
		}
	}

	public boolean foundDoor(int lin, int col) {
		if (map[lin][col] == 'S')
			return true;
		else
			return false;
	}

	

	
}
