package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Game;
import logic.Guard;
import logic.Guard.GuardType;
import logic.Hero;

public class TestLevelOne {

		protected char[][] mapTest = { 
			{'X','X','X','X','X','X'},
			{'X','H',' ',' ','G','X'},
			{'I',' ',' ',' ',' ','X'},
			{'I','k',' ',' ',' ','X'},
			{'X','X','X','X','X','X'},
		};
	
 	 
	@Test
	public void doorsAndKey() {
		Game jogo = new Game();
		jogo.setLevel(mapTest);
		Guard grd = new Guard(4,1, GuardType.ROOKIE);
		jogo.setGuard(grd);
		assertFalse(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol()) || jogo.board.getisDoorsOpen() ); 
		assertTrue(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol()) || !(jogo.board.getisDoorsOpen())); 
		assertTrue(!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) || jogo.board.getisDoorsOpen()); 
		assertTrue(!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) || !(jogo.board.getisDoorsOpen()));
		
		assertFalse(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol()) && jogo.board.getisDoorsOpen() ); 
		assertTrue(!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) && !(jogo.board.getisDoorsOpen())); 
		assertFalse(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol()) && !(jogo.board.getisDoorsOpen())); 
		assertFalse(!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) && jogo.board.getisDoorsOpen());
		
		assertFalse(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())); 
		assertFalse(jogo.board.getisDoorsOpen());
		
		assertEquals(1, jogo.getHero().getLine());
		assertEquals(1, jogo.getHero().getCol());
		jogo.move(2);
		jogo.move(2);
		jogo.move(2);
		assertEquals(3,jogo.getHero().getLine()); 
		assertEquals(1,jogo.getHero().getCol()); 
		assertTrue(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())); 
		assertTrue(jogo.board.getisDoorsOpen());
		
		assertTrue(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol()) || jogo.board.getisDoorsOpen() ); 
		assertTrue(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol()) || !(jogo.board.getisDoorsOpen())); 
		assertTrue(!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) || jogo.board.getisDoorsOpen()); 
		assertFalse(!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) || !(jogo.board.getisDoorsOpen()));
		
		assertTrue(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol()) && jogo.board.getisDoorsOpen() ); 
		assertFalse(!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) && !(jogo.board.getisDoorsOpen())); 
		assertFalse(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol()) && !(jogo.board.getisDoorsOpen())); 
		assertFalse(!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) && jogo.board.getisDoorsOpen());
	
		assertTrue( ((jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) && (jogo.board.getisDoorsOpen() )) ||  ( (!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) && !(jogo.board.getisDoorsOpen() )) )) ;
		assertFalse( ((jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) && (jogo.board.getisDoorsOpen() )) &&  ( (!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) && !(jogo.board.getisDoorsOpen() )) )) ;
		assertTrue( ((jogo.getGuard().collision(jogo.getHero().getLine(), jogo.getHero().getCol())) && (jogo.getGameOver() ))  ||  ( (!((jogo.getGuard().collision(jogo.getHero().getLine(), jogo.getHero().getCol())) && !(jogo.getGameOver() ))) ));
		assertFalse( ((jogo.getGuard().collision(jogo.getHero().getLine(), jogo.getHero().getCol())) && (jogo.getGameOver() )) &&  ( (!((jogo.getGuard().collision(jogo.getHero().getLine(), jogo.getHero().getCol())) && !(jogo.getGameOver() ))) ));
	
		//lns 289 e 292 do Game (negated conditional)		
		assertFalse(!(jogo.board.gotKey(jogo.getHero().getLine(), jogo.getHero().getCol())) && (jogo.board.getisDoorsOpen())); 
		assertFalse( !(jogo.getGuard().collision(jogo.getHero().getLine(), jogo.getHero().getCol())) && (jogo.getGameOver() ));
	}

	
	@Test 
	public void testGuardCollisionGameOver() {
		Game jogo = new Game();
		jogo.setLevel(mapTest);
		Guard grd = new Guard(4,1, GuardType.ROOKIE);
		jogo.setGuard(grd);
		assertFalse( ! (  jogo.getGuard().collision(jogo.getHero().getLine(), jogo.getHero().getCol() )  ) && ( jogo.getGameOver() ) );
		assertTrue( ! (  jogo.getGuard().collision(jogo.getHero().getLine(), jogo.getHero().getCol() )  ) && !( jogo.getGameOver() ) );
		
	}
	
	


}
