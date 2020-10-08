package skunk.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDice
{

	@Test
	public void test_dice_range()
	{
		for (int i = 0; i < 1000; i++)
		{
			Dice dice = new Dice();
			dice.roll();
			int value = dice.getLastRoll();
			boolean result = (value >= 2 || value <= 12);
			assertTrue(result);
		}
	}

}
