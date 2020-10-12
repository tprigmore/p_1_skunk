package skunk.domain;

public class PredictableTurn
{
	private Player player ;
	private PredictableDice dice ;

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

	public String takeATurn()
	{
		
		return "pass";
	}

}
