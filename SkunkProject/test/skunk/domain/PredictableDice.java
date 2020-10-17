package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class PredictableDice
{
	private int lastRoll;
	private PredictableDie die1;
	private PredictableDie die2;

	public PredictableDice()
	{

		this.die1 = new PredictableDie(new int[] {1,2,3,4,1,2});
		this.die2 = new PredictableDie(new int[] {1,2,3,4,3,1});
	}

	public void roll()
	{
		
		this.die1.roll();
		this.die2.roll();
		this.lastRoll = this.die1.getLastRoll() + this.die2.getLastRoll();
	}

	public int getLastRoll()
	{
		return this.lastRoll;
	}

}
