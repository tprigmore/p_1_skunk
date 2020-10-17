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
	
	@Test
	void testPredictableSkunk()
	{
		PredictableRoll roll = new PredictableRoll();
		roll.rollDice();
		roll.rollDice();
		roll.rollDice();	
		roll.rollDice();		
		roll.rollDice();		
		
		assertEquals(true, roll.isSkunk());
	}

}
