package cli;
import logic.Game;
import logic.TakeOne;

import java.util.Scanner;


public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game game = new Game();
	game.setLevel(new TakeOne()); 
		game.setGuard();
		game.setOgre();
		game.print();
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