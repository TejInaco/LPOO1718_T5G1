package logic;

import java.util.*;

public abstract class Level {

	protected char[][] map;
	protected Hero hero;
	protected Guard guard;
	protected ArrayList<Ogre> ogres;

	protected boolean lever = false;
	protected boolean ogreMove = false;
	protected boolean unlockDoor = false;

	public boolean isEmpty(int x, int y) {
		return false;
	}

	public boolean gotKey(int x, int y) {
		return false;
	}

	public void openDoors() {
	}

	public boolean foundDoor(int x, int y) {
		return false;
	}

	public char[][] getMap() {
		return null;
	}

	public Hero getHero() {
		return hero;

	}

	public void setLever(boolean lever) {
		this.lever = lever;
	}

	public void move(int dir) {};
	
	public Level goToNext() {
return null;
	}

	public void setHero(int lin, int col) {
		hero = new Hero(lin, col);
	}
	
	public void setGuard(int lin, int col) {
		hero = new Hero(lin, col);
	}
}
