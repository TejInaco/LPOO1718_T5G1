/**
 * 
 */
package test;
import static org.junit.Assert.*;


import org.junit.Test;

//import logic.Hero;
import logic.Game;
//import logic.BoardObject;
//import logic.Club;
import logic.Guard;
//import logic.Level;
//import logic.Ogre;
//import logic.*;
/**
 * @author notus
 *
 */
public class TestHeroLogic {

	protected char[][] mapTest = { 
			{'X','X','X','X','X','X'},
			{'X','H',' ',' ','G','X'},
			{'I',' ',' ',' ',' ','X'},
			{'I','k',' ',' ',' ','X'},
			{'X','X','X','X','X','X'},
		};
	@Test
	public void testMoveHeroIntoCell() {
		Game jogo = new Game(); 
		//Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		//Posicao inicial
		
		assertEquals(1, jogo.getHero().getLine());
		assertEquals(1, jogo.getHero().getCol());
		//Movimento
		Guard grd = new Guard(1,4,'G');
		jogo.setGuard(grd);
		jogo.move(2); //down
		assertEquals(2, jogo.getHero().getLine());
		assertEquals(1, jogo.getHero().getCol());
		jogo.move(8); // up
		assertEquals(1,jogo.getHero().getLine());
		assertEquals(1,jogo.getHero().getCol());
		jogo.move(6); // right
		assertEquals(1,jogo.getHero().getLine());
		assertEquals(2,jogo.getHero().getCol());
		jogo.move(4); //left
		assertEquals(1,jogo.getHero().getLine());
		assertEquals(1,jogo.getHero().getCol());
	}

	@Test
	public void testMoveHeroIntoWallUns() {	
		Game jogo = new Game();
		//Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		Guard grd = new Guard(1,4,'G');
		jogo.setGuard(grd);
		jogo.move(8); //up
		assertEquals(1, jogo.getHero().getLine());
		assertEquals(1, jogo.getHero().getCol());
		jogo.move(4); //left
		assertEquals(1, jogo.getHero().getLine());
		assertEquals(1, jogo.getHero().getCol());
	}

	@Test
	public void testMoveHeroIntoAjdGuardDefeat() {
		Game jogo = new Game();
		//Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		Guard grd = new Guard(1,4,'G');
		jogo.setGuard(grd);
		jogo.getGuard().setLine(1);
		jogo.getGuard().setCol(3);
		jogo.move(6);
		assertTrue(jogo.getGameOver());
	}

	@Test
	public void testMoveHeroIntoClosedDoors() {
		Game jogo = new Game();
	//	Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		Guard grd = new Guard(1,4,'G');
		jogo.setGuard(grd);
		jogo.move(2);
		jogo.move(4);
		assertFalse(jogo.getPassed());
	}
	
	@Test
	public void testMoveHeroIntoLeverCeelDoorsOpen() {
		Game jogo = new Game();
		//Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		Guard grd = new Guard(1,4,'G');
		jogo.setGuard(grd);
		jogo.move(2);
		jogo.move(2);
		assertTrue(jogo.getLevelObj().getisDoorsOpen());
	}
	
	@Test
	public void testMoveHeroIntoOpenDoors() {
		Game jogo = new Game();
		//Level levelTest = new Level(mapTest);
		jogo.setLevel(mapTest);
		Guard grd = new Guard(1,4,'G');
		jogo.setGuard(grd);
		jogo.move(2);
		jogo.move(2);
		jogo.move(4);
		assertTrue(jogo.getPassed());
	}

}
