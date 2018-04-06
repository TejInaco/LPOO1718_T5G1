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

	public void setRandomOgreTest() {
		Game jogo = new Game();
		jogo.setLevelInt(4);
		jogo.setOgre();
		assertEquals(3, jogo.getCrazyOgreArray().length );
		Ogre grd = new Ogre();
		assertEquals( 2, jogo.getCrazyOgreArray()[0].getLine() );
	// 1 Ogre	
		assertEquals( 1, jogo.getCrazyOgreArray()[0].getCol() );
		assertEquals( 1, jogo.getCrazyOgreArray()[0].getClub().getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[0].getClub().getCol() );
	//2 Ogre	
		assertEquals( 4, jogo.getCrazyOgreArray()[1].getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[1].getCol() );
		assertEquals( 1, jogo.getCrazyOgreArray()[1].getClub().getCol() );
		assertEquals( 3, jogo.getCrazyOgreArray()[1].getClub().getLine() );
	//3 Ogre
		assertEquals( 6, jogo.getCrazyOgreArray()[2].getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[2].getCol() );
		assertEquals( 5, jogo.getCrazyOgreArray()[2].getClub().getLine() );
		assertEquals( 1, jogo.getCrazyOgreArray()[2].getClub().getCol() );
	}
		
//	@Test // tirar o club do construtor do Ogre(int lin, int col)
//	public void testRandomBehaviour() {
//		Game jogo = new Game();
//		Level levelTest = new Level(mapTest);
//		jogo.setLevel(mapTest);
//		jogo.setLevelInt(2);
//		Ogre ogreMal = new Ogre(2,2);
//		jogo.setCrazyOgre(ogreMal);
//		jogo.move(ogreMal);
//		assertTrue( (ogreMal.getLine() != 2) || (ogreMal.getCol() != 2) );
//		assertEquals(3, jogo.getCrazyOgre().getClub().getLine() );
//		jogo.castClub(ogreMal);
//		assertEquals(1, jogo.getCrazyOgre().getClub().getCol() );
//		assertTrue( (ogreMal.getLine() != 3) || (ogreMal.getCol() != 1) );
//	}
	
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
