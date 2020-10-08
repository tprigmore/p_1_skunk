package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{

	public static void main(String[] args)
	{
		int value = 0 ;
		StdOut.println("Welcome to the game skunk!");
		
		Dice dice = new Dice();
		
		dice.roll();
		
		value = dice.getLastRoll();
		StdOut.println("The dice total is: " + value);
	}

}