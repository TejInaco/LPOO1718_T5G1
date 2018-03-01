package dkeep.logic;



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
		switch (nivel) {

		case 1:
			setMap(gamemap.board1);
			Hero.setCol(1);
			Hero.setLine(1);
			Guard.setLine(1);
			Guard.setCol(8);
			Lever.setLine(8);
			Lever.setCol(7);
			Lever.setSymbol('k');

			break;

		case 2:
			setMap(gamemap.board2);
			Ogre.setLine(1);
			Ogre.setCol(4);
			Hero.setCol(1);
			Hero.setLine(8);
			Lever.setCol(8);
			Lever.setLine(1);
			Lever.setSymbol('k');

			break;
		}
	}

}
