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
	
	
	/**
	 * Class Game Constructor 
	 * default constructor
	 * */
	public Game() {
		this.gameover = false;
		this.ended = false;
		this.passed = false;
		this.level = 1;
		this.hero = new Hero(1, 1);
		this.crazyOgre = new Ogre();
	
	}
	/**
	 * Class Game Constructor 
	 * @param ogres - number of object ogres to initialize
	 * @param tipo - One of three type of guard
	 * */
	public Game(int ogres, String tipo) {
		this.gameover = false;
		this.ended = false;
		this.passed = false;
		this.level = 1;
		
		switch(tipo) {
		case "Rookie":
			this.guard = new Guard(1,8,GuardType.ROOKIE);
			break;
		case "Drunken":
			this.guard = new Guard(1,8,GuardType.DRUNKEN);
			break;
		case "Suspicious":
			this.guard = new Guard(1,8,GuardType.SUSPICIOUS);
			break;
		}
		
		this.ogres = new Ogre[ogres];
	}
	/**
	 * Class Game Constructor 
	 * default constructor
	 * */
	public Game(int ogres, Object tipo) {
		this.gameover = false;
		this.ended = false;
		this.passed = false;
		this.level = 1;
		
		this.guard = new Guard(1,8,(GuardType) tipo);
		this.ogres = new Ogre[ogres];
	}
	/**
	 * Get attribute board 
	 * @return attribute board
	 * */
	public Level getBoard() {
		return this.board;
	}
	/**
	 * Get attribute hero 
	 * @return Class Object Hero
	 * */
	public Hero getHero() {
		return this.hero;
	}
	/**
	 * Get attribute number of level 
	 * @return integer number of level
	 * */
	
	public int getLevelint() {
		return this.level;
	}
	/**
	 * Get attribute passed 
	 * @return true or false
	 */
	public boolean getPassed() {
		return this.passed;
	}
	/**
	 * Get attribute board 
	 * @return Class Object Level
	 */
	public Level getLevelObj() {
		return this.board;
	}
	/**
	 * Get attribute game over 
	 * @return true or false if the game ends
	 */
	public boolean getGameOver() {
		return this.gameover;
	}
	/**
	 * Get attribute guard 
	 * @return Class Object Guard
	 */
	public Guard getGuard() {
		return this.guard;
	}
	/**
	 * Get attribute Ogres 
	 * @return Class Objet Ogre
	 */
	public Ogre[] getCrazyOgreArray() {
		return this.ogres;
	}
	/**
	 * Get attribute crazyOgre 
	 * @return Class Objet Ogre
	 */
	public Ogre getCrazyOgre() {
		return this.crazyOgre;
	}
	/**
	 * Set attribute crazyOgre 
	 * @param  Class Object Ogre
	 */
	public void setCrazyOgre(Ogre m) {
		this.crazyOgre  = m;
	}	
	/**
	 * Set attribute board. Creates a new object Level with a map
	 * @param map of the game for a level
	 */
	public void setLevel(char[][] lvl) {
		 this.board = new Level(lvl);
	}
	/**
	 * Set attribute level. Selects the object Level for a specific level 
	 * In with level, updates hero a board attributes 
	 */
	public void setLevel() {
		switch (this.level) {
		case 4:
			this.board = new Level(4);
			this.hero = new Hero(8,8);
			break;
		case 3:
			this.board = new Level(3);
			this.hero.setCol(1);
			this.hero.setLine(1);
			break;
		case 2:
			this.board = new Level(2);
			this.hero.setCol(1);
			this.hero.setLine(8);
			this.hero.setSymbol('H');
			break;
		default:
			this.board = new Level(1);
			break;
		}
	}
	
	/**
	 * Get the current level board map 
	 * 
	 */
	public String getMapping() {
		return this.mapping;
	}
	
	/**
	 * Set the board map 
	 * @param String representing the new map
	 */
	public void setMapping(String mapa) {
		this.mapping = mapa;
	}
	
	/**
	 * Set attribute board 
	 * @param Class Object Level
	 */
	public void setLevelObjec(Level toty) {
		this.board = toty;
	}
	/**
	 * Set attribute level with level number
	 * @param number of level
	 */
	public void setLevelInt(int nmb) {
		this.level = nmb;
	}
	/**
	 * Set attribute guard
	 * @param Class Object Guard
	 */
	public void setGuard(Guard grd) {
		this.guard = grd;
	}
	/**
	 * Set attribute Hero
	 * @param Class Object Hero
	 */
	public void setHero(Hero heroi) {
		this.hero = heroi;
	}
	/**
	 * Set attribute passed
	 * @param boolean
	 */
	public void setPassed(boolean bln) {
		this.passed = bln;
	}
	/**
	 * Set attribute gameover
	 * @param true or flase
	 */
	public void setGameOver(boolean bln) {
		this.gameover = bln;
		
	}
	/**
	 * Set attribute guard
	 * Depending on the level creates a random number that will implement the TypeGuard
	 */
	public void setGuard() {
		
		Random rand = new Random();
		int random = rand.nextInt(3);
		
		if (this.level == 1) {
			random = 0;
		}
		this.defineTypeGuard(random);
	}
	/**
	 * Set attribute guard with a Class Object Guard
	 * @param random number that will selected the GuardType 
	 */
	public void defineTypeGuard(int number_selected) {
		switch (number_selected) {
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
	
	/**
	 * Set attribute array of ogres
	 * Creates a random number that will translate into the number of Ogres in the map
	 */
	public void setOgre() {

		Random rand = new Random();
		int incre_line_ogre = 2;
		int random = rand.nextInt(3);// creates up to 3 ogres
		
		random = 2;
		
		ogres = new Ogre[random+1];// creates an array to hold the number of ogres randomly generated

		for (int k = 0; k < ogres.length; k++) {// populates array with the number of ogres randomly generated
			
			Ogre ogre = new Ogre(incre_line_ogre,1,incre_line_ogre-1,1);
			ogres[k] = ogre;
			incre_line_ogre++;
			incre_line_ogre++;
		}
	}
	/**
	 * Move in the map the existent Guard or Ogre
	 * @param Class Object BoardObject
	 */
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
	/**
	 * Move the Class Objects Ogres inside of the array for Level 4
	 * @param Array of Ogres
	 */
	public void moveArrayOgres(Ogre foe) {
		while (true) {
				int newLine = foe.getLine();
				int newCol = foe.getCol();
				
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
					foe.setLine(newLine);
					foe.setCol(newCol);
					break;
				}
			}
		}
	/**
	 * Determines the next position of the club, when Ogre throws it
	 * @param Class Object Ogre
	 */
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
	/**
	 * For Ogres array
	 * Determines the next position of the club, when Ogre throws it
	 * @param Class Object Ogre
	 */
	public void castClubArray(Ogre ogre) {

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
				ogre.setClub(newLine, newCol);
				break;
			}
		}
	}
	/**
	 * Function responsible for the hero movement
	 * @param Recipes the number input by the keyboard numbers
	 */
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

		if (this.board.isEmpty(newLine, newCol)) {
			this.hero.setLine(newLine);
			this.hero.setCol(newCol);
		}
		this.validateRules();

	}
	/**
	 * Fuction who selects the rules for with level depending on the level the game is on
	 */
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
	/**
	 * Verifies guard behavior and game conditions in level 1
	 */
	public void validateRulesLevel1() {
		this.getGuard().move();

		if (this.board.gotKey(this.hero.getLine(), this.hero.getCol()))
			this.board.openDoors();

		if (this.guard.collision(this.hero.getLine(), this.hero.getCol()))
			this.setGameOver(true);

		if (this.board.foundDoor(this.hero.getLine(), this.hero.getCol()))
			this.passed = true;
		
	}
	/**
	 * Verifies behavior and game conditions in level 2
	 */
	public void validateRulesLevel2() {
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
 		if (this.getCrazyOgre().collision(this.hero.getLine(), this.hero.getCol())) {
				this.setGameOver(true);
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
			this.passed = true;
		
}
	/**
	 * Verifies guard behavior and game conditions in level 3
	 */
	
	public void validateRulesLevel3(){
		this.guard.move();

		if (this.board.gotKey(this.hero.getLine(), this.hero.getCol()))
			this.board.openDoors();

		if (this.guard.collision(this.hero.getLine(), this.hero.getCol()))
			this.setGameOver(true);
		
		if (this.crazyOgre.stun(this.hero.getLine(), this.hero.getCol())) {
			this.crazyOgre.setSymbol('8');
			this.crazyOgre.setStun();
		}
		
		if (this.board.foundDoor(this.hero.getLine(), this.hero.getCol()))
			this.passed = true;
		
	}
	/**
	 * Verifies Ogres and Club behavior and game conditions in level 4
	 */
	public void validateRulesLevel4() {
		for (int i = 0; i < this.ogres.length; i++) {
			
			if (!this.ogres[i].getStun()) {
				this.moveArrayOgres(ogres[i]);
				this.castClubArray( ogres[i] );
			}
			else {
				this.ogres[i].incStunCounter();
			}
		}

		if (this.board.gotKey(this.hero.getLine(), this.hero.getCol())) {
			this.board.openDoors();
			this.hero.setSymbol('K');
		}

		for (int i = 0; i < ogres.length; i++) {

			if (ogres[i].collision(hero.getLine(), hero.getCol()))
				this.setGameOver(true);

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

		if (this.board.foundDoor(this.hero.getLine(), this.hero.getCol()))
			this.ended = true;
	}

	/**
	 * Print objects symbols in the map board game for with level
	 * @param lin - number of line
	 * @param col - number of column
	 */
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
	/**
	 * Checks conditions when finishing level, game over and level change
	 */
	public void checkLevel() {
		if( this.passed && this.level == 4) {
			this.ended = true;
			this.gameover = true;
			
		}
		if (this.passed) {
			this.level++;
			this.setLevel();
			this.passed = false;
			}
	}
	/**
	 * Function that manages the display
	 */
	public void display() {
		this.print();

		if (this.ended) {
			System.out.print("PLAYER ONE WINS");
		}
		else if (this.gameover) {
			System.out.print("GAME OVER\n");		
		}
	}
	/**
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
	/**
	 * Imprime a disposicao actual do board na area de texto
	 */
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
	/**
	 * Actualiza a string passada para a area de texto da janela
	 * @param lin - line number
	 * @param col - column number
	 */
	public boolean updateMapping(int lin, int col) {

		if (this.hero.getLine() == lin &&  this.hero.getCol() == col) {
			mapping += this.hero.getSymbol() + " ";
			return true;
		}

		if (this.guard != null) {
			if (this.guard.getLine() == lin && this.guard.getCol() ==col) {
				this.mapping += this.guard.getSymbol() + " ";
				return true;
			}

		}

		if ( this.getLevelint() == 4 && ogres.length != 0) {

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
