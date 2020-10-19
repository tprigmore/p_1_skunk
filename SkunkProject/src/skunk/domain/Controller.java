package skunk.domain;

public class Controller
{
	private String state;
	private Game game;
	
	public Controller() {
		this.state = "Setup" ;
		this.game = new Game();
	}
	
	public void addPlayer(String name) {
		this.game.addPlayer(name);
	}
	
	public String getPlayerName() {
		return this.game.getPlayerName();
	}

	public int getRunningTotal() {
		return this.game.getRunningTotal();
	}

	public boolean takeATurn() {
		return this.game.takeATurn();
	}

	public boolean goToNextPlayer()
	{
		return this.game.goToNextPlayer();
	}

	public int getPlayerCount()
	{
		return this.game.getPlayerCount();
	}

	public int getPlayerIndex()
	{
		return this.game.getPlayerIndex();
	}

	public void setPlayerIndex(int index)
	{
		this.game.setPlayerIndex(index);
	}

	public int getPlayerGamePoints()
	{
		return this.game.getPlayerGamePoints();
	}

	public int getPlayerChips()
	{
		return this.game.getPlayerChips();
	}

	public String getTheDiceValues()
	{
		return this.game.getTheDiceValues();
	}

}
