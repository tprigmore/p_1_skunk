package skunk.domain;

public class PredictableDie
{
	private int[] theRolls;
	private int index;
	private int lastRoll;
	
	public PredictableDie()
	{
		// TODO Auto-generated constructor stub
	}

	public PredictableDie(int[] is)
	{
		this.theRolls = is ;
		this.index = 0;
	}

	public void roll()
	{
		this.lastRoll = this.theRolls[this.index];
		
	}

	public int getLastRoll()
	{
		// TODO Auto-generated method stub
		return this.lastRoll;
	}

}
