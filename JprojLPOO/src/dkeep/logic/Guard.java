package dkeep.logic;

import dkeep.cli.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Guard extends gameObject {
	int line;
	int col;
	char symbol = 'G';
	tipoGuarda tipo;
	boolean asleep;

	public enum tipoGuarda {
		NORMAL, ROOKIE, DRUNKEN, SUSPICIOUS
	}

	Random rand3 = new Random();

	public Guard(tipoGuarda tipoG) {
		boolean aceite = false;

		while (!aceite) {
			int tmp1 = rand3.nextInt() % 10;
			int tmp2 = rand3.nextInt() % 10;

			if (gamestate.mapa[tmp1][tmp2] == ' ') {
				aceite = true;
				line = tmp1;
				col = tmp2;
			}

		}
		col = rand3.nextInt() % 10;
		tipo = tipoG;
	}
	
	
	public Guard(tipoGuarda tipoG, int lin, int column) {
		line=lin;
		col=column;
		tipo=tipoG;
	}
	
	

	public tipoGuarda getTipo(Guard g) {
		return g.tipo;
	}

	public void setTipo(Guard g,tipoGuarda tipoG) {
		g.tipo = tipoG;
	}

	public char getSymbol(Guard g) {
		return g.symbol;
	}

	public void setSymbol(Guard g,char simbolo) {
		g.symbol = simbolo;
	}

	public int getLine(Guard g) {
		return g.line;
	}

	public int getCol(Guard g) {
		return g.col;
	}

	public void setLine(Guard g,int linha) {
		g.line = linha;
	}

	public void setCol(Guard g,int coluna) {
		g.col = coluna;
	}

	public void putToSleep(Guard g) {
		g.asleep = true;
	}
	
	public boolean isAsleep(Guard g) {
		return g.asleep;
	}

}
