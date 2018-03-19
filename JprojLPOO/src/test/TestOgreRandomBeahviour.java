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

public class TestOgreRandomBeahviour {

	char[][] mapTest = { 
			{ 'X', 'X', 'X', 'X', 'X' }, 
			{ 'I', ' ', ' ', 'k', 'X' }, 
			{ 'X', ' ', ' ', 'O', 'X' },
			{ 'X', 'H', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X' } };

	@Test // tirar o club do construtor do Ogre(int lin, int col)
	public void testRandomBehaviour() {
//		boolean cond1= false;
//		boolean cond2= false;
//		boolean cond3= false;
//		boolean cond4= false;
//		
//		Game jogo = new Game();
//		Level levelTest = new Level(mapTest);
//		jogo.setLevel(mapTest);
//		jogo.setLevelInt(2);
//		Ogre ogreMal = new Ogre(1,4);
//		jogo.CastClub(ogreMal);
//		while( !cond1 || !cond2 ) {
//			someaction;
//			if (cond1) {
//				outcome1 = true;
// 			}else if (cond2) {
// 				outcome2 = true;
// 			}
//		}
	}

}
