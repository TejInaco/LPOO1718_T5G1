package cli;

import java.util.Scanner;
import logic.Game;
 
public class Launcher { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game game = new Game();
		game.setLevel();
		game.setGuard(); 
		game.setOgre();
		//game.print();
		Scanner s = new Scanner(System.in);
		while (!game.gameover) {
			game.print();

			int escolha = s.nextInt();

			game.move(escolha);

			game.display();
		}
		s.close();
		return;
	}
}