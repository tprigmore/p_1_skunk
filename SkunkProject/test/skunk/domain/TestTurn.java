package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

class TestTurn
{
	
	@Test
	void testTurnActivePlayer()
	{
		Player activePlayer = new Player("Scott");
		Kitty kitty = new Kitty();
		Turn turn = new Turn(activePlayer, kitty);
		
		assertEquals("Scott", turn.getPlayer().getName());
	}
	
	@Test
	void testTurnGetPlayer()
	{

		Player activePlayer = new Player("Scott");
		Kitty kitty = new Kitty();
		Turn turn = new Turn(activePlayer, kitty);
		
		assertEquals(activePlayer, turn.getPlayer());
	}
	
	@Test
	void testTakeATurn()
	{
		boolean result = false;
		int passCount = 0;
		int failCount = 0;
		Kitty kitty = new Kitty();
		Player activePlayer = new Player("Scott");
		Turn turn = new Turn(activePlayer, kitty);
		
		for (int i = 0; i < 1000; i++) {
			if (turn.takeATurn()) {
				passCount += 1;
			}
			else {
				failCount += 1;
			}
		}
		StdOut.println("Fail count : " + failCount);
		StdOut.println("Pass count : " + passCount);
		
		if ((failCount >= 250) && (passCount >=600)) {
			result = true;
		}
		assertTrue(result);
	}
}
