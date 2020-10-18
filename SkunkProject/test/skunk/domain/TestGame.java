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

	@Test
	public void test_gameForWinner()
	{
		boolean assertValue = false;
		String state = "Playing" ;
		int count = 0;
		Game game = new Game();
		game.addPlayer("Player one");
		while (count < 100) {
			state = game.takeATurn();
			count++;
			if (state == "Playing" ) {
				if (game.getPlayerGamePoints() > 20) {
					game.SavePlayerPoints();
					game.goToNextPlayer();
					StdOut.println("No match to text");
					StdOut.println("Game Points: " + game.getPlayerGamePoints());

				}
			} 
			else if (state == "Next Player") {
				game.goToNextPlayer();
				StdOut.println("Lost ");
			}
			else {
				if (state == "Over One Hundred") {
					StdOut.println("Winner");

					assertValue = true;
					}
				else {
					StdOut.println("No match to text");
				}
			}
		}

		assertTrue(assertValue);
	}

}
