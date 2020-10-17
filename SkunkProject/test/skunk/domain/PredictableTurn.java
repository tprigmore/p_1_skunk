package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class PredictableTurn
{
	private static final int SKUNK_DEUCE = 3;
	private static final int DOUBLE_SKUNK = 2;
	
	private Player player ;
	private PredictableRoll roll ;
	private int runningTotal ;
	private Kitty kitty;

	public PredictableTurn(Player player, Kitty kitty)
	{
		this.player = player;
		this.setRunningTotal(0);
		this.roll = new PredictableRoll() ;
		this.kitty = kitty;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public Player getPlayer()
	{
		return this.player;
	}

	public boolean takeATurn()
	{
		boolean retValue = false ;
		
		this.roll.rollDice();

		int value = this.roll.getLastRoll();

		if(value == DOUBLE_SKUNK) {
			this.player.setGamePoints(0);
			this.player.setChips(this.player.getChips() - 4);
			this.kitty.setKitty(this.kitty.getKitty() + 4); 
		}
		else if (value == SKUNK_DEUCE) {
			this.player.setChips(this.player.getChips() - 2);
			this.kitty.setKitty(this.kitty.getKitty() + 2); 
			}
		else if (roll.isSkunk()) {
			this.player.setChips(this.player.getChips() - 1);
			this.kitty.setKitty(this.kitty.getKitty() + 1); 
		}
		else {
			this.setRunningTotal(this.getRunningTotal() + value) ;
			retValue = true;
		}
		return retValue ;
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
