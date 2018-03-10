package logic;

public class TakeOne implements Level {

	private char[][] map = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, { 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	public TakeOne() {
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

	public char[][] getMap() {
		return map;
	}
	public void setMap1(char[][] mp) {
		this.map = mp;
	}
}
