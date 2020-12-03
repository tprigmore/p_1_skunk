package skunk.domain;

public class Player
{
	private String name;
	private int gamePoints;
	private int turnPoints;
	private int chips;

	public Player()
	{
		this.name = "John Doe";
	}

	public Player(String name)
	{
		this.name = name;
		this.gamePoints = 0;
		this.turnPoints = 0;
		this.chips = 50;
	}

	public String getName()
	{

		return this.name;
	}

	public void setGamePoints(int points)
	{
		this.gamePoints = points;
	}

	public int getGamePoints()
	{
		return this.gamePoints;
	}

	public void setTurnPoints(int points)
	{
		this.turnPoints = points;
	}

	public int getTurnPoints()
	{
		return this.turnPoints;
	}

	public int getChips()
	{
		return this.chips;
	}

	public void setChips(int chips)
	{
		this.chips = chips;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
