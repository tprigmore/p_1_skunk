package skunk.domain;

import static org.junit.Assert.assertTrue;
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
	
	@Test
	void test_controller_get_player_chips()
	{
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		assertEquals(50, controller.getPlayerChips());
	}
	
	@Test
	void test_controller_set_player_chips()
	{
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		controller.setPlayerChips(25);
		assertEquals(25, controller.getPlayerChips());
	}
	
	@Test
	void test_controller_get_kitty()
	{
		Controller controller = new Controller();
		assertEquals(0, controller.getKittyChips());
	}
	
	@Test
	public void test_game_for_winner()
	{
		boolean assertValue = false;
		int count = 0;
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		while (count < 100) {
			count++;
			if (controller.takeATurn()) {
				if (controller.getRunningTotal() > 20) {
					controller.goToNextPlayer();
				}
			} 
			else {
				controller.goToNextPlayer();
			}
			if(controller.getPlayerGamePoints() > 100) {
				assertValue = true;
				break;
			}
		}

		assertEquals("Scott", controller.findTheWinner());
	}
	
	
}
