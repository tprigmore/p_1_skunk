package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableDice
{
	private static final int SKUNK = -1;
	private static final int SKUNK_DEUCE = -2;
	private static final int DOUBLE_SKUNK = -4;

	@Test
	void test_predictable_dice_246()
	{
		PredictableDice dice = new PredictableDice();
		dice.roll();
		assertEquals(DOUBLE_SKUNK, dice.getLastRoll());
		dice.roll();
		assertEquals(4, dice.getLastRoll());
		dice.roll();
		assertEquals(6, dice.getLastRoll());
		dice.roll();
		assertEquals(DOUBLE_SKUNK, dice.getLastRoll());
		dice.roll();
		assertEquals(4, dice.getLastRoll());

	}

}
