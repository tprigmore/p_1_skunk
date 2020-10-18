package skunk.domain;

import java.util.ArrayList;

public class Game
{
	private ArrayList<Player> playerArray = new ArrayList<Player>();
	private Player activePlayer;
	private Kitty kitty;
	private Turn turn;
	private int playerCount;
	private int playerIndex;

	public Game()
	{
		this.playerCount = 0;
		this.playerIndex = 0;
		this.kitty = new Kitty();
	}

	public String getPlayerName()
	{
		Player player;
		player = this.playerArray.get(playerIndex);
		return player.getName();
	}

	public void setPlayerName(String name)
	{
		Player player;
		player = this.playerArray.get(playerIndex);
		player.setName(name);
	}

	public int getRunningTotal()
	{
		Player player;
		player = this.playerArray.get(playerIndex);
		return (player.getTurnPoints());
	}

	public int getPlayerCount()
	{
		return (this.playerCount);
	}

	public int getPlayerIndex()
	{
		return (this.playerIndex);
	}

	public void setPlayerIndex(int index)
	{
		this.playerIndex = index;
	}

	public void addPlayer(String name)
	{
		Player player = new Player(name);
		this.playerArray.add(player);
		this.playerCount++;
	}

	public void setKitty(int chips)
	{
		this.kitty.setKitty(chips);
	}

	public int getKitty()
	{
		return this.kitty.getKitty();
	}

	public boolean goToNextPlayer()
	{
		boolean retValue = true ;
		playerIndex++;
		if (playerIndex == playerCount)
		{
			playerIndex = 0;
			retValue = false;
		}
		return retValue;
	}

	public int getPlayerGamePoints()
	{
		Player player;
		player = this.playerArray.get(playerIndex);
		return player.getGamePoints();
	}

	public void SavePlayerPoints()
	{
		int points = this.activePlayer.getTurnPoints();
		points += this.activePlayer.getGamePoints();
		this.activePlayer.setGamePoints(points);
		this.activePlayer.setTurnPoints(0);
	}

	public boolean takeATurn()
	{
		this.activePlayer = this.playerArray.get(playerIndex);
		this.turn = new Turn(this.activePlayer, this.kitty);
		return (turn.takeATurn());
	}

	public int getPlayerChips()
	{
		return this.getPlayerChips();
	}

}
