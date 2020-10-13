package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class PredictableDice
{
	private static final int SKUNK = -1;
	private static final int SKUNK_DEUCE = -2;
	private static final int DOUBLE_SKUNK = -4;
	private int lastRoll;
	private PredictableDie die1;
	private PredictableDie die2;

	public PredictableDice()
	{

		this.die1 = new PredictableDie(new int[] {1,2,3});
		this.die2 = new PredictableDie(new int[] {1,2,3});
	}

	public void roll()
	{
		
		this.die1.roll();
		this.die2.roll();
		this.lastRoll = this.die1.getLastRoll() + this.die2.getLastRoll();

	}

	public int getLastRoll()
	{
		int value1;
		int value2;
		int total;
		
		value1 = this.die1.getLastRoll();
		value2 = this.die2.getLastRoll();
		total = value1 + value2 ;
		
		if ((value1 == 1) && (value2 == 1))
			total = DOUBLE_SKUNK;
		else if (3 == total)
			total = SKUNK_DEUCE;
		else if ((value1 == 1) || (value2 == 1))
			total = SKUNK;
		return total;
	}

}
