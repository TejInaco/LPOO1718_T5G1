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

	@Test // tirar o club do construtor do Ogre(int lin, int col)
	public void testRandomBehaviour() {
		Game jogo = new Game();
		Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
	
		jogo.setLevelInt(2);
		Ogre ogreMal = new Ogre(2, 2);
		jogo.setCrazyOgre(ogreMal);
		jogo.move(ogreMal);
		assertTrue((ogreMal.getLine() != 2) || (ogreMal.getCol() != 2));
		assertEquals(3, jogo.getCrazyOgre().getClub().getLine());
		assertEquals(1, jogo.getCrazyOgre().getClub().getCol());
		jogo.castClub(ogreMal);
		assertTrue((ogreMal.getLine() != 3) || (ogreMal.getCol() != 1));
	}
	
	
	
	 
	
	@Test 
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
		assertFalse(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  !(jogo.getBoard().getisDoorsOpen()));
		assertTrue((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  !(jogo.getBoard().getisDoorsOpen()));
		assertFalse(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  (jogo.getBoard().getisDoorsOpen()));
		assertTrue((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  !(jogo.getBoard().getisDoorsOpen()));
		assertFalse(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  (jogo.getBoard().getisDoorsOpen()));
		assertTrue(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  !(jogo.getBoard().getisDoorsOpen()));
		assertTrue((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  (jogo.getBoard().getisDoorsOpen()));
		
		jogo.validateRulesLevel2();
		assertFalse(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  !(jogo.getBoard().getisDoorsOpen()));
		assertTrue((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  (jogo.getBoard().getisDoorsOpen()));
		assertFalse((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  !(jogo.getBoard().getisDoorsOpen()));
		assertFalse(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) &&  (jogo.getBoard().getisDoorsOpen()));
		assertTrue((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  !(jogo.getBoard().getisDoorsOpen()));
		assertTrue(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  (jogo.getBoard().getisDoorsOpen()));
	
		assertFalse(!(jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  !(jogo.getBoard().getisDoorsOpen()));
		assertTrue((jogo.getHero().getSymbol() == 'K' && 	jogo.getHero().getCol() == 1 && 	jogo.getHero().getLine() == 1) ||  (jogo.getBoard().getisDoorsOpen()));
	}

	
	@Test // tirar o club do construtor do Ogre(int lin, int col)
	public void testCollisionGameover() {
		Game jogo = new Game();
		jogo.setLevel (mapTest);
	
		assertEquals(1,jogo.getHero().getLine());
		assertEquals(1,jogo.getHero().getCol());
		assertFalse(jogo.getHero().getLine()!=1);
		assertFalse(jogo.getHero().getCol()!=1);
		Ogre ogreMal = new Ogre(1, 2);
		jogo.setCrazyOgre(ogreMal);
		assertEquals(1,jogo.getCrazyOgre().getLine());
		assertEquals(2,jogo.getCrazyOgre().getCol());
		jogo.validateRulesLevel2();
		
		assertTrue( ( jogo.getGameOver() && jogo.getCrazyOgre().collision(jogo.getHero().getLine(), jogo.getHero().getCol() ) ) ||( !( jogo.getGameOver() && !( jogo.getCrazyOgre().collision(jogo.getHero().getLine(), jogo.getHero().getCol() ) ) ) ) );
		assertFalse( ! (  jogo.getCrazyOgre().collision(jogo.getHero().getLine(), jogo.getHero().getCol() )  ) && ( jogo.getGameOver() ) );
	//if (this.getCrazyOgre().collision(this.hero.getLine(), this.hero.getCol())) {
		//this.setGameOver(true);
	
	}

	
	@Test // tirar o club do construtor do Ogre(int lin, int col)
	public void testKeyDollarAndStunOOOO() {
		Game jogo = new Game();
		jogo.setLevel (mapTest);
		
		assertFalse(!(jogo.getBoard().gotKey(jogo.getCrazyOgre().getCol(), jogo.getCrazyOgre().getLine()))&&(jogo.getCrazyOgre().getSymbol()=='$'  ));
		assertTrue(!(jogo.getBoard().gotKey(jogo.getCrazyOgre().getCol(), jogo.getCrazyOgre().getLine()))&&!(jogo.getCrazyOgre().getSymbol()=='$'  ));		

	}
	
	
	
	
	@Test 
	public void testKeyDollarAndClubAsterisk() {
		Game jogo = new Game();
		jogo.setLevel (mapTest);
		assertFalse((jogo.getBoard().gotKey(jogo.getCrazyOgre().getCol(), jogo.getCrazyOgre().getLine())) && (jogo.getCrazyOgre().getClub().getSymbol()=='*'  ));
		
	}

	


	

	@Test 
	public void testStun8() {
		Game jogo = new Game();
		jogo.setLevel (mapTest);
	assertFalse( !(jogo.getCrazyOgre().getStun()) && (jogo.getCrazyOgre().getSymbol()=='8' ) );
	assertTrue( !(jogo.getCrazyOgre().getStun()) && !(jogo.getCrazyOgre().getSymbol()=='8' ) );
	
	assertFalse( !(jogo.getCrazyOgre().getStun())  && (jogo.getCrazyOgre().getStun()) );
	assertTrue( !(jogo.getCrazyOgre().getStun())  && !(jogo.getCrazyOgre().getStun()) );
	}
	
	

	
	
	
}
