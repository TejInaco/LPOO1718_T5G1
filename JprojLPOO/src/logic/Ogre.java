package logic;

public class Ogre extends BoardObject {
	private Club club;

	private boolean stun = false;
	private int stunCounter = 0;

	public Ogre() {
		super(4, 1, 'O');
		club = new Club();
		club.Line = 3;
		club.Col = 1;
		club.Symbol = '*';
	}

	public Ogre(int lin, int col) {
		super(lin, col, 'O');
	
		this.getClub().setLine( lin - 1);
		this.getClub().setCol(col);
		this.getClub().setSymbol('*');
}



	public Club getClub() {
		return club;
	}

	

	public boolean getStun() {
		return stun;
	}

	public void setStun() {
		stun = true;
	}

	public int getStunCounter() {
		return stunCounter;
	}

	public void incStunCounter() {
		stunCounter++;

		if (stunCounter == 3) {
			stun = false;
			stunCounter = 0;
		}
	}

	public boolean stun(int line, int col) {

		// caso esteja na mesma coluna que O
		if (Line ==line) {
			if (Col==col - 1 || Col==col + 1)
				return true;
		}

		// caso esteja na mesma linha que O
		if (Col==col) {
			if (Line ==line - 1 || Line ==line + 1)
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
