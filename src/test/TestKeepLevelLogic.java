package test;
import static org.junit.Assert.*;


import org.junit.Test;

import logic.Hero;
import logic.Game;
import logic.BoardObject;
import logic.Club;
import logic.Guard;
import logic.Level;
import logic.Ogre;
import logic.*;

public class TestKeepLevelLogic {

	protected char[][] mapTest = {
			{'X','X','X','X','X','X'},
			{'X','H',' ',' ',' ','X'},
			{'I',' ',' ',' ',' ','X'},
			{'I','k',' ',' ',' ','X'},
			{'X','X','X','X','X','X'},
		};


	@Test
	public void testMoveHeroToOgreAndDefeat() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		jogo.setLevelInt(2);
		Ogre ogreMal = new Ogre(1,4);
		jogo.setCrazyOgre(ogreMal);
		jogo.move(6);
		jogo.getCrazyOgre().setLine(1);
		jogo.getCrazyOgre().setCol(3);
		jogo.move(6);
		assertTrue(jogo.getGameOver());
	}
	@Test
	public void testMoveToKeyAndKeyChangesRepresentation() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		jogo.setLevelInt(2);
		Ogre ogreMal = new Ogre(1,4);
		jogo.setCrazyOgre(ogreMal);
		jogo.move(2);
		jogo.move(2);
		jogo.move(8);
		assertTrue(jogo.getHero().getLine() == 2);
		assertTrue(jogo.getHero().getCol() == 1);
		assertTrue(jogo.getHero().getSymbol() == 'K');
	}
	
	@Test
	public void testMoveToDoorWhitoutKeyAndFailsToLeave() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		jogo.setLevelInt(2);
		Ogre ogreMal = new Ogre(1,4);
		jogo.setCrazyOgre(ogreMal);
		jogo.move(2);
		jogo.move(4);
		assertFalse(jogo.getPassed());
	}
	
	@Test
	public void testMoveToDoorWithKeyAndDoorsOpen() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		jogo.setLevelInt(2);
		Ogre ogreMal = new Ogre(1,4);
		jogo.setCrazyOgre(ogreMal);
		jogo.move(2);
		jogo.move(2);
		assertTrue(jogo.getLevelObj().getisDoorsOpen());
	}
	
	@Test
	public void testMoveToDoorWithKeyAndVictory() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		jogo.setLevelInt(2);
		Ogre ogreMal = new Ogre(1,4);
		jogo.setCrazyOgre(ogreMal);
		jogo.move(2);
		jogo.move(2);
		jogo.move(4);
		assertFalse(jogo.getPassed());
	}
	
}

