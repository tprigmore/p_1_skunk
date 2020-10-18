package skunk.domain;
import java.util.ArrayList;

public class Game
{
	private ArrayList<Player> playerArray = new ArrayList<Player>() ;
	private Player activePlayer;
	private Kitty kitty;
	private Turn turn;
	private int playerCount;
	private int playerIndex;
	private String gameState;
	
	public Game() {
		this.playerCount = 0;
		this.playerIndex = 0;
		this.kitty = new Kitty();
		this.gameState = "Setup";
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

	public void goToNextPlayer() 	{
		playerIndex++;
		if(playerIndex == playerCount) {
			playerIndex = 0;
		}
		this.gameState = "Playing";
	}
	
	public int getPlayerGamePoints()
	{
		Player player;
		player = this.playerArray.get(playerIndex);
		return player.getGamePoints();
	}

	public void SavePlayerPoints() 	{
		int points = this.activePlayer.getTurnPoints();
		points += this.activePlayer.getGamePoints();
		this.activePlayer.setGamePoints(points);
		this.activePlayer.setTurnPoints(0);
	}
	
	public String takeATurn()
	{
		this.gameState = "Playing";
		this.activePlayer = this.playerArray.get(playerIndex);
		this.turn = new Turn(this.activePlayer, this.kitty);
		if (!turn.takeATurn()) {
			this.goToNextPlayer();
			this.gameState = "Next Player";
		}
		if (this.activePlayer.getGamePoints() >= 100) {
			this.gameState = "Over One Hundred";
		}
		return this.gameState;
	}

}
