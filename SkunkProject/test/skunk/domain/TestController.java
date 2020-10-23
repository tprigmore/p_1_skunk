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

	

}
