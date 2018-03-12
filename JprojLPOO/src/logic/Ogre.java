package logic;

public class Ogre extends BoardObject {
	
	private Club club;
	private boolean stun = false;
	private int stunCounter = 0;

	public Ogre() {
		super(4, 1, 'O');
		club = new Club();
		this.club.line = 3;
		this.club.col = 1;
		this.club.symbol = '*'; 
	}

	public Club getClub() {
		return this.club;
	}

	

	public boolean getStun() {
		return this.stun;
	}

	public void setStun() {
		this.stun = true;
	}

	public int getStunCounter() {
		return this.stunCounter;
	}

	public void incStunCounter() {
		this.stunCounter++;

		if (this.stunCounter == 3) {
			this.stun = false;
			this.stunCounter = 0;
		}
	}

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

	public boolean collision(int line, int col) {

		// caso esteja na mesma coluna que *
		if (line ==getClub().getLine()) {

			if (col==getClub().getCol() - 1 || col==getClub().getCol() + 1)
				return true;
		}

		// caso esteja na mesma linha que *
		if (col==getClub().getCol()) {
			if (line ==getClub().getLine() - 1 ||line==getClub().getLine() + 1)
				return true;
		}

		return false;
	}

}
