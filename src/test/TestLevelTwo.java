package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Game;
import logic.Level;
import logic.Ogre;

public class TestLevelTwo {

	char[][] mapTest = { { 'X', 'X', 'X', 'X', 'X' },
						 { 'I', ' ', ' ', 'k', 'X' }, 
						 { 'X', ' ', ' ', 'O', 'X' },
						 { 'X', 'H', ' ', ' ', 'X' }, 
						 { 'X', 'X', 'X', 'X', 'X' } };

//	@Test // tirar o club do construtor do Ogre(int lin, int col)
//	public void testRandomBehaviour() {
//		Game jogo = new Game();
//		Level levelTest = new Level(mapTest);
//		jogo.setLevel(mapTest);
	
//		jogo.setLevelInt(2);
//		Ogre ogreMal = new Ogre(2, 2);
//		jogo.setCrazyOgre(ogreMal);
//		jogo.move(ogreMal);
//		assertTrue((ogreMal.getLine() != 2) || (ogreMal.getCol() != 2));
//		assertEquals(3, jogo.getCrazyOgre().getClub().getLine());
//		assertEquals(1, jogo.getCrazyOgre().getClub().getCol());
//		jogo.castClub(ogreMal);
//		assertTrue((ogreMal.getLine() != 3) || (ogreMal.getCol() != 1));
//	}
	@Test // tirar o club do construtor do Ogre(int lin, int col)
	public void testStunOgre() {
		Game jogo = new Game();
		jogo.setLevel (mapTest);
		Ogre ogreMal = new Ogre(2, 2);
		jogo.setCrazyOgre(ogreMal);
		assertEquals(1,jogo.getHero().getLine());
		assertEquals(1,jogo.getHero().getCol());
		assertFalse(jogo.getHero().getLine()!=1);
		assertFalse(jogo.getHero().getCol()!=1);
		jogo.getHero().setCol(1);
		jogo.getHero().setCol(3); 
		assertEquals(3,jogo.getHero().getCol());
		assertEquals(1,jogo.getHero().getLine());
		jogo.validateRulesLevel2();
		jogo.getHero().setCol(1);
		jogo.getHero().setCol(1); 
		assertEquals(1,jogo.getHero().getCol());
		assertEquals(1,jogo.getHero().getLine());
		assertFalse((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  (jogo.getBoard().getisDoorsOpen()));
		jogo.validateRulesLevel2();
		assertTrue((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  (jogo.getBoard().getisDoorsOpen()));
		assertFalse((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  !(jogo.getBoard().getisDoorsOpen()));
		assertFalse(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  (jogo.getBoard().getisDoorsOpen()));
		assertTrue((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  !(jogo.getBoard().getisDoorsOpen()));
		assertTrue(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  (jogo.getBoard().getisDoorsOpen()));
		assertTrue(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  (jogo.getBoard().getisDoorsOpen()));
	
	}
	
	
	
	
	

}
