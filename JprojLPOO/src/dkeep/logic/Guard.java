package dkeep.logic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Guard extends gameObject{
	static int line ;
	static int col ;
	static char symbol ='G';
	static tipoGuarda tipo;
	 
	Random rand3 = new Random();
Guard(tipoGuarda tipoG){
	
	int tmp=rand3.nextInt()%10;
//while (gamemap.board1[])
	col=rand3.nextInt()%10; 
	tipo=tipoG;
	}
	
	public enum tipoGuarda {
	    NORMAL, ROOKIE, DRUNKEN, SUSPICIOUS
	}
	
	static public tipoGuarda getTipo() {
		return tipo;
	}

	static public void setTipo(tipoGuarda tipoG) {
		tipo=tipoG;
	}
	
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
