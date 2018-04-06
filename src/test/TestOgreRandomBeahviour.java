package test;
//import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import logic.*;

public class TestOgreRandomBeahviour {

	char[][] mapTest = { 
			{ 'X', 'X', 'X', 'X', 'X' }, 
			{ 'I', ' ', ' ', 'k', 'X' }, 
			{ 'X', ' ', ' ', 'O', 'X' },
			{ 'X', 'H', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X' } };

	@Test 
	public void testRandomBehaviour() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		jogo.setLevelInt(2);
		Ogre ogreMal = new Ogre(2,2);
		jogo.setCrazyOgre(ogreMal);
		jogo.move(ogreMal);
		assertTrue( (ogreMal.getLine() != 2) || (ogreMal.getCol() != 2) );
		assertEquals(3, jogo.getCrazyOgre().getClub().getLine() );
		assertEquals(1, jogo.getCrazyOgre().getClub().getCol() );
		jogo.castClub(ogreMal);
		assertTrue( (ogreMal.getLine() != 3) || (ogreMal.getCol() != 1) );
	}
	@Test 
	public void setRandomOgreTest() {
		Game jogo = new Game();
		jogo.setLevelInt(4);
		jogo.setOgre();
		Ogre grd = new Ogre();
		assertEquals(3, jogo.getCrazyOgreArray().length );
	// 1 Ogre	
		assertEquals( 2, jogo.getCrazyOgreArray()[0].getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[0].getCol() );
		assertEquals( 1, jogo.getCrazyOgreArray()[0].getClub().getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[0].getClub().getCol() );
	//2 Ogre	
		assertEquals( 4, jogo.getCrazyOgreArray()[1].getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[1].getCol() );
		assertEquals( 3, jogo.getCrazyOgreArray()[1].getClub().getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[1].getClub().getCol() );
	//3 Ogre
		assertEquals( 6, jogo.getCrazyOgreArray()[2].getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[2].getCol() );
		assertEquals( 5, jogo.getCrazyOgreArray()[2].getClub().getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[2].getClub().getCol() );
		
	}
	@Test 
	public void moveArrayogresTest() {
		Game jogo = new Game();
		jogo.setLevelInt(4);
		Ogre grd = new Ogre(2,2);
		jogo.setLevel(mapTest);
		jogo.moveArrayOgres(grd);
		assertNotEquals( 1, grd.getLine() );
	
	}
	@Test 
	public void checkLevel() {
		Game jogo = new Game();
		jogo.setLevelInt(1);
		assertFalse( jogo.getPassed() );
		jogo.setPassed(true);
		assertTrue( jogo.getPassed() );
		jogo.checkLevel();
		assertEquals(2, jogo.getLevelint());
		assertEquals(8, jogo.getHero().getLine() );
		assertEquals(1, jogo.getHero().getCol() ); 
		assertFalse( jogo.getPassed() );
		jogo.setLevelInt(3);
		jogo.setLevel();
		assertEquals(3, jogo.getLevelint());
		assertEquals(1, jogo.getHero().getLine() );
		assertEquals(1, jogo.getHero().getCol() ); 
		jogo.setLevelInt(4);
		jogo.setLevel();
		assertEquals(4, jogo.getLevelint());
		assertEquals(8, jogo.getHero().getLine() );
		assertEquals(8, jogo.getHero().getCol() ); 
		jogo.setPassed(true);
		jogo.checkLevel();
		assertTrue( jogo.getGameOver() );
		assertTrue( jogo.ended );
	
	}
	
	
	
}
