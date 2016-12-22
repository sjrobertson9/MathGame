import java.util.Scanner;

/**
 * Contains methods that take user input and interact with other classes
 * @author lisa.yoo
 * @version 12.16.16
 */
public class UserInteraction
{
	private int answer;
	private static final String INSTRUCTIONS = "Type your answer and press 'enter'.";
	private ProblemGenerator problem;
	private ScoreKeeper score;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int answer = in.next();
		problem = new ProblemGenerator();
		System.out.println(INSTRUCTIONS);
		System.out.println();
		System.out.println(problem.levelOne());
		if(!score.checkAnswer())
		{
			if(score.getTrials() < 3)
			{
				System.out.println("Try again. You have "+score.getTrials()+" attempts left.");
			}
			else
			{
				score.changeLevel(1);
				System.out.println("Sorry, you lose. Type 'Y' and press enter to start over.");
			}
		}
		else if(score.checkAnswer())
		{
			System.out.println("Good job! You got it right.");
			System.out.println("Your current score is "+score.getScore());
		}
		else if(score.checkAnswer()&&score.getScore()==5)
		{
			System.out.println("Congrats, you've advanced to the next level!");
			if(score.getLevel() == 1)
			{
				score.changeLevel(2);
			}
			else
				score.changeLevel(3);
		}
		else if(score.checkAnswer()&&score.getScore()==5&&score.getLevel()==3)
		{
			System.out.println("Congratulations, you've won the game!");
			System.out.println("Type 'start over' and press 'enter' to start a new game.");
		}
		
		System.out.print("The answer is: "+getAnswer()+".");

	}
	
	/*
	 * Returns the user's answer
	 * @return answer
	 */
	public static int getAnswer()
	{
		return answer;
	}
	
}


