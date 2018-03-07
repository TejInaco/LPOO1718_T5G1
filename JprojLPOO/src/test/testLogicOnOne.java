package test;

import logic.Hero;
import logic.Map;
import logic.Game;
import logic.Level;
import logic.TakeOne;

import static org.junit.Assert.*;
import org.junit.Test;

//import logic.Map; extends ou implements Level

public class testLogicOnOne {

	char[][] map = { { 'X', 'X', 'X', 'X', 'X' }, { 'X', 'H', ' ', 'G', 'X' }, { 'I', ' ', ' ', ' ', 'X' },
			{ 'I', 'k', ' ', ' ', 'X' }, { 'X', 'X', 'X', 'X', 'X' } };

	@Test // confirms moving east, south to empty square and west,north to wall
	public void testMoveEastToEmptySquare() {
		Level Map = new Map(map);
		Game state = new Game();
		state.setLevel(Map);
		state.board.setLever(true);
		Map.setGuard(1, 3);
		Map.setHero(1, 1);
		Hero hero = new Hero(1, 1);
		assertEquals(1, Map.getHero().getCol());
		assertEquals(1, Map.getHero().getLine());
		Map.move(4);// W to wall
		assertEquals(1, Map.getHero().getCol());
		assertEquals(1, Map.getHero().getLine());
		Map.move(8);// N to wall
		assertEquals(1, Map.getHero().getCol());
		assertEquals(1, Map.getHero().getLine());
		Map.move(6);// E to empty
		assertEquals(2, Map.getHero().getCol());
		assertEquals(1, Map.getHero().getLine());
		Map.move(2);// S to empty
		assertEquals(2, Map.getHero().getCol());
		assertEquals(2, Map.getHero().getLine());
	}

	@Test // confirms moving east to empty square
	public void testMoveWestToEmptySquare() {
		Level Map = new Map(map);
		Game state = new Game();
		state.setLevel(Map);
		state.board.setLever(true);
		Map.setGuard(1, 3);
		Map.setHero(3, 3);
		Hero hero = new Hero(1, 1);
		assertEquals(3, Map.getHero().getCol());
		assertEquals(3, Map.getHero().getLine());

		Map.move(6);// E to wall
		assertEquals(3, Map.getHero().getCol());
		assertEquals(3, Map.getHero().getLine());
		Map.move(2);// S to wall
		assertEquals(3, Map.getHero().getCol());
		assertEquals(3, Map.getHero().getLine());
		Map.move(8);// N to empty
		assertEquals(3, Map.getHero().getCol());
		assertEquals(2, Map.getHero().getLine());
		Map.move(4);// W to empty
		assertEquals(2, Map.getHero().getCol());
		assertEquals(2, Map.getHero().getLine());

	}

}
