package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie
{

	@Test
	public void test_die_range()
	{
		for (int i = 0; i < 100; i++)
		{
			Die die = new Die();
			die.roll();
			int value = die.getLastRoll();
			boolean result = (value >= 1 || value <= 6);
			assertTrue(result);
		}
	}

	@Test
	public void test_die_for_1()
	{
		boolean result = false;
		for (int i = 0; i < 100; i++)
		{
			Die die = new Die();
			die.roll();
			int value = die.getLastRoll();
			if (value == 1)
			{
				result = true;
				break;
			}
		}
		assertTrue(result);
	}
	
	@Test
	public void test_die_for_2()
	{
		boolean result = false;
		for (int i = 0; i < 100; i++)
		{
			Die die = new Die();
			die.roll();
			int value = die.getLastRoll();
			if (value == 2)
			{
				result = true;
				break;
			}
		}
		assertTrue(result);
	}
	
	@Test
	public void test_die_for_3()
	{
		boolean result = false;
		for (int i = 0; i < 100; i++)
		{
			Die die = new Die();
			die.roll();
			int value = die.getLastRoll();
			if (value == 3)
			{
				result = true;
				break;
			}
		}
		assertTrue(result);
	}
	
	@Test
	public void test_die_for_4()
	{
		boolean result = false;
		for (int i = 0; i < 100; i++)
		{
			Die die = new Die();
			die.roll();
			int value = die.getLastRoll();
			if (value == 4)
			{
				result = true;
				break;
			}
		}
		assertTrue(result);
	}
	
	@Test
	public void test_die_for_5()
	{
		boolean result = false;
		for (int i = 0; i < 100; i++)
		{
			Die die = new Die();
			die.roll();
			int value = die.getLastRoll();
			if (value == 5)
			{
				result = true;
				break;
			}
		}
		assertTrue(result);
	}
	
	@Test
	public void test_die_for_6()
	{
		boolean result = false;
		for (int i = 0; i < 100; i++)
		{
			Die die = new Die();
			die.roll();
			int value = die.getLastRoll();
			if (value == 6)
			{
				result = true;
				break;
			}
		}
		assertTrue(result);
	}
	
	@Test
	public void test_die_for_0()
	{
		boolean result = false;
		for (int i = 0; i < 100; i++)
		{
			Die die = new Die();
			die.roll();
			int value = die.getLastRoll();
			if (value == 0)
			{
				result = true;
				break;
			}
		}
		assertFalse(result);
	}
}
