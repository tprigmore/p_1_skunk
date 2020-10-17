package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
	
//	@Test
//	void testTakeATurn()
//	{
//		boolean result = false;
//		Kitty kitty = new Kitty();
//		Player activePlayer = new Player("Scott");
//		Turn turn = new Turn(activePlayer, kitty);
//		
//		assertTrue(result);
//	}
}
