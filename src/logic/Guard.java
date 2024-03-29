package logic;

import java.util.Random;


public class Guard extends BoardObject {
	
	GuardType Type;
	private boolean inverted = false;

	public enum GuardType {
		ROOKIE("G"), DRUNKEN("G"), SUSPICIOUS("G");
 
		private String custom;
		
		/**
		 * Set GuarType according with structure
		 * @param custom string
		 */
		private GuardType(String custom) {
			this.custom = custom;
		}
		/**
		 * Get GuarType according with structure
		 */
		public String getCustomString() {
			return custom;
		}
		
	}
	/**
	 * Set Class Object Guard with a type of guard
 	 * @param lin -number line
	 * @param col - column number
	 * @param tipo - GuardType 
	 * */
	public void setGuard(int lin, int col,GuardType tipo) {
		new Guard(lin, col, tipo);
	}
	/**
	 * Default constructor
	 * @param nmb -number line
	 * @param nmb1 - column number
	 * @param g - symbol of the object can change between g or G
	 */
	public Guard(int nmb, int nmb1, char g) {
		super(nmb, nmb1, g);
		this.Type = GuardType.ROOKIE;
	}
	/**
	 * Constructor with a type of guard
	 * @param line -number line
	 * @param nmb1 - column number
	 * @param type - GuardType
	 */
	public Guard(int line, int col, GuardType type) {
		super(line, col, 'G');
		Type = type;
	}
	/**
	 * Get attribute Type
	 * @return enum struct type
	 */
	public GuardType getType() {
		return Type;
	}
	/**
	 * Get attribute inverted
	 * @return true or false if the route is inverted or not
	 */
	public boolean getInverted() {
		return this.inverted;
	}
	/**
	 * Set attribute inverted
	 */
	public void setInverted(boolean ft) {
		 this.inverted = ft;
	}
	/**
	 * Apply rules for the behavior and movement of which type of Guard
	 */
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
	/**
	 * Moves Guard in a defined route
	 */
	public void route() {
		int newlin = this.line;
		int newcol = this.col;

		// inverted route
		if (inverted) {
			if (this.line == 6) {
				if (this.col != 1) {
					newcol--;
				} else {
					newlin--;
				}
			} else if (this.col == 7) {
				if (this.line != 1) {
					newlin--;
				} else {
					newcol++;
				}

			} else if (this.col == 8) {
				newlin++;
			} else {
				newcol++;
			}

		} else {
			switch (this.col) {

			case 1:// desce a nao ser que linha 6 ->
				if (this.line != 6) {
					newlin++;
				} else {
					newcol++;
				}
				break;
			case 7:// desce a nao ser que linha 5 <-
				if (this.line != 5 && this.line != 6) {
					newlin++;
				} else if (this.line == 5) {
					newcol--;
				} else if (this.line == 6) {
					newcol++;
				}
				break;
			case 8: // sobe a nao ser que linha 1 <-
				if (this.line != 1 && this.line != 6) {
					newlin--;
				} else if (this.line == 1) {
					newcol--;
				} else if (this.line == 6) {
					newlin--;
				}
				break;
			default:// ver linhas
				switch (this.line) {
				case 5: // esquerda a nao ser que coluna 1 que desce
					if (this.col != 1) {
						newcol--;
					}
					break;
				case 6: // direita a nao ser que coluna 8 que sobe
					if (this.col != 8) {
						newcol++;
					}
					break;
				}
				break;
			}
		}
		this.col = newcol;
		this.line = newlin;

	}
	/**
	 * Defines rules for the collision between Guard and Hero
	 * @param lin - hero line
	 * @param col - hero column
	 */
	public boolean collision(int lin, int col) {

		if (this.getSymbol() == 'G') {// está acordado
			// heroi a NO e a 
			if (col == this.getCol() - 1 ) {
				// heroi a NO do Guarda
				if( lin == this.getLine() - 1 ) {
					return true;
				}
				// heroi a SO
				if( lin == this.getLine() + 1 ) {
					return true;
				}
			}
			
			if (col == this.getCol() + 1 ) {
				//heroi a NE do Guarda
				if( lin == this.getLine() - 1 ) {
					return true;
				}
				if( lin == this.getLine() + 1 ) {
					return true;
				}
			}
			
			if (col == this.getCol()){
				// heroi a N
				if(lin == this.getLine() - 1 ) {
					return true;
				}
				// heroi a S
				if ( lin == this.getLine() + 1 ) {
					return true;
				}
			}
			// heroi a E
			if( lin == this.getLine() ) {
				if (col == this.getCol() + 1 ) {
					return true;
				}
			// heroi a W
				if (col == this.getCol() - 1 ) {
					return true;
				}
			
			}
		}
		return false;
	}


}
