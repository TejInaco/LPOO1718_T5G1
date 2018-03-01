package dkeep.logic;

public class Ogre extends gameObject{
	static int line = 1;
	static int col = 4;
	static char symbol = 'O';
	
	static public char getSymbol() {
		return symbol;
	}
	
	static public void setSymbol(char simbolo) {
		 symbol=simbolo;
	}

	static public int getLine() {
		return line;
	}

	static public int getCol() {
		return col;
	}

	static public void setLine(int linha) {
		line = linha;
	}

	static public void setCol(int coluna) {
			col = coluna;
	}
}
