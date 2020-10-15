package skunk.domain;

public class Game
{
	private Player player1 ;
	
	public Game() {
		this.player1 = new Player("Player one");
	}

	public String getPlayer()
	{
		return this.player1.getName();
	}

}
