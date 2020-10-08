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

	@Test
	public void test_dice_constructor()
	{
		for (int i = 0; i < 1000; i++)
		{
			Die die1 = new Die();
			Die die2 = new Die();
			Dice dice = new Dice(die1, die2);
			dice.roll();
			int value = dice.getLastRoll();
			boolean result = (value >= 2 || value <= 12);
			assertFalse(result);
		}
	}
}
