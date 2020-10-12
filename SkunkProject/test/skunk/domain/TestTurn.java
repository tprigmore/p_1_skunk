package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn
{
	
	@Test
	void testTurnState()
	{
		Player activePlayer = new Player("Scott");
		Turn turn = new Turn(activePlayer);
		
		assertEquals("Scott", turn.getActivePlayer().getName());
	}

}
