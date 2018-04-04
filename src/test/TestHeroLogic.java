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
import logic.Guard.GuardType;
//import logic.Level;
import logic.Ogre;
import logic.*;
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
	public void testGameConst() {
		Game jogo = new Game(1,GuardType.ROOKIE);

		assertFalse(jogo.getGameOver());
		assertFalse(jogo.ended);
		assertFalse(jogo.getPassed());
		assertEquals(1,jogo.getLevelint());
//		jogo.setLevelInt(4);
////		assertEquals(1,jogo.getHero().getLine());
////		assertEquals(1,jogo.getHero().getCol());
//		assertFalse(jogo.getLevelObj().getisDoorsOpen());
//		jogo.setLevelInt(3);
//		assertEquals(1,jogo.getHero().getLine());
//		assertEquals(1,jogo.getHero().getCol());
//		assertFalse(jogo.getLevelObj().getisDoorsOpen());
//		jogo.setLevelInt(2);
//		assertEquals(1,jogo.getHero().getLine());
//		assertEquals(8,jogo.getHero().getCol());
//		assertFalse(jogo.getLevelObj().getisDoorsOpen());
		
	}
	
	@Test
	public void guardRoute() {
		Game jogo = new Game();
		Guard grd = new Guard(6,2, GuardType.ROOKIE);
		jogo.setGuard(grd);
		assertEquals(GuardType.ROOKIE,jogo.getGuard().getType() );
		jogo.getGuard().setInverted(true);
		jogo.getGuard().route();
		assertEquals(1,grd.getCol()); //lin = 6
		jogo.getGuard().route();
		assertEquals(5,grd.getLine()); // 5,1
		
		jogo.getGuard().setCol(7); // 5,7
		jogo.getGuard().route(); //--lin 
		assertEquals(4,grd.getLine()); //4,7
		jogo.getGuard().setLine(1);
		jogo.getGuard().route();
		assertEquals(8,grd.getCol()); //1,8
		jogo.getGuard().route();
		assertEquals(2,grd.getLine());
		jogo.getGuard().setCol(5); //2,5
		jogo.getGuard().route();
		assertEquals(6,grd.getCol());
		
		jogo.getGuard().setInverted(false);
		jogo.getGuard().setCol(1);
		jogo.getGuard().setLine(6);
		jogo.getGuard().route();
		assertEquals(2,grd.getCol()); //2,6
		
		jogo.getGuard().setCol(1);
		jogo.getGuard().setLine(5);
		jogo.getGuard().route();
		assertEquals(6,grd.getLine());
		
		jogo.getGuard().setCol(7);
		jogo.getGuard().setLine(2);
		jogo.getGuard().route();
		assertEquals(3,grd.getLine());
		
		jogo.getGuard().setCol(7);
		jogo.getGuard().setLine(5);
		jogo.getGuard().route();
		assertEquals(6,grd.getCol());
		
		jogo.getGuard().setCol(7);
		jogo.getGuard().setLine(6);
		jogo.getGuard().route();
		assertEquals(8,grd.getCol());
		
		jogo.getGuard().setCol(8);
		jogo.getGuard().setLine(6);
		jogo.getGuard().route();
		assertEquals(5,grd.getLine());
		
		jogo.getGuard().setCol(8);
		jogo.getGuard().setLine(1);
		jogo.getGuard().route();
		assertEquals(7,grd.getCol());
		
		jogo.getGuard().setCol(8);
		jogo.getGuard().setLine(7);
		jogo.getGuard().route();
		assertEquals(6,grd.getLine());
		
		jogo.getGuard().setCol(2);
		jogo.getGuard().setLine(5);
		jogo.getGuard().route();
		assertEquals(1,grd.getCol());
		
		jogo.getGuard().setCol(1);
		jogo.getGuard().setLine(5);
		jogo.getGuard().route();
		assertEquals(6,grd.getLine());
		
		jogo.getGuard().setCol(8);
		jogo.getGuard().setLine(6);
		jogo.getGuard().route();
		assertEquals(5,grd.getLine());
		
		jogo.getGuard().setCol(7);
		jogo.getGuard().setLine(6);
		jogo.getGuard().route();
		assertEquals(8,grd.getCol());
		
		jogo.getGuard().setCol(2);
		jogo.getGuard().setLine(5);
		jogo.getGuard().route();
		assertEquals(1,grd.getCol());
		
//		jogo.getGuard().setCol(3);
//		jogo.getGuard().setLine(5);
//		jogo.getGuard().route();
//		assertEquals(4,grd.getLine());
		
		jogo.getGuard().setCol(2);
		jogo.getGuard().setLine(6);
		jogo.getGuard().route();
		assertEquals(3,grd.getCol());
		
	}
	
	@Test
	public void ogreStunAndStuntCounter() { 
		Game jogo = new Game();
		jogo.setLevel(mapTest);
		Ogre test_ogre = new Ogre();
		jogo.setCrazyOgre(test_ogre);
		test_ogre.setLine(2);
		test_ogre.setCol(3);
		assertEquals(2, test_ogre.getLine()	);
		assertEquals(3, test_ogre.getCol()	);
		test_ogre.setStun();
		assertTrue(test_ogre.getStun());
		assertEquals(0,test_ogre.getStunCounter());
		test_ogre.incStunCounter();
		assertEquals(1,test_ogre.getStunCounter());
		test_ogre.incStunCounter();
		assertEquals(2,test_ogre.getStunCounter());
		test_ogre.incStunCounter();
		assertEquals(0,test_ogre.getStunCounter());
		assertFalse( test_ogre.getStun() );
		assertEquals(0,test_ogre.getStunCounter());
		test_ogre.setClub(5, 6);
		assertEquals(5,test_ogre.getClub().getLine());
		assertEquals(6,test_ogre.getClub().getCol());
	}
	@Test
	public void ogreCollision() { 
		Game jogo = new Game();
		jogo.setLevel(mapTest);
		Ogre test_ogre = new Ogre();
		jogo.setCrazyOgre(test_ogre);
		test_ogre.setLine(2);
		test_ogre.setCol(3);; 
		
		assertTrue(test_ogre.stun(2, 2)); // lin =
		assertTrue(test_ogre.stun(2, 4));
		assertTrue(test_ogre.stun(1, 3)); // col ==
		assertTrue(test_ogre.stun(3, 3));
		assertFalse(test_ogre.stun(7, 4));
												//linha 2 coluna 3
		assertTrue(test_ogre.collision(test_ogre.getClub().getLine(), test_ogre.getClub().getCol())); //lin = col =
		
		assertTrue(test_ogre.collision(1, 4)); //lin -1
		assertTrue(test_ogre.collision(1, 2));
		assertTrue(test_ogre.collision(3, 4)); //lin +1
		assertTrue(test_ogre.collision(3, 2));
		assertTrue(test_ogre.collision(1, 3)); //col =
		assertTrue(test_ogre.collision(3, 3));
		assertTrue(test_ogre.collision(2, 4)); //lin =
		assertTrue(test_ogre.collision(2, 2));
		
		//assertTrue(test_ogre.collision(4, 0));
		assertFalse(test_ogre.collision(4, 5));
		
		
	}
	
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
		jogo.setLevel(mapTest);
		
		Guard grd = new Guard(2,3,'G');
		jogo.setGuard(grd);
		
		assertTrue( grd.collision(1,2) ); //col-1
		assertTrue( grd.collision(3,2) );//col-1
		assertTrue( grd.collision(1,4) ); //col+1
		assertTrue( grd.collision(3,4) ); //col+1
		assertTrue( grd.collision(1,3) ); // col =
		assertTrue( grd.collision(3,3) ); // col =
		assertTrue( grd.collision(2,4) );
		assertTrue( grd.collision(2,2) );
		assertFalse( grd.collision(4,5) );
		
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
		jogo.setLevel(mapTest);
		Guard grd = new Guard(1,4,'G');
		jogo.setGuard(grd);
		jogo.getLevelObj().openDoors();
		assertTrue(jogo.getLevelObj().isDoorsOpen);
		
		assertTrue(jogo.getLevelObj().foundDoor(2, 0));
		assertFalse(jogo.getLevelObj().foundDoor(1, 1));
		Hero tst_hr = new Hero(2,0);
		jogo.setHero(tst_hr);
		jogo.validateRulesLevel1();
		assertTrue(jogo.getPassed());
	}

}
