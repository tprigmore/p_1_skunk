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
	
	public void setPlayerChips(int chips)
	{
		this.game.setPlayerChips(chips);
	}

	public String getTheDiceValues()
	{
		return this.game.getTheDiceValues();
	}

	public boolean isPlayerOver100() {
		return(this.getPlayerGamePoints() + this.getRunningTotal() >= 100) ;
	}

	public int findTheWinner()
	{
		int highIndex = 0;
		int maxPoints = 0;
		int points;
		for(int i = 0; i < game.getPlayerCount(); i++) {
			game.setPlayerIndex(i);
			points = game.getPlayerGamePoints();
			if (points > maxPoints) {
				maxPoints = points;
				highIndex = i;
			}
		}
		return highIndex;
	}

	public int getKittyChips()
	{
		return game.getKitty();
	}

	public void giveWinnerKitty()
	{
		game.setPlayerChips(game.getPlayerChips() + game.getKitty());

		
	}

}
