package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer
{

	@Test
	void test_player_constructor()
	{
		Player player1 = new Player("Scott");
		assertEquals("Scott", player1.getName());
		
	}
	
	@Test
	void test_player_set_get_game_points()
	{
		Player player1 = new Player("Scott");
		player1.setGamePoints(13);
		assertEquals(13, player1.getGamePoints());	
	}
	
	@Test
	void test_player_set_get_turn_points()
	{
		Player player1 = new Player("Scott");
		assertEquals(0, player1.getTurnPoints());	
	}

	@Test
	void test_player_set_get_chips()
	{
		Player player1 = new Player("Scott");
		player1.setChips(50);
		assertEquals(50, player1.getChips());	
	}
	
	@Test
	void test_player_empty_constructor()
	{
		Player player1 = new Player();
		assertEquals("John Doe", player1.getName());
		
	}
}
