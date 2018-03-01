package dkeep.logic;

public class Ogre extends gameObject{
	 int line = 1;
	 int col = 4;
	 char symbol = 'O';
	 tipoOgre tipo;
	 
	 public enum tipoOgre {
			NORMAL
		}
	
	 public char getSymbol() {
		return symbol;
	}
	
	 public void setSymbol(char simbolo) {
		 symbol=simbolo;
	}

	 public int getLine() {
		return line;
	}

	 public int getCol() {
		return col;
	}

	 public void setLine(int linha) {
		line = linha;
	}

	 public void setCol(int coluna) {
			col = coluna;
	}
	 
	 public Ogre(tipoOgre tipoO, int lin, int column) {
		 tipo=tipoO;
		 line=lin;
		 col=column;
	 }
}
