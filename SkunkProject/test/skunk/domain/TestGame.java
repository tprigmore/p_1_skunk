package skunk.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

class TestGame
{

	@Test
	public void test_gamePlayer()
	{
		
		Game game = new Game();
		game.addPlayer("Player one");
		assertEquals("Player one",game.getPlayerName());
//		StdOut.println("Player one : " + game.getPlayerName());
		game.setPlayerName("Fred");
		assertEquals("Fred",game.getPlayerName());
//		StdOut.println("Fred : " + game.getPlayerName());
	}


	@Test
	public void test_gameKitty()
	{
		Game game = new Game();
		assertEquals(0 , game.getKitty());
		game.setKitty(4);
		assertEquals(4 , game.getKitty());
	}
	
	@Test
	public void test_gameturn()
	{
		boolean assertValue = false;
		Game game = new Game();
		game.addPlayer("Player one");
		game.setKitty(4);
		String state = game.takeATurn();
		if (state == "Playing" || state == "Next Player") {
			assertValue = true;
		}
		assertTrue(assertValue);
	}


}
