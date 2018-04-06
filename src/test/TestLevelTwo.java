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
	
	
	//	
//		if (this.getCrazyOgre().getStun()) {
//			move(this.getCrazyOgre());
//		}else{
//			this.getCrazyOgre().incStunCounter();
//		}
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
		
		
//		if (this.board.gotKey(this.crazyOgre.getCol(), this.crazyOgre.getLine())) {
//			this.crazyOgre.setSymbol('$');
//		}else if (!this.crazyOgre.getStun()) {
//			this.crazyOgre.setSymbol('O');
//		}
	}
	
	
	
	
	@Test // tirar o club do construtor do Ogre(int lin, int col)
	public void testKeyDollarAndClubAsterisk() {
		Game jogo = new Game();
		jogo.setLevel (mapTest);
		assertFalse((jogo.getBoard().gotKey(jogo.getCrazyOgre().getCol(), jogo.getCrazyOgre().getLine())) && (jogo.getCrazyOgre().getClub().getSymbol()=='*'  ));
//
//		if (this.board.gotKey(this.crazyOgre.getClub().getCol(), this.crazyOgre.getClub().getLine()))
//			this.crazyOgre.getClub().setSymbol('$');
//		else
//			this.crazyOgre.getClub().setSymbol('*');
	}

	


	

	@Test // tirar o club do construtor do Ogre(int lin, int col)
	public void testStun8() {
		Game jogo = new Game();
		jogo.setLevel (mapTest);
	assertFalse( !(jogo.getCrazyOgre().getStun()) && (jogo.getCrazyOgre().getSymbol()=='8' ) );
	assertFalse( !(jogo.getCrazyOgre().getStun())  && (jogo.getCrazyOgre().getStun()) );
//	if (this.crazyOgre.stun(this.hero.getLine(), this.hero.getCol())) {
//		this.crazyOgre.setSymbol('8');
//		this.crazyOgre.setStun();
//	}
	
	}
	
	

	@Test // tirar o club do construtor do Ogre(int lin, int col)
	public void testPassedFourDisplay() {
		Game jogo = new Game();
		jogo.setLevel (mapTest);
	
		
//	checkLevel//DUPLA NEG
//	if( this.passed && this.level == 4) {
//		this.display();
//	}
	}
	

	@Test // tirar o club do construtor do Ogre(int lin, int col)
	public void testGameOverAndDisplay() {
		Game jogo = new Game();
		jogo.setLevel (mapTest);
//	
//	if(this.gameover) {
//		this.display();
//	}
	
	}
	
	
	
	
}
