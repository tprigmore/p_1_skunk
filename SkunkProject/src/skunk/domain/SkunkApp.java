package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{
	private enum State
	{
		SETUP, PLAY_ROUND, LAST_ROUND, ROUND_END, GAME_END, MATCH_END, DONE
	}

	public static void main(String[] args)
	{

		State state = State.SETUP;
		StdOut.println("Welcome to the game skunk! Version 1.0");

		Controller controller = new Controller();
		while (state != State.DONE)
		{
			switch (state)
			{
			case SETUP:
				setupGame(controller);
				state = State.PLAY_ROUND;
				break;
			case PLAY_ROUND:
				if (playRound(controller))
				{
					state = State.PLAY_ROUND;
				}
				else
				{
					state = State.ROUND_END;
				}
				break;
			case ROUND_END:
				if (printRoundStats(controller))
				{
					state = State.PLAY_ROUND;
				}
				else
				{
					state = State.LAST_ROUND;
				}
				break;
			case LAST_ROUND:
				if (playLastRound(controller))
				{
					state = State.LAST_ROUND;
				}
				else
				{
					state = State.GAME_END;
				}
				break;
			case GAME_END:
				playLastRound(controller);
				StdOut.println("Game Over");
				break;
	
			default:
				state = State.DONE;
				break;
			}

		}
	}

	private static String askQuestion(String question)
	{
		String answer;
		StdOut.print(question);
		answer = StdIn.readLine();
		return answer;
	}

	private static void setupGame(Controller controller)
	{
		String answer = "y";
		while (answer == "y")
		{
			answer = askQuestion("Enter player name: ");
			StdOut.println("You typed : " + answer);
			controller.addPlayer(answer);
			answer = askQuestion("Add another player (y/n)?: ");
			answer.toLowerCase();
		}
	}

	private static boolean playRound(Controller controller)
	{
		String answer = "y";
		boolean roundActive = true;
		while (roundActive)
		{
			while (answer == "y")
			{
				if (controller.takeATurn())
				{
					answer = askQuestion(controller.getPlayerName() + "'s turn Score is " + controller.getRunningTotal()
							+ ". Play again (y/n)?");
				}
			}
			roundActive = controller.goToNextPlayer();
		}

		return false;
	}

	private static boolean playLastRound(Controller controller)
	{
		String answer = "y";
		boolean roundActive = true;
		while (roundActive)
		{
			while (answer == "y")
			{
				if (controller.takeATurn())
				{
					answer = askQuestion(controller.getPlayerName() + "'s turn Score is " + controller.getRunningTotal()
							+ ". Play again (y/n)?");
				}
			}
			roundActive = controller.goToNextPlayer();
		}

		return false;
	}

	private static boolean printRoundStats(Controller controller)
	{
		boolean retValue = true;
		int currentIndex = controller.getPlayerIndex();
		StdOut.println("---------------------------------------------------");

		for (int i = 0; i < controller.getPlayerCount(); i++)
		{
			controller.setPlayerIndex(i);
			StdOut.println(controller.getPlayerName() + ": turn=" + controller.getRunningTotal() + " game="
					+ controller.getPlayerGamePoints() + " chips=" + controller.getPlayerChips());
			if (controller.getRunningTotal() > 100)
			{
				retValue = false;
			}
		}
		StdOut.println("---------------------------------------------------");

		controller.setPlayerIndex(currentIndex);
		return retValue;
	}

}