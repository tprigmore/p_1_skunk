package skunk.domain;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableDie
{

//	@Test
//	void test()
//	{
//		fail("Not yet implemented");
//	}
	
	@Test
	public void test_predictable_die_123()
	{
		PredictableDie die = new PredictableDie(new int[] {1,2,3});
		die.roll();
		assertEquals(1, die.getLastRoll());
		//fail("Not yet implemented");
	}
	
}
