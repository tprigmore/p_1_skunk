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
	void test_player_set_get_points()
	{
		Player player1 = new Player("Scott");
		player1.setPoints(13);
		assertEquals("Scott", player1.getPoints());
		
	}
}
