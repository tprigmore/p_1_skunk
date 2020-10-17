package skunk.domain;

public class Roll
{
	private static final int SKUNK = -1;
	private static final int SKUNK_DEUCE = -2;
	private static final int DOUBLE_SKUNK = -4;

	private Dice dice;

	public Roll()
	{
		this.dice = new Dice();
	}
	
	public void rollDice() {
		this.dice.roll();
	}

	public int getLastRoll()
	{
		return this.dice.getLastRoll();
	}

	public boolean isSkunk()
	{
		boolean retValue = false;
		if (this.dice.getDie1LastRoll() == 1 || this.dice.getDie2LastRoll() == 1) {
			retValue = true;
		}
		return retValue;
	}

}
