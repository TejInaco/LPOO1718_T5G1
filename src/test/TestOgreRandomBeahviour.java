package test;
//import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;
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

	@Test // tirar o club do construtor do Ogre(int lin, int col)
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

	
	
	
	
}
