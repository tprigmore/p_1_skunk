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
		while (count < 100)
		{
			count++;
			if (controller.takeATurn())
			{
				if (controller.getRunningTotal() > 20)
				{
					controller.goToNextPlayer();
				}
			}
			else
			{
				controller.goToNextPlayer();
			}
			if (controller.getPlayerGamePoints() > 100)
			{
				assertValue = true;
				break;
			}
		}

		assertEquals("Scott", controller.findTheWinner());
	}

	@Test
	public void test_is_player_over_100()
	{
		boolean assertValue = false;
		int count = 0;
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		while (count < 100)
		{
			count++;
			if (controller.takeATurn())
			{
				if (controller.getRunningTotal() > 20)
				{
					controller.goToNextPlayer();
				}
			}
			else
			{
				controller.goToNextPlayer();
			}
			if (controller.isPlayerOver100())
			{
				assertValue = true;
				break;
			}
		}

		assertEquals("Scott", controller.findTheWinner());
	}

	@Test
	void test_get_dice_values()
	{
		boolean returnvalue = false;
		Controller controller = new Controller();
		controller.addPlayer("Scott");
		controller.takeATurn();
		String str = controller.getTheDiceValues();
		String str1 = str.substring(0, 1);
		if (str1.equals("1"))
		{
			str1 = str.substring(0, 2);
		}
		int number = Integer.parseInt(str1);
		if ((number >= 2) && (number <= 12))
		{
			returnvalue = true;
		}
	}

	@Test
	void test_get_rules()
	{

		Controller controller = new Controller();
		String rules = "\nThe game of Skunk was created by named W.H. Schaper back in 1953\n"
				+ "To win a game of Skunk you need to be the first player to score \n" + "100 points or more.\n\n"
				+ "A Skunk player scores points by rolling both dice at once and adding\n"
				+ "the total of the two.  For example, if a three and a five are rolled,\n"
				+ "that Skunk player would have earned 8 points.\n"
				+ "A player can choose to stop at the end of any roll and keep their \n"
				+ "accumulated game points or try to roll again for even more points.\n"
				+ "A Player accumulates turn points until the decide to pass or get skunked.\n"
				+ "If a player passes, the accumulated turn points become game points. Game\n"
				+ "points are safe unless the player rolls a double skunk.\n\n"
				+ "If a player rolls a skunk (a single one) the rollers turn is immediately\n"
				+ "over and the players accumulated turn points are lost, and must put a \n" + "chip in the kitty.\n\n"
				+ "Rolling a skunk - deuce (a roll of single one and a two) the rollers \n"
				+ "turn is immediately over and their accumulated turn points are lost,\n"
				+ " and they must put two chips in the kitty.\n\n"
				+ "If a player rolls a double skunk (double ones), their turn is over, \n"
				+ "they lose all the points for that turn, AND they lose any game points \n"
				+ "they might have and need to start accumulating points all over again.\n"
				+ "They must also put 4 chips in the kitty\n\n"
				+ "When a player reaches 100 points or more on their turn, they have two \n"
				+ "options.  They can keep rolling to raise the needed winning number for\n"
				+ "other players, or they can stop.\n"
				+ "When the first player to reach or exceed 100 points stops, all the other\n"
				+ "players get another chance to roll, giving them a chance to win the game.\n"
				+ "The winning player gets all the kitty points\n";
		assertEquals(rules, controller.getRules());
	}

}
