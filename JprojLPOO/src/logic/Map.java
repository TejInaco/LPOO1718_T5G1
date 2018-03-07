package logic;

import java.util.ArrayList;
import java.util.Random;

public class Map extends Level {

	public Map(char[][] map) {

		this.map = new char[map.length][map[0].length];
		ogres = new ArrayList<Ogre>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {

				if (map[i][j] == 'H' || map[i][j] == 'A') {
					this.map[i][j] = ' ';
					hero = new Hero(j, i, map[i][j]);
				}

				else if (map[i][j] == 'G') {
					this.map[i][j] = ' ';
					guard = new Guard(j, i);
				} else if (map[i][j] == 'O') {
					this.map[i][j] = ' ';
					Ogre ogre = new Ogre(j, i);
					ogres.add(ogre);
				} else
					this.map[i][j] = map[i][j];
			}
		}
	}
	
	public void move(BoardObject foe) {

		if (foe instanceof Guard)
			((Guard) foe).move();

		else if (foe instanceof Ogre) {

			while (true) {

				int newLine = ((Ogre) foe).getLine();
				int newCol = ((Ogre) foe).getCol();

				Random random = new Random();

				int dir = 2 * (1 + random.nextInt(4));

				switch (dir) {
				case 8:
					newLine++;
					break;
				case 6:
					newLine--;
					break;
				case 2:
					newCol++;
					break;
				case 4:
					newCol--;
					break;
				}

				if (map[newLine][newCol]==' ' && map[newLine][newCol]!='S' && map[newLine][newCol]!='I') {
					((Ogre) foe).setLine(newLine);
					((Ogre) foe).setCol(newCol);
					break;
				}
			}
		}
	}

	public void move(int dir) {
		int newLine = hero.getLine();
		int newCol = hero.getCol();

		switch (dir) {
		case 8:
			newLine--;
			break;
		case 6:
			newCol++;
			break;
		case 2:
			newLine++;
			break;
		case 4:
			newCol--;
			break;
		}

		if ( map[newLine][newCol]==' ') {
			hero.setLine(newLine);
			hero.setCol(newCol);
		}

		//validateRules();
		
	}


	public void setHero(int lin, int col) {
		hero = new Hero(lin, col);
	}
	
	public void setGuard(int lin, int col) {
		hero = new Hero(lin, col);
	}
	
}
