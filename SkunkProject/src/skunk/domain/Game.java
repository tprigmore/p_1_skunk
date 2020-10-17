package skunk.domain;

public class Game
{
	private Player player1 ;
	public Kitty kitty;
	
	public Game() {
		this.player1 = new Player("Player one");
		this.kitty = new Kitty();
	}

	public String getPlayer()
	{
		return this.player1.getName();
	}


}
