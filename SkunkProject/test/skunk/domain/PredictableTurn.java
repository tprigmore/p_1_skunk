package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class PredictableTurn
{
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

		if(value == -4) {
			this.player.setPoints(0);
			this.player.setChips(this.player.getChips() - 4);
		}
		else if (value == -2) {
			this.player.setChips(this.player.getChips() - 2);
			}
		else if (value == -1) {
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
