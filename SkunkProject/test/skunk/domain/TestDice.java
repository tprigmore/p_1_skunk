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
			boolean result = (value >= -4 || value <= 12);
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
			boolean result = (value >= -4 || value <= 12);
			assertTrue(result);
		}
	}

	@Test
	public void test_dice_for_1()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 1)
			{
				flag = true;
				break;
			}
		}
		assertFalse(flag);
	}
	
	@Test
	public void test_dice_for_2()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == -4)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	

	@Test
	public void test_dice_for_3()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == -2)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	@Test
	public void test_dice_for_4()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 4)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	@Test
	public void test_dice_for_5()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 5)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	@Test
	public void test_dice_for_6()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 6)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	@Test
	public void test_dice_for_7()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 7)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	@Test
	public void test_dice_for_8()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 8)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	@Test
	public void test_dice_for_9()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 9)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	@Test
	public void test_dice_for_10()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 10)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	@Test
	public void test_dice_for_11()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 11)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	@Test
	public void test_dice_for_12()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 12)
			{
				flag = true;
				break;
			}
		}
		assertTrue(flag);
	}
	
	@Test
	public void test_dice_for_13()
	{
		Dice dice = new Dice();
		int value;
		boolean flag = false;
		for (int i = 0; i < 1000; i++)
		{
			dice.roll();
			value = dice.getLastRoll();
			if (value == 13)
			{
				flag = true;
				break;
			}
		}
		assertFalse(flag);
	}
	
	@Test
	public void test_dice_toString()
	{
		Dice dice = new Dice();
		String string = dice.toString();
		assertTrue(string.contains("Dice with last roll: "));
	}
}
