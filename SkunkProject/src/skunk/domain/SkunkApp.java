package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{
	private enum State
	{
		SETUP, PLAY_ROUND, LAST_ROUND, ROUND_END, GAME_END, MATCH_END, DONE
	}

	private static State state = State.SETUP;

	public static void main(String[] args)
	{

		Controller controller = new Controller();

		StdOut.println("----------------------------------------------------");
		StdOut.println("--   Welcome to the game skunk! Version 1.0       --");
		StdOut.println("----------------------------------------------------\n\n");
		if (askYesOrNo("Do you want to play skunk? (y/n) ").equals("y"))
		{
			state = State.SETUP;
			if (askYesOrNo("Do you want to see the rules? (y/n) ").equals("y"))
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
				break;
			case PLAY_ROUND:
				playRound(controller);
				break;
			case ROUND_END:
				printRoundStats(controller);
				break;
			case LAST_ROUND:
				playLastRound(controller);
				break;
			case GAME_END:
				gameOver(controller);
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
		StdOut.print(question);
		String answer = StdIn.readLine();
		return answer;
	}

	private static String askYesOrNo(String question)
	{
		String answer = askQuestion(question);
		if (answer.toLowerCase().charAt(0) == 'y')
		{
			answer = "y";
		}
		return answer;
	}

	private static String takeATrun(Controller controller)
	{
		String answer;
		StdOut.print(controller.getPlayerName() + "'s turn. ");

		if (controller.takeATurn())
		{
			StdOut.print(" score is " + controller.getRunningTotal());
			StdOut.print(" Game points are " + controller.getPlayerGamePoints());
			answer = askYesOrNo(". Roll again (y/n)?");
		}
		else
		{
			StdOut.println("Got a " + controller.getTheDiceValues());
			answer = "n";
		}
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
			answer = askYesOrNo("Add another player (y/n)? ");

		}
		state = State.PLAY_ROUND;
	}

	private static void playRound(Controller controller)
	{
		String answer = "y";
		StdOut.println("------------ Next Round ---------------------------");

		while (state == State.PLAY_ROUND)
		{
			while (answer.equals("y"))
			{
				answer = takeATrun(controller);
			}
			StdOut.println(" ");

			if (controller.isPlayerOver100())
			{
				StdOut.println("!!!!!! " + controller.getPlayerName() + " is over 100. Playing last round!!!!!!");
				state = State.ROUND_END;
				controller.goToNextPlayer();
			}
			else
			{
				if (controller.goToNextPlayer())
				{
					state = State.PLAY_ROUND;
				}
				else
				{
					state = State.ROUND_END;
				}
			}
			answer = "y";
		}
	}

	private static void printRoundStats(Controller controller)
	{
		int currentIndex = controller.getPlayerIndex();
		state = State.PLAY_ROUND;
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
				state = State.LAST_ROUND;
			}
		}
		
		StdOut.println("Kitty has " + controller.getKittyChips() + " chips.");
		controller.setPlayerIndex(currentIndex);
	}

	private static void playLastRound(Controller controller)
	{
		String answer = "y";
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
			state = State.GAME_END;
		}

		while (state == State.LAST_ROUND)
		{
			while (answer.equals("y"))
			{
				answer = takeATrun(controller);
			}
			StdOut.println(" ");
			controller.goToNextPlayer();
			if (controller.getPlayerIndex() == lastIndex)
			{
				state = State.GAME_END;
			}
			answer = "y";
		}
	}

	private static void gameOver(Controller controller)
	{
		StdOut.println("-------------------Final Score--------------------");
		StdOut.println("The winner is " + controller.findTheWinner());
		printRoundStats(controller);
		StdOut.println("Game Over");
		state = State.DONE;
	}

}