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
	public void tLevelFoundDoor() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevelObjec(levelTest);
		jogo.getLevelObj().openDoors();
		assertTrue( jogo.board.foundDoor(2, 0) );	
	}
	
	@Test
	public void tLevelsetgetMaps(){
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		assertSame(mapTest, jogo.getLevelObj().getMap() );
		assertFalse( jogo.getBoard().isDoorsOpen );
	}
	@Test
	public void tLevelisEmpty(){
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		assertFalse( jogo.getBoard().isEmpty(0, 0) );
		assertFalse( jogo.getBoard().isEmpty(2, 0) );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void tLevelisEmptyArgs() throws Exception {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		jogo.getBoard().isEmpty(0, 10);
		jogo.getBoard().isEmpty(10, 0);
		jogo.getBoard().isEmpty(-1, 0);
		jogo.getBoard().isEmpty(0, -1);
	}
	
	
//	Last Pit Mutation
//	BO 3
//	game 194
//	guard 60
//	guardtype 1
//	level 28
//	ogre 33
	
//********************************************     Tests Predefinidos 			***********  
	@Test
	public void testMoveHeroToOgreAndDefeat() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		jogo.setLevelInt(2);
		Ogre ogreMal = new Ogre(1,4);
		jogo.setCrazyOgre(ogreMal);
		jogo.getHero().setLine(1);
		jogo.getHero().setCol(3);
		jogo.validateRulesLevel2();
		assertTrue( jogo.getGameOver() );
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
		assertTrue( jogo.getHero().getLine() == 2 );
		assertTrue( jogo.getHero().getCol() == 1   );
		assertTrue( jogo.getHero().getSymbol() == 'K');
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
		assertTrue( jogo.board.gotKey( jogo.getHero().getLine(), jogo.getHero().getCol()	) );
		jogo.board.openDoors();
		assertTrue(	jogo.getLevelObj().getisDoorsOpen() ); 
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

