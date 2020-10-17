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
		Kitty kitty = new Kitty();
		PredictableTurn turn = new PredictableTurn(player1, kitty);
		assertEquals(false, turn.takeATurn());
	}
	
	@Test
	void test_predictable_turn2()
	{
		Player player1 = new Player("Scott");
		Kitty kitty = new Kitty();
		PredictableTurn turn = new PredictableTurn(player1, kitty);
		turn.takeATurn();
		assertEquals(true, turn.takeATurn());
	}

}
