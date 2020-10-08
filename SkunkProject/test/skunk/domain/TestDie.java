package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

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

	@Test
	public void test_die_for_7()
	{
		boolean result = false;
		for (int i = 0; i < 100; i++)
		{
			Die die = new Die();
			die.roll();
			int value = die.getLastRoll();
			if (value == 7)
			{
				result = true;
				break;
			}
		}
		assertFalse(result);
	}

	@Test
	public void test_die_to_string()
	{
		boolean result = false;
		Die die = new Die();
		die.roll();
		String string = die.toString();
		StdOut.println(string);
		if (string.equals("Die: 1") || string.equals("Die: 2") || string.equals("Die: 3") ||  string.equals("Die: 4") || string.equals("Die: 5") || string.equals("Die: 6"))
			result = true ;
		assertTrue(result);
	}

}
