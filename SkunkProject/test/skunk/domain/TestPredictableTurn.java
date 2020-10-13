package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

class TestPredictableTurn
{

	@Test
	void test_predictable_turn()
	{
		Player player1 = new Player("Scott");
		PredictableDice dice = new PredictableDice();
		PredictableTurn turn = new PredictableTurn(player1, dice);
		assertEquals(player1, turn.getPlayer());
	}


	@Test
	void test_predictable_take_a_turn()
	{
		Player player1 = new Player("Scott");
		PredictableDice dice = new PredictableDice();
		PredictableTurn turn = new PredictableTurn(player1, dice);
		assertEquals(-4, turn.takeATurn());
		assertEquals(4, turn.takeATurn());
		assertEquals(6, turn.takeATurn());
	}


}
