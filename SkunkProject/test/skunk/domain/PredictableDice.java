package skunk.domain;

public class PredictableDice
{
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
		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
		
	}

	public int getLastRoll()
	{
		return this.lastRoll;
	}

}
