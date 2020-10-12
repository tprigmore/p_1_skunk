package skunk.domain;

public class PredictableTurn
{
	private Player player ;
	private Dice dice ;

	public PredictableTurn(Player player)
	{
		this.setPlayer(player);
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public Player getPlayer()
	{
		return this.player;
	}

}
