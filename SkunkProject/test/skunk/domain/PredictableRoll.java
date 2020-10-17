package skunk.domain;

public class PredictableRoll
{
	private PredictableDice dice;

	public PredictableRoll()
	{
		this.dice = new PredictableDice();
	}
	
	public void rollDice() {
		this.dice.roll();
	}

	public int getLastRoll()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	

}
