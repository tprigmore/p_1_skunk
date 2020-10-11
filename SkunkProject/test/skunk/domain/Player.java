package skunk.domain;

public class Player
{
	private String name ;
	private int points ;
	
	public Player()
	{
		
	}
	
	public Player(String name)
	{
		this.name = name;
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
		return 50;
	}

}
