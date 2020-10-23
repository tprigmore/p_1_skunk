package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestController
{

	@Test
	void test_controller_add_and_get_player()
	{
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		assertEquals("Scott", controller.getPlayerName());
	}

	@Test
	void test_controller_get_running_total()
	{
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		assertEquals(0, controller.getRunningTotal());
	}
	
	@Test
	void test_controller_go_to_next_player()
	{
		Controller controller = new Controller();
		controller.addPlayer("Scott");

		assertEquals("Scott", controller.getPlayerName());
		controller.addPlayer("Joe");
		controller.takeATurn();
		controller.goToNextPlayer();
		assertEquals("Joe", controller.getPlayerName());
	}

	@Test
	void test_controller_get_player_index()
	{
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		
		assertEquals(0, controller.getPlayerIndex());
	}	
	
	@Test
	void test_controller_get_player_count()
	{
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		controller.addPlayer("Joe");
		assertEquals(2, controller.getPlayerCount());
	}	
	
	@Test
	void test_controller_set_player_index()
	{
		Controller controller = new Controller();
		controller.setPlayerIndex(1);
		assertEquals(1, controller.getPlayerIndex());
	}	
	
	@Test
	void test_controller_get_player_game_points()
	{
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		assertEquals(0, controller.getPlayerGamePoints());
	}	

}
