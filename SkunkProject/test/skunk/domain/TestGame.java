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
	public void test_gameForWinner()
	{
		boolean assertValue = false;
		int count = 0;
		Game game = new Game();
		game.addPlayer("Player one");
		while (count < 100) {
			count++;
			if (game.takeATurn()) {
				if (game.getRunningTotal() > 20) {
					game.goToNextPlayer();
//					StdOut.println(game.getPlayerName() + " game points: " + game.getPlayerGamePoints());
				}
			} 
			else {
//				StdOut.println(game.getPlayerName() + " game points: " + game.getPlayerGamePoints());
				game.goToNextPlayer();
			}
			if(game.getPlayerGamePoints() > 100) {
				assertValue = true;
				break;
			}
		}

		assertTrue(assertValue);
	}
	
	@Test
	void testSetAndGetChips()
	{
		Game game = new Game();
		game.addPlayer("Scott");
		game.setPlayerChips(10);
		
		assertEquals(10, game.getPlayerChips());
	}
	
	@Test
	void testSetAndGetGamePoints()
	{
		Game game = new Game();
		game.addPlayer("Scott");
		game.setPlayerIndex(0);
		game.setPlayerGamePoints(10);;
		
		assertEquals(10, game.getPlayerGamePoints());
	}
	
	@Test
	void test_get_dice_values()
	{
		boolean returnvalue = false;
		Game game = new Game();
		game.addPlayer("Scott");
		game.takeATurn();
		String str = game.getTheDiceValues();
		String str1 = str.substring(0, 1);
		if (str1.equals("1")) {
			str1 = str.substring(0, 2);
		}
		int number = Integer.parseInt(str1);
		if ((number >= 2) && (number <= 12)) {
			returnvalue = true;
		}
		
		assertTrue(returnvalue);
	}
	
	@Test
	void test_get_player_index()
	{
		Game game = new Game();
		game.addPlayer("Scott");
		
		assertEquals(0, game.getPlayerIndex());
	}
	
	@Test
	void test_get_player_count()
	{
		Game game = new Game();
		game.addPlayer("Scott");
		
		assertEquals(1, game.getPlayerCount());
	}

}
