package dkeep.cli;

import dkeep.logic.*;
import dkeep.logic.Guard;
import java.util.*;

public class game {

	static int escolha;

	// static char[][] board = board1;

	/**
	 * @ main function
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Door.setDoors();

	

		ArrayList<Guard> guardas = new ArrayList<Guard>();
		guardas.add(g1);
		guardas.add(g2);
		guardas.add(g3);

		Scanner s = new Scanner(System.in);
		boolean gameover = false;
		boolean newlevel = false;
		gamestate.startGame();
		while (gameover == false) {

			if (gamestate.mapa == gamemap.board1) {
				gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = gamestate.h1.getSymbol();

				for (Guard g : guardas) {
					gamestate.mapa[g.getLine()][g.getCol()] = g.getSymbol();
					if (gamestate.l1.getLine() != 0 || gamestate.l1.getCol() != 0) {
						gamestate.mapa[gamestate.l1.getLine()][gamestate.l1.getCol()] = gamestate.l1.getSymbol();
					}
				}

				// Random rand4 = new Random();
				// int r = rand4.nextInt(5);
				// switch (r) {
				// case (0):
				// return true;
				// default:
				// return false;
				// }

				for (char[] fora : gamestate.mapa) {
					for (char dentro : fora) {
						System.out.print(dentro);
					}
					System.out.println();
				}
				for (Guard g : guardas) {
					if (isGuardNear(g, gamestate.h1.getLine(), gamestate.h1.getCol())) {
						System.out.println("you lost");
						System.out.println("Game Over");
						gameover = true;
					}
				}
				if (newlevel == true) {
					System.out.println("You Won!");
					gamestate.startLevel(2);

					newlevel = false;
				} else {
					escolha = s.nextInt();
					for (Guard g : guardas) {
						moveGuard(g);
					}
					switch (escolha) {
					case 8:// para cima, muda linha
						if (gamestate.h1.getLine() != 0 && isBlank(gamestate.h1.getLine() - 1, gamestate.h1.getCol())) {
							gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = ' ';
							gamestate.h1.setLine(gamestate.h1.getLine() - 1);
						}
						break;
					case 2:// para baixo, muda linha
						if (gamestate.h1.getLine() != 9 && isBlank(gamestate.h1.getLine() + 1, gamestate.h1.getCol())) {
							gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = ' ';
							gamestate.h1.setLine(gamestate.h1.getLine() + 1);
						}
						break;
					case 4:// para esquerda, muda coluna
						if (gamestate.h1.getCol() != 0 && isBlank(gamestate.h1.getLine(), gamestate.h1.getCol() - 1)) {
							gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = ' ';
							gamestate.h1.setCol(gamestate.h1.getCol() - 1);
						}
						break;
					case 6:// para direita, muda coluna
						if (gamestate.h1.getCol() != 9 && isBlank(gamestate.h1.getLine(), gamestate.h1.getCol() + 1)) {
							gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = ' ';
							gamestate.h1.setCol(gamestate.h1.getCol() + 1);
						}
						break;
					}
				}
				if (isDoorOpen(gamestate.h1.getLine(), gamestate.h1.getCol())) {

					newlevel = true;
				}

				if (isLeverNear(gamestate.h1.getLine(), gamestate.h1.getCol())) {
					gamestate.mapa[5][0] = 'S';
					gamestate.mapa[6][0] = 'S';
				}

			}
			if (gamestate.mapa == gamemap.board2 && newlevel == false) {
				gamestate.mapa = gamemap.board2;
				gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = gamestate.h1.getSymbol();
				gamestate.mapa[gamestate.o1.getLine()][gamestate.o1.getCol()] = gamestate.o1.getSymbol();

				if (a1.getLine() != 0 || a1.getCol() != 0) {
					gamestate.mapa[a1.getLine()][a1.getCol()] = '*';
				}

				if (isLeverNear(gamestate.h1.getLine(), gamestate.h1.getCol())) {
					gamestate.h1.setSymbol('K');
				} else {
					gamestate.mapa[gamestate.l1.getLine()][gamestate.l1.getCol()] = 'k';
				}

				for (char[] fora : gamestate.mapa) {
					for (char dentro : fora) {
						System.out.print(dentro);
					}
					System.out.println();
				}
				if (isa1(gamestate.h1.getLine(), gamestate.h1.getCol())) {
					System.out.println("you lost");
					System.out.println("Game Over");
					gameover = true;
				}
				escolha = s.nextInt();
				moveOgre();

				switch (escolha) {
				case 8:// para cima, muda linha

					if (gamestate.h1.getLine() != 0 && (isBlank(gamestate.h1.getLine() - 1, gamestate.h1.getCol())
							|| gamestate.mapa[gamestate.h1.getLine() - 1][gamestate.h1.getCol()] == 'k')) {
						gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = ' ';
						gamestate.h1.setLine(gamestate.h1.getLine() - 1);

					}

					break;
				case 2:// para baixo, muda linha

					if (gamestate.h1.getLine() != 9 && (isBlank(gamestate.h1.getLine() + 1, gamestate.h1.getCol())
							|| gamestate.mapa[gamestate.h1.getLine() + 1][gamestate.h1.getCol()] == 'k')) {
						gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = ' ';
						gamestate.h1.setLine(gamestate.h1.getLine() + 1);

					}

					break;
				case 4:// para esquerda, muda coluna

					if (gamestate.h1.getCol() != 0 && (isBlank(gamestate.h1.getLine(), gamestate.h1.getCol() - 1)
							|| gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol() - 1] == 'k')) {
						gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = ' ';
						gamestate.h1.setCol(gamestate.h1.getCol() - 1);

					} else if (gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol() - 1] == 'I') {
						gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol() - 1] = 'S';
					} else if (gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] == 'S') {
						gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = ' ';
						gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol() - 1] = 'K';
						newlevel = true;
					}
					break;
				case 6:// para direita, muda coluna

					if (gamestate.h1.getCol() != 9 && (isBlank(gamestate.h1.getLine(), gamestate.h1.getCol() + 1)
							|| gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol() + 1] == 'k')) {
						gamestate.mapa[gamestate.h1.getLine()][gamestate.h1.getCol()] = ' ';
						gamestate.h1.setCol(gamestate.h1.getCol() + 1);

					}

					break;
				}

			} else if (gamestate.mapa == gamemap.board2 && newlevel == true) {
				System.out.println("YOU WON!!!");
			}
			// if (newlevel == true) {
			// System.out.println("YOU WON!");
			// }
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
				|| (col != 0 && gamestate.mapa[line][col - 1] == 'k')
				|| (col != 9 && gamestate.mapa[line][col + 1] == 'k'));
	}

	static boolean isGuardNear(Guard g, int line, int col) {
		return (line == g.getLine() && ((col == g.getCol() + 1) || (col == g.getCol() - 1))
				|| (col == g.getCol() && ((line == g.getLine() + 1) || (line == g.getLine() - 1))));

	}

	static boolean isa1(int line, int col) {
		return (line == a1.getLine() && ((col == a1.getCol() + 1) || (col == a1.getCol() - 1))
				|| (col == a1.getCol()
						&& ((line == a1.getLine() + 1) || (line == a1.getLine() - 1))));

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
		gamestate.mapa[a1.getLine()][a1.getCol()] = ' ';

		int passo = rand.nextInt(3);
		loop: switch (passo2int(passo)) {
		case 8:// para cima, muda linha
			if (!isBlank(gamestate.o1.getLine() - 1, gamestate.o1.getCol())) {
				passo = rand.nextInt(3);
				break loop;
			}
			if (gamestate.o1.getLine() != 0 && isBlank(gamestate.o1.getLine() - 1, gamestate.o1.getCol())) {
				gamestate.mapa[gamestate.o1.getLine()][gamestate.o1.getCol()] = ' ';
				gamestate.o1.setLine(gamestate.o1.getLine() - 1);
			}
			if (isLeverNear(gamestate.o1.getLine() - 1, gamestate.o1.getCol())) {
				gamestate.mapa[gamestate.o1.getLine()][gamestate.o1.getCol()] = ' ';
				gamestate.o1.setLine(gamestate.o1.getLine() - 1);
				gamestate.o1.setSymbol('$');
			}
			break;
		case 2:// para baixo, muda linha
			if (!isBlank(gamestate.o1.getLine() + 1, gamestate.o1.getCol())) {
				passo = rand.nextInt(3);
				break loop;
			}
			if (gamestate.o1.getLine() != 9 && isBlank(gamestate.o1.getLine() + 1, gamestate.o1.getCol())) {
				gamestate.mapa[gamestate.o1.getLine()][gamestate.o1.getCol()] = ' ';
				gamestate.o1.setLine(gamestate.o1.getLine() + 1);
			}
			if (isLeverNear(gamestate.o1.getLine() + 1, gamestate.o1.getCol())) {
				gamestate.mapa[gamestate.o1.getLine()][gamestate.o1.getCol()] = ' ';
				gamestate.o1.setLine(gamestate.o1.getLine() + 1);
				gamestate.o1.setSymbol('$');
			}
			break;
		case 4:// para esquerda, muda coluna
			if (!isBlank(gamestate.o1.getLine(), gamestate.o1.getCol() - 1)) {
				passo = rand.nextInt(3);
				break loop;
			}
			if (gamestate.o1.getCol() != 0 && isBlank(gamestate.o1.getLine(), gamestate.o1.getCol() - 1)) {
				gamestate.mapa[gamestate.o1.getLine()][gamestate.o1.getCol()] = ' ';
				gamestate.o1.setCol(gamestate.o1.getCol() - 1);
			}
			if (isLeverNear(gamestate.o1.getLine(), gamestate.o1.getCol() - 1)) {
				gamestate.mapa[gamestate.o1.getLine()][gamestate.o1.getCol()] = ' ';
				gamestate.o1.setLine(gamestate.o1.getCol() - 1);
				gamestate.o1.setSymbol('$');
			}
			break;
		case 6:// para direita, muda coluna
			if (!isBlank(gamestate.o1.getLine(), gamestate.o1.getCol() + 1)) {
				passo = rand.nextInt(3);
				break loop;
			}
			if (gamestate.o1.getCol() != 9 && isBlank(gamestate.o1.getLine(), gamestate.o1.getCol() + 1)) {
				gamestate.mapa[gamestate.o1.getLine()][gamestate.o1.getCol()] = ' ';
				gamestate.o1.setCol(gamestate.o1.getCol() + 1);
			}
			if (isLeverNear(gamestate.o1.getLine(), gamestate.o1.getCol() + 1)) {
				gamestate.mapa[gamestate.o1.getLine()][gamestate.o1.getCol()] = ' ';
				gamestate.o1.setLine(gamestate.o1.getCol() + 1);
				gamestate.o1.setSymbol('$');
			}
			break;
		}

		ciclo: switch (moca) {
		case 0:
			if (isBlank(gamestate.o1.getLine() - 1, gamestate.o1.getCol())) {
				a1.setLine(gamestate.o1.getLine() - 1);
				a1.setCol(gamestate.o1.getCol());
			} else {
				moca = rand2.nextInt(3);
				break ciclo;
			}
			break;
		case 1:
			if (isBlank(gamestate.o1.getLine() + 1, gamestate.o1.getCol())) {
				a1.setLine(gamestate.o1.getLine() + 1);
				a1.setCol(gamestate.o1.getCol());
			} else {
				moca = rand2.nextInt(3);
				break ciclo;
			}
			break;
		case 2:
			if (isBlank(gamestate.o1.getLine(), gamestate.o1.getCol() - 1)) {
				a1.setCol(gamestate.o1.getCol() - 1);
				a1.setLine(gamestate.o1.getLine());
			} else {
				moca = rand2.nextInt(3);
				break ciclo;
			}
			break;
		case 3:
			if (isBlank(gamestate.o1.getLine(), gamestate.o1.getCol() + 1)) {
				a1.setCol(gamestate.o1.getCol() + 1);
				a1.setLine(gamestate.o1.getLine());
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

	static void moveGuard(Guard g) {
		gamestate.mapa[g.getLine()][g.getCol()] = ' ';
		switch (g.getCol()) {
		case 1:// desce a nao ser que linha 6 ->
			if (g.getLine() != 6) {
				g.setLine(g.getLine() + 1);
			} else {
				g.setCol(g.getCol() + 1);
			}
			break;
		case 7:// desce a nao ser que linha 5 <-
			if (g.getLine() != 5 && g.getLine() != 6) {
				g.setLine(g.getLine() + 1);
			} else if (g.getLine() == 5) {
				g.setCol(g.getCol() - 1);
			} else if (g.getLine() == 6) {
				g.setCol(g.getCol() + 1);
			}
			break;
		case 8: // sobe a nao ser que linha 1 <-
			if (g.getLine() != 1 && g.getLine() != 6) {
				g.setLine(g.getLine() - 1);
			} else if (g.getLine() == 1) {
				g.setCol(g.getCol() - 1);
			} else if (g.getLine() == 6) {
				g.setLine(g.getLine() - 1);
			}
			break;
		default:// ver linhas
			switch (g.getLine()) {
			case 5: // esquerda a nao ser que coluna 1 que desce
				if (g.getCol() != 1) {
					g.setCol(g.getCol() - 1);
				} else {// desce
					g.setLine(g.getLine() + 1);
				}
				break;
			case 6: // direita a nao ser que coluna 8 que sobe
				if (g.getCol() != 8) {
					g.setCol(g.getCol() + 1);
				} else {// sobe
					g.setLine(g.getLine() - 1);
				}
				break;
			}
			break;

		}
	}
}
