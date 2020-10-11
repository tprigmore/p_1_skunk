package skunk.domain;

public class Player
{
	private String name ;
	private int points ;
	private int chips ;
	
	public Player()
	{
		
	}
	
	public Player(String name)
	{
		this.name = name;
		this.points = 0;
		this.chips = 0;
	}

	public String getName()
	{

		return this.name;
	}

	public void setPoints(int points)
	{
		this.points = points;
	}

	public int getPoints()
	{
		return this.points;
	}

	public Integer getChips()
	{
		return this.chips;
	}

	public void setChips(int chips)
	{
		this.chips = chips;
		
	}

}
