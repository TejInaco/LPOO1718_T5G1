package logic;

public class Club extends BoardObject{
	/**
	 * Club constructor to use with Ogre
	 * @param ln line value
	 * @param clm column value
	 * */
	public Club(int ln, int clm) {
		super(ln,clm);
		this.symbol = '*';
	}
}
