package logic;

/**
 * Class Board Object 
 * Objects on the board, future extended class
 */
public class BoardObject {
	protected int line;
	protected int col;
	protected char symbol; 
	
	/**
	 * Constructor Board Object
	 * @param lin board line
	 * @param column board column
	 * @param symb board symbol for the object
	 */
	public BoardObject(int lin, int column, char symb) {
		line = lin;
		col = column;
		symbol = symb;
	}
	/**
	 * Constructor Board Object
	 * @param lin value board line
	 * @param column board column
	 */
	public BoardObject(int lin, int column) {
		line = lin;
		col = column;
	}
	/**
	 * Get method line
	 * @return line number value
	 */
	public int getLine() {
		return this.line;
	}
	/**
	 * Get method column
	 * @return column number value
	 */
	public int getCol() {
		return this.col;
	}
	/**
	 * Get method symbol
	 * @return char symbol
	 */
	public char getSymbol() {
		return this.symbol;
	}
	/**
	 * Set method line
	 * @param column number
	 */
	public void setLine(int lne) {
		this.line = lne;
	}
	/**
	 * Set method column
	 * @param column number
	 */
	public void setCol(int cl) {
		this.col = cl;
	}
	/**
	 * Set symbol of representation
	 * @param board object symbol of representation
	 */
	public void setSymbol(char symbl) {
		this.symbol = symbl;
	}
	
}
