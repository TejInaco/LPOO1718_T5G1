package logic;

public class TakeTwo implements Level {

//public class CrazyOgreMap implements GameMap {

	private char[][] map = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };

	public TakeTwo() {
	}

	public boolean isEmpty(int lin, int col) {
		if (map[lin][col] == 'X' || map[lin][col] == 'I' || lin < 0 || lin >= 9 || col < 0 || col >= 9)
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
		for (int i = 0; i < map.length; i++) {
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
	
//	public void setMap(char [][] mp) {
//			this.map = mp;
//	}
}
