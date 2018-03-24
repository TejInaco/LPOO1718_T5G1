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
		this.gameover = false;
		this.ended = false;
		this.passed = false;
		this.level = 1;
		
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
	public void setGameOver(boolean bln) {
		this.gameover = bln;
		
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
			this.getGuard().move();

		else if (foe instanceof Ogre) {

			while (true) {

				int newLine = this.crazyOgre.getLine();
				int newCol = this.crazyOgre.getCol();

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
					this.crazyOgre.setLine(newLine);
					this.crazyOgre.setCol(newCol);
					break;
				}
			}
		}
	}

	public void castClub(Ogre ogre) {

		while (true) {

			int newLine = this.getCrazyOgre().getLine();
			int newCol = this.getCrazyOgre().getCol();
			
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
				this.getCrazyOgre().setClub(newLine, newCol);
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
		this.validateRules();

	}

	public void validateRules() {

		if (this.level == 1) {  //heroi e um guarda apenas
			this.validateRulesLevel1();
		}
		if (this.level == 2) {//heroi e um ogre com club
			this.validateRulesLevel2();
		}	
		if (this.level == 3) {// heroi e 3 guardas
			validateRulesLevel3();
		}
		if (this.level == 4) {//heroi e muitos Ogres
			validateRulesLevel4();
		}
	}
	
	public void validateRulesLevel1() {
		this.guard.move();

		if (this.board.gotKey(this.hero.getLine(), this.hero.getCol()))
			this.board.openDoors();

		if (this.guard.collision(this.hero.getLine(), this.hero.getCol()))
			this.gameover = true;

		if (this.board.foundDoor(this.hero.getLine(), this.hero.getCol()))
			this.passed = true;		
	}
	
	public void validateRulesLevel2() {
		//TODO As portas so abrem quando o heroi chega as portas, extra left click to open
		move(this.getCrazyOgre());
		castClub(this.getCrazyOgre());
		
		if (this.getCrazyOgre().getStun()) {
			move(this.getCrazyOgre());
		}else{
			this.getCrazyOgre().incStunCounter();
		}
		//porta so abrem quando o heroi chegar la
		if(this.hero.getSymbol() == 'K' &&
				this.hero.getCol() == 1 &&
				this.hero.getLine() == 1) {
			this.board.openDoors();
		}
		//check if hero tem a chave
		if (this.board.gotKey(this.hero.getLine(), this.hero.getCol())) {
			this.hero.setSymbol('K');
		}
	
		//Collision
		if (this.getCrazyOgre().collision(this.hero.getLine(), this.hero.getCol()))
				this.setGameOver(true);
	
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

	public void validateRulesLevel3(){
		//TODO rever o codigo para os 3 guardas
		this.guard.move();

		if (this.board.gotKey(this.hero.getLine(), this.hero.getCol()))
			this.board.openDoors();

		if (this.guard.collision(this.hero.getLine(), this.hero.getCol()))
			this.setGameOver(true);

		if (board.foundDoor(hero.getLine(), hero.getCol()))
			passed = true;
		
		if (this.crazyOgre.stun(this.hero.getLine(), this.hero.getCol())) {
			this.crazyOgre.setSymbol('8');
			this.crazyOgre.setStun();
		}
	}
	
	public void validateRulesLevel4() {
		for (int i = 0; i < ogres.length; i++) {

			if (!ogres[i].getStun())
				move(ogres[i]);
			else
				ogres[i].incStunCounter();

			castClub(ogres[i]);

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
				System.out.print( this.crazyOgre.getSymbol()+ " " );
				
				return true;
			}
			if (this.crazyOgre.getClub().getCol()== col && this.crazyOgre.getClub().getLine() == lin) {
				System.out.print( this.crazyOgre.getClub().getSymbol() + " " );				
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
		if (this.level == 1) {
			this.hero.setLine(7);
			this.hero.setCol(1);
			this.hero.setSymbol('H');
		}
		if (this.passed)
			this.ended = true;
			this.level++;
			this.setLevel();
			this.passed = false;
			this.print();
	}

	/*
	 * Function that manages the display
	 */

	public void display() {
		this.print();

		if (this.ended) {
			System.out.print("PLAYER ONE WINS");
			System.exit(0);
		}
		else if (this.gameover) {
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

		for (int lin = 0; lin < board.getMap().length; lin++) {
			for (int col = 0; col < board.getMap()[0].length; col++) {
				if (!updateMapping(lin, col))
					mapping += board.getMap()[lin][col] + " ";
				
			}
			mapping += "\n";
		}
	}

	public boolean updateMapping(int lin, int col) {

		if (hero.getLine() == lin &&  hero.getCol() == col) {
			mapping += hero.getSymbol() + " ";
			return true;
		}

		if (guard != null) {

	
			if (guard.getLine() == lin && guard.getCol() ==col) {
				mapping += guard.getSymbol() + " ";
				return true;
			}

		}

		if (getLevelint() ==2 && ogres.length != 0) {

			// ogre and club
			for (int i = 0; i < ogres.length; i++) {

				if (ogres[i].getLine() == lin && ogres[i].getCol() == col) {
					mapping +=ogres[i].getSymbol() + " ";
					return true;
				}

				if ( ogres[i].getClub().getLine() == lin && ogres[i].getClub().getCol()==col) {
					mapping += ogres[i].getClub().getSymbol() + " ";
					return true;
				}
			}
		}

		return false;
}
	
	
}
