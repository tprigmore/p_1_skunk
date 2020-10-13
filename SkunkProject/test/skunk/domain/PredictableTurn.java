package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class PredictableTurn
{
	private static final int SKUNK = -1;
	private static final int SKUNK_DEUCE = -2;
	private static final int DOUBLE_SKUNK = -4;
	private Player player ;
	private PredictableDice dice ;
	private int runningTotal ;

	public PredictableTurn(Player player, PredictableDice dice)
	{
		this.player = player;
		this.setRunningTotal(0);
		this.dice = dice ;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public Player getPlayer()
	{
		return this.player;
	}

	public int takeATurn()
	{
		this.dice.roll();

		int value = this.dice.getLastRoll();

		if(value == DOUBLE_SKUNK) {
			this.player.setPoints(0);
			this.player.setChips(this.player.getChips() - 4);
		}
		else if (value == SKUNK_DEUCE) {
			this.player.setChips(this.player.getChips() - 2);
			}
		else if (value == SKUNK) {
			this.player.setChips(this.player.getChips() - 1);
		}
		else {
			this.setRunningTotal(this.getRunningTotal() + value) ;
		}
		return value;
	}

	public int getRunningTotal()
	{
		return runningTotal;
	}

	public void setRunningTotal(int runningTotal)
	{
		this.runningTotal = runningTotal;
	}

}
