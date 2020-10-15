package skunk.domain;

public class Game
{
	private Player player1 ;
	private Dice dice ;
	public Kitty kitty;
	
	public Game() {
		this.player1 = new Player("Player one");
		this.dice = new Dice();
		this.kitty = new Kitty();
	}

	public String getPlayer()
	{
		return this.player1.getName();
	}

	public int getDiceLastRoll()
	{
		return this.dice.getLastRoll();
	}

	public void rollDice()
	{
		this.dice.roll();
	}

}
