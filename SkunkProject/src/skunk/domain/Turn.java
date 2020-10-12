package skunk.domain;

public class Turn
{
	private Player activePlayer ;

	public Turn(Player activePlayer)
	{
		this.setActivePlayer(activePlayer);
	}

	public Player getActivePlayer()
	{
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer)
	{
		this.activePlayer = activePlayer;
	}

}
