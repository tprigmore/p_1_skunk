package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn
{
	
	@Test
	void testTurnActivePlayer()
	{
		Player activePlayer = new Player("Scott");
		Turn turn = new Turn(activePlayer);
		
		assertEquals("Scott", turn.getActivePlayer().getName());
	}
	
	@Test
	void testTurnTurnGetPlayer()
	{
		Player activePlayer = new Player("Scott");
		Turn turn = new Turn(activePlayer);
		
		assertEquals(activePlayer, turn.getActivePlayer());
	}
}
