package test;
import static org.junit.Assert.*;


import org.junit.Test;

//import logic.Hero;
import logic.Game;
import logic.Guard.GuardType;
//import logic.BoardObject;
//import logic.Club;
//import logic.Guard;
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
	public void validateRules_test() {
		Game jogo = new Game();
		Level lvl = new Level(3);
		jogo.setLevelObjec(lvl);
		jogo.setLevelInt(3);
		assertEquals(3, jogo.getLevelint() );
		Guard grd = new Guard(1,7,GuardType.ROOKIE);
		jogo.setGuard(grd);
		jogo.getHero().setCol(8);
		jogo.getHero().setLine(8);
		
		jogo.move(4);
		assertEquals(3,jogo.getLevelint() );
		assertTrue( jogo.getLevelObj().getisDoorsOpen() );
		jogo.getHero().setCol(0);
		jogo.getHero().setLine(5);
		jogo.validateRulesLevel3();
		assertTrue( jogo.getPassed() );	
	}
	@Test
	public void levelFoundDoorTsT() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevelObjec(levelTest);
		jogo.getLevelObj().openDoors();
		assertTrue( jogo.board.foundDoor(2, 0) );	
	}
	
	@Test
	public void LevelsetgetMaps(){
		Game jogo = new Game();
		//Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		assertSame(mapTest, jogo.getLevelObj().getMap() );
		assertFalse( jogo.getBoard().isDoorsOpen );
		jogo.getBoard().isDoorsOpen = true;
		assertTrue( jogo.getBoard().getisDoorsOpen() );
	}
	@Test
	public void LevelisEmpty(){
		Game jogo = new Game();
		jogo.setLevel(mapTest);
		assertFalse( jogo.getBoard().isEmpty(0, 0) );
		assertFalse( jogo.getBoard().isEmpty(2, 0) );
	}
	
	@Test
	public void LevelisEmptyArgs() {
		Game jogo = new Game();
		jogo.setLevel();
		try {
		
			assertTrue(jogo.getBoard().isEmpty(1, 1) );
			assertFalse(jogo.getBoard().isEmpty(0, 0) );
			
		} catch ( IllegalArgumentException e ) {}
//		jogo.getBoard().isEmpty(0, 10);
//		jogo.getBoard().isEmpty(10, 0);
//		jogo.getBoard().isEmpty(-1, 0);
//		jogo.getBoard().isEmpty(0, -1);
	}
//	@Test(expected=IllegalArgumentException.class)
//	public void LevelisEmptyArgs_1() throws IllegalArgumentException {
//		Game jogo = new Game();
//		//Level levelTest = new Level(mapTest);
//		jogo.setLevel(mapTest);
//		
//		jogo.getBoard().isEmpty(10, 0);
////		jogo.getBoard().isEmpty(-1, 0);
////		jogo.getBoard().isEmpty(0, -1);
//	}
//	@Test(expected=IllegalArgumentException.class)
//	public void LevelisEmptyArgs_2() throws IllegalArgumentException {
//		Game jogo = new Game();
//		//Level levelTest = new Level(mapTest);
//		jogo.setLevel(mapTest);
//		jogo.getBoard().isEmpty(-1, 0);
////		jogo.getBoard().isEmpty(0, -1);
//	}
//	@Test(expected=IllegalArgumentException.class)
//	public void LevelisEmptyArgs_3() throws IllegalArgumentException {
//		Game jogo = new Game();
//	//	Level levelTest = new Level(mapTest);
//		jogo.setLevel(mapTest);
//		assertTrue( jogo.getBoard().isEmpty(0, -1) );
//	}
	
	

	
//********************************************     Tests Predefinidos 			***********  
	@Test
	public void testMoveHeroToOgreAndDefeat() {
		Game jogo = new Game();
		//Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		Ogre ogreMal = new Ogre(2,4);
		jogo.setCrazyOgre(ogreMal);
		jogo.getHero().setLine(1);
		jogo.getHero().setCol(3);
		jogo.validateRulesLevel2();
		jogo.setCrazyOgre(ogreMal);
		assertTrue( jogo.getCrazyOgre().collision(1, 3) );
	}
	@Test
	public void testMoveToKeyAndKeyChangesRepresentation() {
		Game jogo = new Game();
		jogo.setLevel(mapTest);
		jogo.setLevelInt(2);
		Ogre ogremal = new Ogre(1,4);
		jogo.setCrazyOgre(ogremal);
		jogo.move(2);
		jogo.move(2);
		jogo.move(8);
		assertEquals(2, jogo.getHero().getLine() );
		assertEquals(1, jogo.getHero().getCol()  );
		assertEquals('K', jogo.getHero().getSymbol());
	}
	
	@Test
	public void testMoveToDoorWhitoutKeyAndFailsToLeave() {
		Game jogo = new Game();
		//Level levelTest = new Level(mapTest);
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
		//Level levelTest = new Level(mapTest);
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
		//Level levelTest = new Level(mapTest);
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

