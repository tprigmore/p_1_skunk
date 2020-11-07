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
		Controller controller = new Controller();

		StdOut.println("----------------------------------------------------");
		StdOut.println("--   Welcome to the game skunk! Version 1.0       --");
		StdOut.println("----------------------------------------------------\n\n");
		if (askQuestion("Do you want to play skunk? (y/n) ").equals("y"))
		{
			state = State.SETUP;
			if (askQuestion("Do you want to see the rules? (y/n) ").equals("y"))
			{
				StdOut.println(controller.getRules());
			}

		}
		else
		{
			state = State.DONE;
		}

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
				gameOver(controller);
				state = State.DONE;
				break;

			default:
				state = State.DONE;
				break;
			}
		}
		StdOut.println("BYE");
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
		StdOut.println("\n--------------------------------------------------");
		while (answer.equals("y"))
		{
			answer = askQuestion("Enter player name: ");
			StdOut.println("You typed : " + answer + "\n");
			controller.addPlayer(answer);
			answer = askQuestion("Add another player (y/n)? ");
			answer.toLowerCase();
		}
	}

	private static boolean playRound(Controller controller)
	{
		String answer = "y";
		boolean roundActive = true;
		StdOut.println("------------ Next Round ---------------------------");

		while (roundActive)
		{
			while (answer.equals("y"))
			{
				answer = takeATrun(controller);
			}
			StdOut.println(" ");

			if (controller.isPlayerOver100())
			{
				StdOut.println("!!!!!! " + controller.getPlayerName() + " is over 100. Playing last round!!!!!!");
				roundActive = false;
				controller.goToNextPlayer();
			}
			else
			{
				roundActive = controller.goToNextPlayer();
			}
			answer = "y";
		}

		return false;
	}

	private static boolean playLastRound(Controller controller)
	{
		String answer = "y";
		boolean roundActive = true;
		int startingIndex;
		int lastIndex = 0;

		StdOut.println("------------ Last Round ---------------------------");
		if (controller.getPlayerCount() > 1)
		{
			startingIndex = controller.getPlayerIndex();
			if (startingIndex == 0)
			{
				lastIndex = controller.getPlayerCount() - 1;
			}
			else
			{
				lastIndex = startingIndex - 1;
			}
		}
		else
		{
			roundActive = false;
		}

		while (roundActive)
		{
			while (answer.equals("y"))
			{
				answer = takeATrun(controller);
			}
			StdOut.println(" ");
			controller.goToNextPlayer();
			if (controller.getPlayerIndex() == lastIndex)
			{
				roundActive = false;
			}
			answer = "y";
		}

		return false;
	}

	private static String takeATrun(Controller controller)
	{
		String answer;
		StdOut.print(controller.getPlayerName() + "'s turn. ");

		if (controller.takeATurn())
		{
			StdOut.print(" score is " + controller.getRunningTotal());
			StdOut.print(" Game points are " + controller.getPlayerGamePoints());
			answer = askQuestion(". Roll again (y/n)?");
		}
		else
		{
			StdOut.println("Got a " + controller.getTheDiceValues());
			answer = "n";
		}
		return answer;
	}

	private static boolean printRoundStats(Controller controller)
	{
		boolean retValue = true;
		int currentIndex = controller.getPlayerIndex();
		StdOut.println("---------------------------------------------------");

		for (int i = 0; i < controller.getPlayerCount(); i++)
		{
			controller.setPlayerIndex(i);
			StdOut.print(controller.getPlayerName());
			StdOut.print(": turn=" + controller.getRunningTotal());
			StdOut.print(" game=" + controller.getPlayerGamePoints());
			StdOut.println(" chips=" + controller.getPlayerChips() + "\n");
			if (controller.getPlayerGamePoints() >= 100)
			{
				retValue = false;
			}
		}
		StdOut.println("Kitty has " + controller.getKittyChips() + " chips.");

		// StdOut.println("---------------------------------------------------");

		controller.setPlayerIndex(currentIndex);
		return retValue;
	}

	private static void gameOver(Controller controller)
	{

		StdOut.println("-------------------Final Score--------------------");
		StdOut.println("The winner is " + controller.findTheWinner());
		printRoundStats(controller);
		StdOut.println("Game Over");
	}

}