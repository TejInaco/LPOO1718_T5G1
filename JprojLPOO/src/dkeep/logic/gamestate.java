package dkeep.logic;

import dkeep.logic.Guard.tipoGuarda;
import dkeep.logic.Ogre.*;

public class gamestate {
	public static Hero heroi;
	public static Guard guarda;
	public static Ogre ogre;
	public static Lever chave;
	public static Lever alavanca;
	public static Asterisk moca;
	static public char[][] mapa = gamemap.board1;

	static void setMap(char[][] mapa1) {
		mapa = mapa1;
	}

	static String getMap() {
		return mapa.toString();
	}

	public static void startGame() {
		startLevel(1);
	}

	public static void startLevel(int nivel) {
		Hero h1 = new Hero(1, 1);
		Guard g1 = new Guard(tipoGuarda.ROOKIE, 1, 8);
		Guard g2 = new Guard(tipoGuarda.DRUNKEN);
		Guard g3 = new Guard(tipoGuarda.SUSPICIOUS);
		Lever l1 = new Lever(8, 7, 'k');

		switch (nivel) {

		case 1:
			setMap(gamemap.board1);

			break;

		case 2:
			setMap(gamemap.board2);
			Ogre o1 = new Ogre(tipoOgre.NORMAL, 1, 4);
			Asterisk a1 = new Asterisk();
			h1.setCol(1);
			h1.setLine(8);
			l1.setCol(8);
			l1.setLine(1);
			l1.setSymbol('k');

			break;
		}
	}

}
