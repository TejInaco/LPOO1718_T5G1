//package test;
//
////import logic.Hero;
//import logic.Map;
//import logic.Game;
//import logic.Level;
////import logic.TakeTwo;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
// 
////import logic.Map; extends ou implements Level
//
//public class testLogicOnTwo {
//
//	char[][] map = { { 'X', 'X', 'X', 'X', 'X' }, { 'I', ' ', ' ', 'k', 'X' }, { 'X', ' ', ' ', 'O', 'X' },
//			{ 'X', 'H', ' ', ' ', 'X' }, { 'X', 'X', 'X', 'X', 'X' } };
//
//	@Test // tirar o club do construtor do Ogre(int lin, int col)
//	public void testHeroOgre() {
//		Level Map = new Map(map);
//		Game state = new Game();
//		state.setLevel(Map);
//		Map.setOgre(2, 3);
//		Map.setHero(3, 1);
//		assertEquals(1, Map.getHero().getCol());
//		assertEquals(3, Map.getHero().getLine());
//		Map.move(6);
//		Map.move(6);
//		Map.move(8);
//		assertTrue(state.gameover);// estao no mesmo sitio mas nao acusa colisao ou gamneover...
//
//	}
//
//}
