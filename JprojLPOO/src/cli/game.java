package dkeep.cli;

import dkeep.logic.*;

import java.util.*;

public class game {

	static int escolha;

	// static char[][] board = board1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Door.setDoors();

		Scanner s = new Scanner(System.in);
		boolean gameover = false;
		boolean newlevel = false;
		gamestate.startGame();
		while (gameover == false) {

			if (gamestate.mapa == gamemap.board1) {
				gamestate.mapa[Hero.getLine()][Hero.getCol()] = Hero
						.getSymbol();
				gamestate.mapa[Guard.getLine()][Guard.getCol()] = Guard
						.getSymbol();
				if (Lever.getLine() != 0 || Lever.getCol() != 0) {
					gamestate.mapa[Lever.getLine()][Lever.getCol()] = Lever
							.getSymbol();
				}
				for (char[] fora : gamestate.mapa) {
					for (char dentro : fora) {
						System.out.print(dentro);
					}
					System.out.println();
				}

				if (isGuardNear(Hero.getLine(), Hero.getCol())) {
					System.out.println("you lost");
					System.out.println("Game Over");
					gameover = true;
				}
				if (newlevel == true) {
					System.out.println("You Won!");
					gamestate.startLevel(2);

					newlevel = false;
				} else {
					escolha = s.nextInt();
					moveGuard();

					switch (escolha) {
					case 8:// para cima, muda linha
						if (Hero.getLine() != 0
								&& isBlank(Hero.getLine() - 1, Hero.getCol())) {
							gamestate.mapa[Hero.getLine()][Hero.getCol()] = ' ';
							Hero.setLine(Hero.getLine() - 1);
						}
						break;
					case 2:// para baixo, muda linha
						if (Hero.getLine() != 9
								&& isBlank(Hero.getLine() + 1, Hero.getCol())) {
							gamestate.mapa[Hero.getLine()][Hero.getCol()] = ' ';
							Hero.setLine(Hero.getLine() + 1);
						}
						break;
					case 4:// para esquerda, muda coluna
						if (Hero.getCol() != 0
								&& isBlank(Hero.getLine(), Hero.getCol() - 1)) {
							gamestate.mapa[Hero.getLine()][Hero.getCol()] = ' ';
							Hero.setCol(Hero.getCol() - 1);
						}
						break;
					case 6:// para direita, muda coluna
						if (Hero.getCol() != 9
								&& isBlank(Hero.getLine(), Hero.getCol() + 1)) {
							gamestate.mapa[Hero.getLine()][Hero.getCol()] = ' ';
							Hero.setCol(Hero.getCol() + 1);
						}
						break;
					}
				}
				if (isDoorOpen(Hero.getLine(), Hero.getCol())) {

					newlevel = true;
				}

				if (isLeverNear(Hero.getLine(), Hero.getCol())) {
					gamestate.mapa[5][0] = 'S';
					gamestate.mapa[6][0] = 'S';
				}

			}
			if (gamestate.mapa == gamemap.board2 && newlevel == false) {
				gamestate.mapa = gamemap.board2;
				gamestate.mapa[Hero.getLine()][Hero.getCol()] = Hero
						.getSymbol();
				gamestate.mapa[Ogre.getLine()][Ogre.getCol()] = Ogre
						.getSymbol();
				
				if (Asterisk.getLine() != 0 || Asterisk.getCol() != 0) {
					gamestate.mapa[Asterisk.getLine()][Asterisk.getCol()] = '*';
				}

				if (isKey(Hero.getLine(), Hero.getCol())) {
					Hero.setSymbol('K');
				}else{
					gamestate.mapa[Lever.getLine()][Lever.getCol()] = 'k';
				}

				for (char[] fora : gamestate.mapa) {
					for (char dentro : fora) {
						System.out.print(dentro);
					}
					System.out.println();
				}
				if (isAsterisk(Hero.getLine(), Hero.getCol())) {
					System.out.println("you lost");
					System.out.println("Game Over");
					gameover = true;
				}
				escolha = s.nextInt();
				moveOgre();

				switch (escolha) {
				case 8:// para cima, muda linha

					if (Hero.getLine() != 0
							&& (isBlank(Hero.getLine() - 1, Hero.getCol()) || gamestate.mapa[Hero
									.getLine() - 1][Hero.getCol()] == 'k')) {
						gamestate.mapa[Hero.getLine()][Hero.getCol()] = ' ';
						Hero.setLine(Hero.getLine() - 1);

					}

					break;
				case 2:// para baixo, muda linha

					if (Hero.getLine() != 9
							&& (isBlank(Hero.getLine() + 1, Hero.getCol()) || gamestate.mapa[Hero
									.getLine() + 1][Hero.getCol()] == 'k')) {
						gamestate.mapa[Hero.getLine()][Hero.getCol()] = ' ';
						Hero.setLine(Hero.getLine() + 1);

					}

					break;
				case 4:// para esquerda, muda coluna

					if (Hero.getCol() != 0
							&& (isBlank(Hero.getLine(), Hero.getCol() - 1) || gamestate.mapa[Hero
									.getLine()][Hero.getCol() - 1] == 'k')) {
						gamestate.mapa[Hero.getLine()][Hero.getCol()] = ' ';
						Hero.setCol(Hero.getCol() - 1);

					}else if (gamestate.mapa[Hero.getLine()][Hero.getCol() - 1] == 'I') {
						gamestate.mapa[Hero.getLine()][Hero.getCol() - 1] = 'S';
					} else if (gamestate.mapa[Hero.getLine()][Hero.getCol()] == 'S') {
						gamestate.mapa[Hero.getLine()][Hero.getCol() ] = ' ';
						gamestate.mapa[Hero.getLine()][Hero.getCol() - 1] = 'K';
						newlevel = true;
					}
					break;
				case 6:// para direita, muda coluna

					if (Hero.getCol() != 9
							&& (isBlank(Hero.getLine(), Hero.getCol() + 1) || gamestate.mapa[Hero
									.getLine()][Hero.getCol() + 1] == 'k')) {
						gamestate.mapa[Hero.getLine()][Hero.getCol()] = ' ';
						Hero.setCol(Hero.getCol() + 1);

					}

					break;
				}

			}else if(gamestate.mapa == gamemap.board2 && newlevel == true){
				System.out.println("YOU WON!!!");
			}
//			if (newlevel == true) {
//				System.out.println("YOU WON!");
//			}
		}
		s.close();
	}

	static boolean isWall(int line, int col) {
		return (gamestate.mapa[line][col] == 'X');
	}

	static boolean isBlank(int line, int col) {
		return (gamestate.mapa[line][col] == ' ' || gamestate.mapa[line][col] == 'S');
	}

	static boolean isLeverNear(int line, int col) {
		return ((line != 0 && gamestate.mapa[line - 1][col] == 'k')
				|| (line != 9 && gamestate.mapa[line + 1][col] == 'k')
				|| (col != 0 && gamestate.mapa[line][col - 1] == 'k') || (col != 9 && gamestate.mapa[line][col + 1] == 'k'));
	}

	static boolean isKey(int line, int col) {
		return ((line != 0 && gamestate.mapa[line - 1][col] == 'k')
				|| (line != 9 && gamestate.mapa[line + 1][col] == 'k')
				|| (col != 0 && gamestate.mapa[line][col - 1] == 'k') || (col != 9 && gamestate.mapa[line][col + 1] == 'k'));
	}

	static boolean isGuardNear(int line, int col) {
		return (line == Guard.getLine()
				&& ((col == Guard.getCol() + 1) || (col == Guard.getCol() - 1)) || (col == Guard
				.getCol() && ((line == Guard.getLine() + 1) || (line == Guard
				.getLine() - 1))));

	}

	static boolean isAsterisk(int line, int col) {
		return (line == Asterisk.getLine()
				&& ((col == Asterisk.getCol() + 1) || (col == Asterisk.getCol() - 1)) || (col == Asterisk
				.getCol() && ((line == Asterisk.getLine() + 1) || (line == Asterisk
				.getLine() - 1))));

	}

	static boolean isDoorNear(int line, int col) {
		return (gamestate.mapa[line][col] == ' ');
	}

	static boolean isDoorOpen(int line, int col) {
		return (gamestate.mapa[line][col] == 'S');
	}

	static void moveOgre() {

		Random rand = new Random();
		Random rand2 = new Random();
		int moca = rand2.nextInt(3);
		gamestate.mapa[Asterisk.getLine()][Asterisk.getCol()] = ' ';

		int passo = rand.nextInt(3);
		loop: switch (passo2int(passo)) {
		case 8:// para cima, muda linha
			if (!isBlank(Ogre.getLine() - 1, Ogre.getCol())) {
				passo = rand.nextInt(3);
				break loop;
			}
			if (Ogre.getLine() != 0
					&& isBlank(Ogre.getLine() - 1, Ogre.getCol())) {
				gamestate.mapa[Ogre.getLine()][Ogre.getCol()] = ' ';
				Ogre.setLine(Ogre.getLine() - 1);
			}
			if (isKey(Ogre.getLine() - 1, Ogre.getCol())) {
				gamestate.mapa[Ogre.getLine()][Ogre.getCol()] = ' ';
				Ogre.setLine(Ogre.getLine() - 1);
				Ogre.setSymbol('$');
			}
			break;
		case 2:// para baixo, muda linha
			if (!isBlank(Ogre.getLine() + 1, Ogre.getCol())) {
				passo = rand.nextInt(3);
				break loop;
			}
			if (Ogre.getLine() != 9
					&& isBlank(Ogre.getLine() + 1, Ogre.getCol())) {
				gamestate.mapa[Ogre.getLine()][Ogre.getCol()] = ' ';
				Ogre.setLine(Ogre.getLine() + 1);
			}
			if (isKey(Ogre.getLine() + 1, Ogre.getCol())) {
				gamestate.mapa[Ogre.getLine()][Ogre.getCol()] = ' ';
				Ogre.setLine(Ogre.getLine() + 1);
				Ogre.setSymbol('$');
			}
			break;
		case 4:// para esquerda, muda coluna
			if (!isBlank(Ogre.getLine(), Ogre.getCol() - 1)) {
				passo = rand.nextInt(3);
				break loop;
			}
			if (Ogre.getCol() != 0
					&& isBlank(Ogre.getLine(), Ogre.getCol() - 1)) {
				gamestate.mapa[Ogre.getLine()][Ogre.getCol()] = ' ';
				Ogre.setCol(Ogre.getCol() - 1);
			}
			if (isKey(Ogre.getLine(), Ogre.getCol() - 1)) {
				gamestate.mapa[Ogre.getLine()][Ogre.getCol()] = ' ';
				Ogre.setLine(Ogre.getCol() - 1);
				Ogre.setSymbol('$');
			}
			break;
		case 6:// para direita, muda coluna
			if (!isBlank(Ogre.getLine(), Ogre.getCol() + 1)) {
				passo = rand.nextInt(3);
				break loop;
			}
			if (Ogre.getCol() != 9
					&& isBlank(Ogre.getLine(), Ogre.getCol() + 1)) {
				gamestate.mapa[Ogre.getLine()][Ogre.getCol()] = ' ';
				Ogre.setCol(Ogre.getCol() + 1);
			}
			if (isKey(Ogre.getLine(), Ogre.getCol() + 1)) {
				gamestate.mapa[Ogre.getLine()][Ogre.getCol()] = ' ';
				Ogre.setLine(Ogre.getCol() + 1);
				Ogre.setSymbol('$');
			}
			break;
		}

		ciclo: switch (moca) {
		case 0:
			if (isBlank(Ogre.getLine() - 1, Ogre.getCol())) {
				Asterisk.setLine(Ogre.getLine() - 1);
				Asterisk.setCol(Ogre.getCol());
			} else {
				moca = rand2.nextInt(3);
				break ciclo;
			}
			break;
		case 1:
			if (isBlank(Ogre.getLine() + 1, Ogre.getCol())) {
				Asterisk.setLine(Ogre.getLine() + 1);
				Asterisk.setCol(Ogre.getCol());
			} else {
				moca = rand2.nextInt(3);
				break ciclo;
			}
			break;
		case 2:
			if (isBlank(Ogre.getLine(), Ogre.getCol() - 1)) {
				Asterisk.setCol(Ogre.getCol() - 1);
				Asterisk.setLine(Ogre.getLine());
			} else {
				moca = rand2.nextInt(3);
				break ciclo;
			}
			break;
		case 3:
			if (isBlank(Ogre.getLine(), Ogre.getCol() + 1)) {
				Asterisk.setCol(Ogre.getCol() + 1);
				Asterisk.setLine(Ogre.getLine());
			} else {
				moca = rand2.nextInt(3);
				break ciclo;
			}
			break;

		}

	}

	static int passo2int(int passo) {
		switch (passo) {
		case 0:
			return 8;
		case 1:
			return 4;
		case 2:
			return 2;
		case 3:
			return 6;
		}
		return 8;
	}

	static void moveGuard() {
		gamestate.mapa[Guard.getLine()][Guard.getCol()] = ' ';
		switch (Guard.getCol()) {
		case 1:// desce a nao ser que linha 6 ->
			if (Guard.getLine() != 6) {
				Guard.setLine(Guard.getLine() + 1);
			} else {
				Guard.setCol(Guard.getCol() + 1);
			}
			break;
		case 7:// desce a nao ser que linha 5 <-
			if (Guard.getLine() != 5 && Guard.getLine() != 6) {
				Guard.setLine(Guard.getLine() + 1);
			} else if (Guard.getLine() == 5) {
				Guard.setCol(Guard.getCol() - 1);
			} else if (Guard.getLine() == 6) {
				Guard.setCol(Guard.getCol() + 1);
			}
			break;
		case 8: // sobe a nao ser que linha 1 <-
			if (Guard.getLine() != 1 && Guard.getLine() != 6) {
				Guard.setLine(Guard.getLine() - 1);
			} else if (Guard.getLine() == 1) {
				Guard.setCol(Guard.getCol() - 1);
			} else if (Guard.getLine() == 6) {
				Guard.setLine(Guard.getLine() - 1);
			}
			break;
		default:// ver linhas
			switch (Guard.getLine()) {
			case 5: // esquerda a nao ser que coluna 1 que desce
				if (Guard.getCol() != 1) {
					Guard.setCol(Guard.getCol() - 1);
				} else {// desce
					Guard.setLine(Guard.getLine() + 1);
				}
				break;
			case 6: // direita a nao ser que coluna 8 que sobe
				if (Guard.getCol() != 8) {
					Guard.setCol(Guard.getCol() + 1);
				} else {// sobe
					Guard.setLine(Guard.getLine() - 1);
				}
				break;
			}
			break;

		}
	}
}
