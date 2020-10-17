package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPredictableRoll
{

	@Test
	void testPredictableRollDoubleSkunk()
	{
		PredictableRoll roll = new PredictableRoll();
		roll.rollDice();
		
		assertEquals(2, roll.getLastRoll());
	}

}
