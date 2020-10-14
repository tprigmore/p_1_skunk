package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn
{
	
	@Test
	void testTurnActivePlayer()
	{
		Dice dice = new Dice();
		Player activePlayer = new Player("Scott");
		Turn turn = new Turn(activePlayer, dice);
		
		assertEquals("Scott", turn.getPlayer().getName());
	}
	
	@Test
	void testTurnGetPlayer()
	{
		Dice dice = new Dice();
		Player activePlayer = new Player("Scott");
		Turn turn = new Turn(activePlayer, dice);
		
		assertEquals(activePlayer, turn.getPlayer());
	}
	
	@Test
	void testTakeATurn()
	{
		boolean result = false;
		Dice dice = new Dice();
		Player activePlayer = new Player("Scott");
		Turn turn = new Turn(activePlayer, dice);
		int value = turn.takeATurn();
		if(value >= -4 && value <= 12) {
			result = true;
		}
		assertTrue(result);
	}
}
