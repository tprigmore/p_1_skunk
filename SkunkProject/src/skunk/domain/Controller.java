package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

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

	public String findTheWinner()
	{
		int winnerIndex = 0;
		int maxPoints = 0;
		int points;
		for(int i = 0; i < game.getPlayerCount(); i++) {
			game.setPlayerIndex(i);
			points = game.getPlayerGamePoints();
			if (points > maxPoints) {
				maxPoints = points;
				winnerIndex = i;
			}
		}
		this.setPlayerIndex(winnerIndex);
		this.giveWinnerKitty();

		return this.getPlayerName();
	}

	public int getKittyChips()
	{
		return this.game.getKitty();
	}

	public void giveWinnerKitty()
	{
		this.game.setPlayerChips(this.game.getPlayerChips() + this.game.getKitty());
		this.game.setKitty(0);
	}

}
