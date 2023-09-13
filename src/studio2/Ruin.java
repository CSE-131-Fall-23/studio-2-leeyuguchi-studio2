package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		System.out.println("What is the start amount?");
		double startAmount = in.nextDouble();
		System.out.println("What is the probability that you will win (as a decimal)?");
		double winChance = in.nextDouble();
		System.out.println("What is the win limit?");
		double winLimit = in.nextDouble();
		System.out.println("How many simulations?");
		int totalSimulations = in.nextInt();
		
		int loss = 1;
		
		for (int numSimulation = 1; numSimulation <= totalSimulations; numSimulation ++)
		{
			int count = 1;
			while (startAmount > 0 && startAmount < winLimit)
			{	
				double x = Math.random();
				if (x > winChance)
				{
					startAmount --;
					count ++;
					loss ++;
				}
				else
				{
					startAmount ++;
					count ++;
				}
			}
			System.out.print("Simulation "+ numSimulation + ": "+ count);
			if (startAmount>0)
			{
				System.out.println(" WIN");
			}
			else
			{
				System.out.println(" LOSE");
			}
		}
	
	System.out.print("Losses: " + loss);
	System.out.println("Sinulations: " + totalSimulations);
	System.out.print("Ruin Rate from Simualtions: " + (loss/totalSimulations));
	
	if (winChance == 0.5) 
	{
		double expectedRuin = 1 - (startAmount/winLimit);
		System.out.print("Expected Ruin Rate: " + expectedRuin);
	}
	else
	{
		double a = (1-winChance)/winChance;
		double expectedRuin = (Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1-(Math.pow(a, winLimit)));
		System.out.print("Expected Ruin Rate: " + expectedRuin);
	}
	
	}
}

