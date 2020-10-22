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

	public String getRules()
	{
		String rules = 
				"\nThe game of Skunk was created by named W.H. Schaper back in 1953\n" +
				"To win a game of Skunk you need to be the first player to score \n" +
				"100 points or more.\n\n" +
				"A Skunk player scores points by rolling both dice at once and adding\n" +
				"the total of the two.  For example, if a three and a five are rolled,\n" +
				"that Skunk player would have earned 8 points.\n" + 
				"A player can choose to stop at the end of any roll and keep their \n" +
				"accumulated game points or try to roll again for even more points.\n" +
				"A Player accumulates turn points until the decide to pass or get skunked.\n" +
				"If a player passes, the accumulated turn points become game points. Game\n" +
				"points are safe unless the player rolls a double skunk.\n\n" +
				"If a player rolls a skunk (a single one) the rollers turn is immediately\n" +
				"over and the players accumulated turn points are lost, and must put a \n" +
				"chip in the kitty.\n\n" +
				"Rolling a skunk - deuce (a roll of single one and a two) the rollers \n" +
				"turn is immediately over and their accumulated turn points are lost,\n" +
				" and they must put two chips in the kitty.\n\n" +
				"If a player rolls a double skunk (double ones), their turn is over, \n" +
				"they lose all the points for that turn, AND they lose any game points \n" +
				"they might have and need to start accumulating points all over again.\n" + 
				"They must also put 4 chips in the kitty\n\n" + 
				"When a player reaches 100 points or more on their turn, they have two \n" +
				"options.  They can keep rolling to raise the needed winning number for\n" +
				"other players, or they can stop.\n" + 
				"When the first player to reach or exceed 100 points stops, all the other\n" +
				"players get another chance to roll, giving them a chance to win the game.\n" +
				"The winning player gets all the kitty points.\n";
		
		return rules;
	}

}
