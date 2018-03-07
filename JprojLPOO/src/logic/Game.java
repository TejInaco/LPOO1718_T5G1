package logic; 
import cli.Launcher;
import java.util.Random;

import logic.Guard.GuardType;

public class Game {
	public boolean gameover = false;
	boolean ended = false;
	boolean passed = false;
	public int level = 1;
	public Level board;

	Hero hero = new Hero(1, 1);
	Guard guard;
	Ogre ogres[];

	public Game() {
	}

//	public void setLevel() {
//		switch (level) {
//		case 2:
//			board = new TakeTwo();
//			break;
//		default:
//			board = new TakeOne();
//			break;
//		}
//	}
	public void goNext() {

		board = board.goToNext();

		if (board != null) {
			setGuard();
			setOgre();
			passed = false;
			print();
		} else
			ended = true;

}
	
	
	
	public void setLevel(Level map) {
		board = map;
		
	}

	public void setGuard() {

		Random rand = new Random();

		int random = rand.nextInt(3);

		switch (random) {
		case 0:
			guard = new Guard(1, 8, GuardType.ROOKIE);
			break;

		case 1:
			guard = new Guard(1, 8, GuardType.DRUNKEN);
			break;

		default:
			guard = new Guard(1, 8, GuardType.SUSPICIOUS);
			break;
		}
	}

	public void setGuard(int lin, int col) {

		//Random rand = new Random();

		//int random = rand.nextInt(3);

	//	switch (random) {
		//case 0:
			guard = new Guard(lin, col, GuardType.ROOKIE);
			//break;

//		case 1:
//			guard = new Guard(1, 8, GuardType.DRUNKEN);
//			break;
//
//		default:
//			guard = new Guard(1, 8, GuardType.SUSPICIOUS);
//			break;
//		}
	}

	
	
	// TENTAR COLOCAR EM OGRE
	public void setOgre() {

		Random rand = new Random();

		int random = rand.nextInt(3);// creates up to 3 ogres

		ogres = new Ogre[random + 1];// creates an array to hold the number of ogres randomly generated

		for (int k = 0; k < ogres.length; k++) {// populates array with the number of ogres randomly generated
			Ogre ogre = new Ogre();
			ogres[k] = ogre;
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

				if (board.isEmpty(newLine, newCol) && !board.foundDoor(newLine, newCol)) {
					((Ogre) foe).setLine(newLine);
					((Ogre) foe).setCol(newCol);
					break;
				}
			}
		}
	}

	public void CastClub(Ogre ogre) {

		

			while (true) {

				int newLine = ogre.getLine();
				int newCol = ogre.getCol();

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

				if (board.isEmpty(newLine, newCol)) {
					ogre.getClub().setLine(newLine);
					ogre.getClub().setCol(newCol);
					break;
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

		if ( board.isEmpty(newLine, newCol)) {
			hero.setLine(newLine);
			hero.setCol(newCol);
		}

		validateRules();
		
	}

	public void validateRules() {

		if (level == 1) {

			guard.move();

			if (board.gotKey(hero.getLine(), hero.getCol()))
				board.openDoors();

			if (guard.collision(hero.getLine(), hero.getCol()))
				gameover = true;

			if (board.foundDoor(hero.getLine(), hero.getCol()))

				passed = true;
		}

		if (level == 2) {
	
			for (int i = 0; i < ogres.length; i++) {
			
				if (!ogres[i].getStun())
					move(ogres[i]);
				else
					ogres[i].incStunCounter();
			
				CastClub(ogres[i]);
			
		
			}
	
			if (board.gotKey(hero.getLine(), hero.getCol())) {
				board.openDoors();
				hero.setSymbol('K');
			}
			
			for (int i = 0; i < ogres.length; i++) {
			
				if (ogres[i].collision(hero.getLine(), hero.getCol()))
					gameover = true;
				
				if (ogres[i].stun(hero.getLine(), hero.getCol())) {
					ogres[i].setSymbol('8');
					ogres[i].setStun();
				}
				
				if (board.gotKey(ogres[i].getCol(), ogres[i].getLine()))
					ogres[i].setSymbol('$');
				else if (!ogres[i].getStun())
					ogres[i].setSymbol('O');
		
				if (board.gotKey(ogres[i].getClub().getCol(), ogres[i].getClub().getLine()))
					ogres[i].getClub().setSymbol('$');
				else
					ogres[i].getClub().setSymbol('*');
			
			}
			
			if (board.foundDoor(hero.getLine(), hero.getCol()))
				ended = true;
		}
	
	}

	// public void OLDprint() {
	// validateRules();
	// for (int i = 0; i < 10; i++) {
	// for (int j = 0; j < 10; j++) {
	// if (!update(i, j))
	// System.out.print(board.getMap()[i][j] + " ");
	// }
	// System.out.print("\n");
	// }
	// if (ended)
	// System.out.print("PLAYER ONE WINS");
	// else if (gameover)
	// System.out.print("GAME OVER\n");
	// if (level < 2)
	//
	// {
	// if (passed) {
	//
	// if (level == 1) {
	// hero.setLine(1);
	// hero.setCol(8);
	// hero.setSymbol('A');
	// }
	//
	// level++;
	// setLevel();
	// passed = false;
	// // novamente print() //break begin;
	// }
	// } else if (passed)
	// ended = true;
	// }

	public boolean update(int lin, int col) {

		if (level == 1) {

			// hero
			if (hero.getCol() == col && hero.getLine() == lin) {
				System.out.print(hero.getSymbol() + " ");
				return true;
			}

			// guard
			if (guard.getCol() == col && guard.getLine() == lin) {
				System.out.print(guard.getSymbol() + " ");
				return true;
			}

		} else {

			// hero
			if (hero.getCol() == col && hero.getLine() == lin) {
				System.out.print(hero.getSymbol() + " ");
				return true;
			}

			// ogre and club
			for (int i = 0; i < ogres.length; i++) {

				if (ogres[i].getCol() == col && ogres[i].getLine() == lin) {
					System.out.print(ogres[i].getSymbol() + " ");
					return true;
				}

				if (ogres[i].getClub().getCol() == col && ogres[i].getClub().getLine() == lin) {
					System.out.print(ogres[i].getClub().getSymbol() + " ");
					return true;
				}
			}
		}

		return false;
	}

	public void checkLevel() {
		// System.out.print("level");
		// System.out.println(level);
		// System.out.println(passed);
		if (level < 2) {
			// System.out.println("<2");
			if (passed) {
				// System.out.println("passed");

				if (level == 1) {
					// System.out.println("level1");
					hero.setLine(7);
					hero.setCol(1);
					hero.setSymbol('H');
				}
				// System.out.println("++");
				level++;
			//	setLevel();
				passed = false;
				print();
			}
		} else if (passed)
			ended = true;
	}


	public void display() {
		print();

		if (ended)
			System.out.print("PLAYER ONE WINS");
		else if (gameover)
			System.out.print("GAME OVER\n");

		goNext();
	}

	/*
	 * Function that prints the characters
	 */

	/*
	 * Function that prints the current map
	 */

	public void print() {
		System.out.println();
		for (int i = 0; i < board.getMap().length ; i++) {
			for (int j = 0; j < board.getMap().length; j++) {
				if (!update(i, j))
					System.out.print(board.getMap()[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public void setHero(int lin, int col) {
		hero = new Hero(lin, col);
	}

}
