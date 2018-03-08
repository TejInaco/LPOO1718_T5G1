package logic;

public interface Level {
	public boolean isEmpty(int x, int y);

	public boolean gotKey(int x, int y);

	public void openDoors();

	public boolean foundDoor(int x, int y);

	public char[][] getMap();
	public void setMap1(char[][] mp);
}
