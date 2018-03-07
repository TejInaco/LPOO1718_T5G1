package logic;

public class Hero extends BoardObject {

	public Hero(int line, int col) {
		super(line, col, 'H');
	}

	public Hero(int line, int col,char symbol) {
		super(line, col, symbol);
	}
}
