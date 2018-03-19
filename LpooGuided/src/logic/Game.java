package logic;

import java.util.Random; 

import logic.Guard.GuardType;

public class Game {
	public boolean gameover;
	public boolean ended;
	public boolean passed;
	public int level;
	public Level board;
	public String mapping="";

	Hero hero;
	Guard guard;
	Ogre ogres[];
	Ogre crazyOgre;

	public Game() {
		this.gameover = false;
		this.ended = false;
		this.passed = false;
		this.level = 1;
		this.hero = new Hero(1, 1);
		this.crazyOgre = new Ogre();
	}
	public Game(int ogres, Object tipo) {
		
		this.guard = new Guard(1,8,(GuardType) tipo);
		this.ogres = new Ogre[ogres];
	}
	
	public Level getBoard() {
		return this.board;
	}
	public Hero getHero() {
		return this.hero;
	}
	public int getLevelint() {
		return this.level;
	}
	public boolean getPassed() {
		return this.passed;
	}
	public Level getLevelObj() {
		return this.board;
	}
	public boolean getGameOver() {
		return this.gameover;
	}
	public Guard getGuard() {
		return this.guard;
	} 
	public Ogre getCrazyOgre() {
		return this.crazyOgre;
	}
	public void setCrazyOgre(Ogre m) {
		this.crazyOgre  = m;
	}
	
	public void setLevel(char[][] lvl) {
		 this.board = new Level(lvl);
	}
	public void setLevel() {
		switch (this.level) {
		case 4:
			this.board = new Level(4);
			break;
		case 3:
			this.board = new Level(3);
			break;
		case 2:
			this.board = new Level(2);
			break;
		default:
			this.board = new Level(1);
			break;
		}
	}
	public void setLevelObjec(Level toty) {
		this.board = toty;
	}
	public void setLevelInt(int nmb) {
		this.level = nmb;
	}
	public void setGuard(Guard grd) {
		this.guard = grd;
	}
	public void setHero(Hero heroi) {
		this.hero = heroi;
	}
	
	public void setGameOver() {
		this.gameover = true;
		
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

		if (board.isEmpty(newLine, newCol)) {
			hero.setLine(newLine);
			hero.setCol(newCol);
		}

		validateRules();

	}

	public void validateRules() {

		if (this.level == 1) {  //heroi e um guarda apenas

			this.guard.move();

			if (this.board.gotKey(this.hero.getLine(), this.hero.getCol()))
				this.board.openDoors();

			if (this.guard.collision(this.hero.getLine(), this.hero.getCol()))
				this.gameover = true;

			if (this.board.foundDoor(this.hero.getLine(), this.hero.getCol()))
				this.passed = true;
		}
//////////		
		if (this.level == 2) {//heroi e um ogre com club
	
			if (this.getCrazyOgre().getStun()) {
					move(this.getCrazyOgre());
			}else{
				this.getCrazyOgre().incStunCounter();
			}
			
			CastClub(this.getCrazyOgre());
			
			//check if hero tem a chave
			if (this.board.gotKey(this.hero.getLine(), this.hero.getCol())) {
				this.board.openDoors();
				this.hero.setSymbol('K');
			}
			//
			
			if (this.getCrazyOgre().collision(this.hero.getLine(), this.hero.getCol()))
					this.setGameOver();

			if (this.crazyOgre.stun(this.hero.getLine(), this.hero.getCol())) {
				this.crazyOgre.setSymbol('8');
				this.crazyOgre.setStun();
			}
			
			if (this.board.gotKey(this.crazyOgre.getCol(), this.crazyOgre.getLine())) {
				this.crazyOgre.setSymbol('$');
			}else if (!this.crazyOgre.getStun()) {
				this.crazyOgre.setSymbol('O');
			}

			if (this.board.gotKey(this.crazyOgre.getClub().getCol(), this.crazyOgre.getClub().getLine()))
				this.crazyOgre.getClub().setSymbol('$');
			else
				this.crazyOgre.getClub().setSymbol('*');

			
			if (this.board.foundDoor(this.hero.getLine(), this.hero.getCol()))
				this.ended = true;
		}

		if (this.level == 3) {// heroi e 3 guardas
			//TODO rever o codigo para os 3 guardas
			this.guard.move();

			if (this.board.gotKey(this.hero.getLine(), this.hero.getCol()))
				this.board.openDoors();

			if (this.guard.collision(this.hero.getLine(), this.hero.getCol()))
				this.setGameOver();

			if (board.foundDoor(hero.getLine(), hero.getCol()))
				passed = true;

		}
		if (this.level == 4) {//heroi e muitos Ogres

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
		if (this.hero.getCol() == col && this.hero.getLine() == lin) {
			System.out.print(this.hero.getSymbol() + " ");
			return true;
		}
//GUARD
		if ( this.level == 1 || this.level == 3 ) {
			if (this.guard.getCol() == col && this.guard.getLine() == lin) {
				System.out.print(this.guard.getSymbol() + " ");
				return true;
			}

		} 
//OGRE (1)
		if( this.level == 2 ) {
			if (this.crazyOgre.getCol() == col && this.crazyOgre.getLine() == lin) {
				System.out.print(this.crazyOgre.getSymbol() + " ");
				return true;
			}
		}
//OGRE(3)		
		if( this.level == 4 ){
			
			for (int i = 0; i < this.ogres.length; i++) {

				if (this.ogres[i].getCol() == col && this.ogres[i].getLine() == lin) {
					System.out.print(this.ogres[i].getSymbol() + " ");
					return true;
				}

				if (this.ogres[i].getClub().getCol() == col && this.ogres[i].getClub().getLine() == lin) {
					System.out.print(this.ogres[i].getClub().getSymbol() + " ");
					return true;
				}
			}
		}
		return false;
	}

	public void checkLevel() {
		
		if ( this.level == 1 ) {
			// System.out.println("<2");
			if (this.passed) {
				// System.out.println("passed");

				if (level == 1) {
					// System.out.println("level1");
					hero.setLine(7);
					hero.setCol(1);
					hero.setSymbol('H');
				}
				// System.out.println("++");
				level++;
				setLevel();
				passed = false;
				print();
			}
		} else if (passed)
			this.ended = true;
	
	}

	/*
	 * Function that manages the display
	 */

	public void display() {
		print();

		if (this.ended) {
			System.out.print("PLAYER ONE WINS");
			System.exit(0);
		}else if (this.gameover) {
			System.out.print("GAME OVER\n");
			System.exit(0);
		}
		checkLevel();
	
	}

	
	/*
	 * Function that prints the current map
	 */

	public void print() {
		System.out.println();
		for (int i = 0; i < this.board.getMap().length; i++) {
			for (int j = 0; j < this.board.getMap()[0].length; j++) {
				if (!update(i, j))
					System.out.print(this.board.getMap()[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	
	public void showGame() {

		mapping = "";

		for (int i = 0; i < board.getMap().length; i++) {
			for (int j = 0; j < board.getMap()[0].length; j++) {
				if (!updateMapping(i, j))
					mapping += board.getMap()[i][j] + " ";
				
			}
			mapping += "\n";
		}
	}

	public boolean updateMapping(int y, int x) {

		// hero
		if (hero.getCol() == y && hero.getLine() == x) {
			mapping += hero.getSymbol() + " ";
			return true;
		}

		if (guard != null) {

			// guard
			if (guard.getCol() == y && guard.getLine() == x) {
				mapping += guard.getSymbol() + " ";
				return true;
			}

		}

		if (getLevelint() ==2 && ogres.length != 0) {

			// ogre and club
			for (int i = 0; i < ogres.length; i++) {

				if (ogres[i].getCol() == y && ogres[i].getLine() == x) {
					mapping +=ogres[i].getSymbol() + " ";
					return true;
				}

				if (ogres[i].getClub().getCol() == y && ogres[i].getClub().getLine() == x) {
					mapping += ogres[i].getClub().getSymbol() + " ";
					return true;
				}
			}
		}

		return false;
}
	
	
}
