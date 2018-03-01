package dkeep.logic;

import dkeep.cli.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Guard extends gameObject {
	static int line;
	static int col;
	static char symbol = 'G';
	static tipoGuarda tipo;

	public enum tipoGuarda {
		NORMAL, ROOKIE, DRUNKEN, SUSPICIOUS
	}

	Random rand3 = new Random();

	Guard(tipoGuarda tipoG) {
		boolean aceite = false;
		
		while (!aceite) {
		int tmp1 = rand3.nextInt() % 10;
		int tmp2 = rand3.nextInt() % 10;
		
//		if (isBlank(tmp1,tmp2)) {
//			aceite=true;
//			line=tmp1;
//			col=tmp2;
//		}
		
	
	}
		col = rand3.nextInt() % 10;
		tipo = tipoG;
	}

	static public tipoGuarda getTipo() {
		return tipo;
	}

	static public void setTipo(tipoGuarda tipoG) {
		tipo = tipoG;
	}

	static public char getSymbol() {
		return symbol;
	}

	static public void setSymbol(char simbolo) {
		symbol = simbolo;
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
