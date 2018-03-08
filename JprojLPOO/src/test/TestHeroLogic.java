/**
 * 
 */
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
/**
 * @author notus
 *
 */
public class TestHeroLogic {

	char[][] map = {
			{'X','X','X','X','X','X'},
			{'X','H',' ',' ','G','X'},
			{'I',' ',' ',' ',' ','X'},
			{'I','k',' ',' ',' ','X'},
			{'X','X','X','X','X','X'},
		};
	@Test
	public void testMoveHeroIntoCell() {
		Game jogo = new Game();
		jogo.getBoard().setMap1(map);
		assertEquals(0, jogo.getHero().getLine());
//		assertEquals(1, jogo.getHero().getCol());
//		jogo.move(2);
//		assertEquals(2, jogo.getHero().getLine());
//		assertEquals(1, jogo.getHero().getLine());
//		Game gameMap = new GameMap(map);
//		Game game = new Game(gameMap);
//		Game game = new Game(gameMap);
//		assertEquals(new CellPosition(2,1), game.getHeroPosition());
	}
/*
	@Test
	public void testMoveHeroIntoWallUns() {	
		
	}
	@Test
	public void testMoveHeroIntoAjdGuardDefeat() {
		
	}
	@Test
	public void testMoveHeroIntoClosedDoors() {
		
	}
	@Test
	public void testMoveHeroIntoLeverCeelDoorsOpen() {
		
	}
	@Test
	public void testMoveHeroIntoOpenDoors() {
		
	}
	*/
}
