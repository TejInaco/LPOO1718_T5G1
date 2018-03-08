package logic;

import java.util.Random;

public class Guard extends BoardObject {
	GuardType Type;
	private static boolean inverted = false;

	enum GuardType {

		ROOKIE("G"), DRUNKEN("G"), SUSPICIOUS("G");

		private String custom;

		private GuardType(String custom) {
			this.custom = custom;
		}

		public String getCustomString() {
			return custom;
		}

	}

	public Guard(int line, int col, GuardType type) {
		super(line, col, 'G');
		Type = type;
	}

	public void move() {
		switch (Type) {

		case DRUNKEN:
			Random r1 = new Random();
			Random r2 = new Random();

			int i = r1.nextInt(4);
			int j = r2.nextInt(4);

			if (i == 0) {
				this.setSymbol('g');
			} else {

				this.setSymbol('G');

				if (j == 0)
					inverted = true;
				else
					inverted = false;

				route();
			}
			break;
		case SUSPICIOUS:

			Random r = new Random();

			int rand = r.nextInt(4);

			if (rand == 0)
				inverted = true;
			else
				inverted = false;

			route();

			break;
		default:
			route();
			break;
		}
	}

	public void route() {
		int newlin = Line;
		int newcol = Col;

		// inverted route
		if (inverted) {
			if (Line == 6) {
				if (Col != 1) {
					newcol--;
				} else {
					newlin--;
				}
			} else if (Col == 7) {
				if (Line != 1) {
					newlin--;
				} else {
					newcol++;
				}

			} else if (Col == 8) {
				newlin++;
			} else {
				newcol++;
			}

		} else {// normal route

			// if (Col == 8) {
			// if (Line != 1) {
			// newlin--;
			// } else {
			// newcol--;
			// }
			// } else if (Col == 7) {
			// if (Line != 5) {
			// newlin++;
			// } else {
			// newcol--;
			// }
			// } else if (Line == 6) {
			// newcol++;
			// } else if (Col != 1) {
			// newlin++;
			// } else
			// newcol--;
			// }

			switch (Col) {

			case 1:// desce a nao ser que linha 6 ->
				if (Line != 6) {
					newlin++;
				} else {
					newcol++;
				}
				break;
			case 7:// desce a nao ser que linha 5 <-
				if (Line != 5 && Line != 6) {
					newlin++;
				} else if (Line == 5) {
					newcol--;
				} else if (Line == 6) {
					newcol++;
				}
				break;
			case 8: // sobe a nao ser que linha 1 <-
				if (Line != 1 && Line != 6) {
					newlin--;
				} else if (Line == 1) {
					newcol--;
				} else if (Line == 6) {
					newlin--;
				}
				break;
			default:// ver linhas
				switch (Line) {
				case 5: // esquerda a nao ser que coluna 1 que desce
					if (Col != 1) {
						newcol--;
					} else {// desce
						newlin++;
					}
					break;
				case 6: // direita a nao ser que coluna 8 que sobe
					if (Col != 8) {
						newcol++;
					} else {// sobe
						newlin--;
					}
					break;
				}
				break;
			}
		}
		Col = newcol;
		Line = newlin;

	}

	public boolean collision(int lin, int col) {

		if (this.getSymbol() == 'G') {// está acordado

			// caso esteja na mesma linha que G
			if (lin == getLine()) {

				if (col == this.getCol() || col == this.getCol() - 1 || col == this.getCol() + 1)
					return true;
			}

			// caso esteja na mesma coluna que G
			if (col == this.getCol()) {
				if (lin == this.getLine() || lin == this.getLine() - 1 || lin == this.getLine() + 1)
					return true;
			}
		}

		return false;
	}

	public GuardType getType() {
		return Type;
	}

}
