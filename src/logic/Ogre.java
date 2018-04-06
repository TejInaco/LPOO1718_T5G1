package logic;

public class Ogre extends BoardObject {
	
	private Club club;
	private boolean stun = false;
	private int stunCounter = 0;

	/**
	 * Default Constructor with defined position
	 */
	public Ogre() {
		super(4, 1, 'O');
		this.club = new Club(3,1); 
	}
	public Ogre(int lnh, int cln, int cubline, int cubcol) {
		super(lnh,cln);
		this.club = new Club(cubline,cubcol);
	}
	/**
	 * Constructor
	 * @param line number
	 * @param line column
	 */
	public Ogre(int lnh, int cln) {
		super(lnh,cln);
		this.club = new Club(3,1);
	}
	/**
	 * Get attribute club
	 * @return Class Object Club
	 */
	public Club getClub() {
		return this.club;
	}
	/**
	 * Get attribute stun
	 * @return true if stun is on or false otherwise
	 */
	public boolean getStun() {
		return this.stun;
	}
	/**
	 * Get attribute stunCounter
	 * @return counter number
	 */
	public int getStunCounter() {
		return this.stunCounter;
	}
	/**
	 * Set attribute stun
	 */
	public void setStun() {
		this.stun = true;
	}
	/**
	 * Set attribute club in a defined line and column
	 * @param lnh - line number
	 * @param clm - column number
	 */
	public void setClub(int lnh, int clm) {
		this.club.setLine(lnh);
		this.club.setCol(clm);
	}
	/**
	 * Increments the attribute stunCounter and if equal to 3, does a restart
	 */
	public void incStunCounter() {
		this.stunCounter++;

		if (this.stunCounter == 3) {
			this.stun = false;
			this.stunCounter = 0;
		}
	}
	/**
	 * 
	 */
	public boolean stun(int line, int col) {

		// caso esteja na mesma coluna que O
		if (this.line ==line) {
			if (this.col==col - 1 || this.col==col + 1)
				return true;
		}

		// caso esteja na mesma linha que O
		if (this.col==col) {
			if (this.line ==line - 1 || this.line ==line + 1)
				return true;
		}
		return false;
	}
	/**
	 * Function to deal with the collisions between hero and Ogre, and hero and *
	 * @param line - line number
	 * @param col - column number
	 * @return true if there is a collision or false otherwise
	 */
	public boolean collision(int line, int col) {
		// caso esteja na mesma linha e coluna que *
		if (line == this.getClub().getLine() &&
				col == this.getClub().getCol())  {
			return true;
		}
		// heroi a NO e a NE do Ogre
		if (col == this.getCol() - 1 && line == this.getLine() - 1 ) {
				return true;
		}
		if (col == this.getCol() + 1 && line == this.getLine() - 1 ) {
			return true;
		}
		// heroi a SO e a SE do Ogre
		if (col == this.getCol() - 1 && line == this.getLine() + 1 ) {
				return true;
		}
		if (col == this.getCol() + 1 && line == this.getLine() + 1 ) {
			return true;
		}
		// heroi a N
		if (col == this.getCol()  && line == this.getLine() - 1 ) {
			return true;
		}
		// heroi a S
		if (col == this.getCol()  && line == this.getLine() + 1 ) {
			return true;
		}
		// heroi a E
		if (col == this.getCol() + 1  && line == this.getLine() ) {
			return true;
		}
		// heroi a W
		if (col == this.getCol() - 1  && line == this.getLine() ) {
			return true;
		}
		return false;
	}

}
