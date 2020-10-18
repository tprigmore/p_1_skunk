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
		game.addPlayer(name);
	}
	
	public String getPlayerName() {
		return game.getPlayerName();
	}

	public int getRunningTotal() {
		return game.getRunningTotal();
	}

	public boolean takeATurn() {
		return game.takeATurn();
	}

	public boolean goToNextPlayer()
	{
		return game.goToNextPlayer();
	}

	public int getPlayerCount()
	{
		return game.getPlayerCount();
	}

	public int getPlayerIndex()
	{
		return game.getPlayerIndex();
	}

	public void setPlayerIndex(int index)
	{
		game.setPlayerIndex(index);
	}

	public int getPlayerGamePoints()
	{
		return game.getPlayerGamePoints();
	}

	public int getPlayerChips()
	{
		// TODO Auto-generated method stub
		return game.getPlayerChips();
	}

}
