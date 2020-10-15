package skunk.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGame
{

	@Test
	public void test_gamePlayer()
	{
		Game game = new Game();
		assertEquals("Player one",game.getPlayer());
	}

}
