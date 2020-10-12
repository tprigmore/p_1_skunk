package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableTurn
{

	@Test
	void test_predictable_turn()
	{
		Player player1 = new Player("Scott");
		PredictableTurn turn = new PredictableTurn(player1);
		assertEquals(player1, turn.getPlayer());
	}


	@Test
	void test_predictable_take_a_turn()
	{
		Player player1 = new Player("Scott");
		PredictableTurn turn = new PredictableTurn(player1);
		assertEquals("double skunk", turn.takeATurn());
	}


}
