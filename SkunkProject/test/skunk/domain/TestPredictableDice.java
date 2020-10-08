package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableDice
{

	@Test
	void test_predictable_dice_246()
	{
		PredictableDice dice = new PredictableDice();
		dice.roll();
		assertEquals(2, dice.getLastRoll());
		dice.roll();
		assertEquals(4, dice.getLastRoll());
		dice.roll();
		assertEquals(6, dice.getLastRoll());
		dice.roll();
		assertEquals(2, dice.getLastRoll());
		dice.roll();
		assertEquals(4, dice.getLastRoll());

	}

}
