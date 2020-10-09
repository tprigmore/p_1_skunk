package skunk.domain;

public class PredictableDie
{
	private int[] theRolls;
	private int index;
	private int lastRoll;

	public PredictableDie()
	{
		this.lastRoll = 1;
		this.index = 0;
	}

	public PredictableDie(int[] is)
	{
		if (is.length == 0) {
			throw new RuntimeException();
		}
		this.theRolls = is;
		this.index = 0;
	}

	public void roll()
	{
		this.lastRoll = this.theRolls[this.index];
		this.index++;
		if (this.index == this.theRolls.length)
		{
			this.index = 0;
		}
	}

	public int getLastRoll()
	{
		// TODO Auto-generated method stub
		return this.lastRoll;
	}

}
