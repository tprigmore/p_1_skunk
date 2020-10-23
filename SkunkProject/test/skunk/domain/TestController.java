package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestController
{

	@Test
	void test_controller_state()
	{
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		assertEquals("Scott", controller.getPlayerName());
	}

}
