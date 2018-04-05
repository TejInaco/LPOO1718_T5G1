package cli;

import java.util.Scanner;

//import gui.GraphicsPanel;
import logic.Game;
 
/**
 * Main class Laucher 
 * */
public class Launcher { 
	
	/**
	 * Main fuction launcher
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Game game = new Game();
		game.setLevel();
		game.setGuard();
		game.setOgre();
		
	
		Scanner s = new Scanner(System.in);
		while (!game.gameover) {
			game.print();

			int escolha = s.nextInt();

			game.move(escolha);
		
			
		}
		//game.display();
		s.close();
		return;
	}
}