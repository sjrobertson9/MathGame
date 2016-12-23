
/**
 * Generates problems of various levels
 * @author lisa.yoo, emily.sine, sarah.robertson, joshua.slusar
 * @version 12.10.16
 */
public class ProblemGenerator 
{
	private int a;
	private int b;
	private int answer;
	
	/*
	 * Creates a problem generator object
	 */
	public ProblemGenerator()
	{
		a = 0;
		b = 0;
		answer = 0;
	}
	
	/*
	 * Returns a
	 * @return a
	 */
	public int getA()
	{
		return a;
	}
	
	/*
	 * Returns b
	 * @return b
	 */
	public int getB()
	{
		return b;
	}
	
	/*
	 * Generates and returns a level one problem
	 * Problems only involve addition of numbers less than 10 whose sum is less than 10
	 * @return problem 
	 */
	public String levelOne()
	{
		a = (int) (Math.random() * 9 + 1);
		b = (int) (Math.random() * 9 + 1);
		
		while ((a + b) > 10)
		{
			a = (int) (Math.random() * 9 + 1);
			b = (int) (Math.random() * 9 + 1);
		}
		
		answer = a + b;
		return a + " + " + b + " = ?";
	}
	
	/*
	 * Generates and returns a level two problem
	 * Problems only involve addition of one-digit numbers
	 * @return problem
	 */
	public String levelTwo()
	{
		a = (int) (Math.random() * 9 + 1);
		b = (int) (Math.random() * 9 + 1);
		answer = a + b;
		return a + " + " + b + " = ?";
	}
	
	/*
	 * Generates and returns a level three problem
	 * Problems involve subtraction of one-digit numbers with a non-negative difference
	 * @return problem
	 */
	public String levelThree()
	{
		a = (int) (Math.random() * 9 + 1);
		b = (int) (Math.random() * 9 + 1);
		
		while ((a - b) < 0)
		{
			a = (int) (Math.random() * 9 + 1);
			b = (int) (Math.random() * 9 + 1);
		}
		
		answer = a - b;
		return a + " - " + b + " = ?";
	}
	
	/**
	* Returns the answer to the problem
	* @return The answer to the problem
	*/
	public int getAnswer() 
	{
		return answer;
	}
            
           
}

/**
 * Keeps track of the score, levels, and number of guesses in a game
 * @author lisa.yoo, emily.sine, sarah.robertson, joshua.slusar
 * @version 12.14.16
 */
public class ScoreKeeper 
{
	private int score;
	private int level;
	private int numTrials;
	private ProblemGenerator probGen;
	private UserInteraction user;
	
	/*
	 * Creates a scorekeeper object with a given user and problem generator
	 * @param user UserInteraction object
	 * @param probGen ProblemGenerator object
	 */
	public ScoreKeeper(UserInteraction user, ProblemGenerator probGen)
	{
		score = 0;
		level = 1;
		numTrials = 3;
		this.probGen = probGen;
		this.user = user;
	}
	
	/*
	 * Returns the user's current score
	 * @return The user's current score
	 */
	public int getScore()
	{
		return score;
	}
	
	/*
	 * Returns the user's current level
	 * @return The user's current level
	 */
	public int getLevel()
	{
		return level;
	}
	
	/**
	 * Returns the user's current number of trials.
	 * @return The user's current number of trials
	 */
	public int getTrials()
	{
	    return numTrials;
	}
	
	/*
	 * Checks the answer of the user and returns a boolean
	 * @return isCorrect A boolean
	 */
	public boolean checkAnswer()
	{
		//if (probGen.getA() + probGen.getB() == user.getAnswer())
		if (probGen.getAnswer() == user.getAnswer())
		{
			score++;
			// Test
			if (score == 5) 
			{
				changeLevel(level + 1);
			}
			numTrials = 3;
			return true;
		}
		else
		{
			numTrials --;
			return false;
		}
	}
	
	/*
	 * Changes what level the user is on
	 * @param newLevel The new level to move up to
	 */
	public void changeLevel(int newLevel)
	{
		level = newLevel;
		resetScore();
	}
	
	public void resetScore() 
	{
		score = 0;
	}

	public void resetGame()
	{
		score = 0;
		level = 1;
		numTrials = 3;
	}
}

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Contains methods that take user input and interact with other classes
 * @author lisa.yoo, emily.sine, sarah.robertson, joshua.slusar
 * @version 12.16.16
 */
public class UserInteraction
{
    private static int answer;
    private ProblemGenerator problem;
    private ScoreKeeper score;
    private Scanner in;
    
    public UserInteraction()
    {
        in = new Scanner(System.in);
        answer = 0;
        problem = new ProblemGenerator();
        score = new ScoreKeeper(this, problem);
    }
    
    public void runGame()
    {
    	boolean wrongAnswer = false;
    	boolean isPlaying = true;
    	String saveProblem = "";
    	boolean badInput = false;
    	while(score.getLevel() <= 3 && isPlaying == true)
    	{
    		if (!wrongAnswer) 
		{
    			if (score.getLevel() == 1) 
			{
    				saveProblem = problem.levelOne();
    			} 
			else if (score.getLevel() == 2) 
			{
    				saveProblem = problem.levelTwo();
    			}
			else 
			{
    				saveProblem = problem.levelThree();
    			}  
    		}
    		System.out.println(saveProblem);
    		try 
		{
    			answer = in.nextInt();
    			badInput = false;
    		} 
		catch (InputMismatchException e) 
		{
    			System.out.println("Please type a valid integer input!");
    			in.next();
    			wrongAnswer = true;
    			badInput = true;
    		}
    		if (!badInput) 
		{
    			boolean result = score.checkAnswer();
    			if(!result) // if answer is wrong
    			{
    				wrongAnswer = true;
    				if(score.getTrials() != 0) // if user still has trials left
    				{
    					if(score.getTrials() == 1)
    						System.out.println("Try again. You have "+score.getTrials()+" attempt left.");
    					else
        					System.out.println("Try again. You have "+score.getTrials()+" attempts left.");
    				}
    				else // if numTrials = 3
    				{
    					//score.changeLevel(1);
    					score.resetScore();
    					System.out.println("Sorry, you lose, but you made it all the way to level "+score.getLevel()+"! The answer was "+answer+".");
    					System.out.println("Would you like to play again? Enter n for no, or anything else for yes.");
    					String keepPlaying = in.next();
    					if(keepPlaying.equals("n"))
					{
    						isPlaying = false;
					}
    					score.resetGame();
    				}
    			}
    			else if(result) 
			{
    				wrongAnswer = false;
    				if (score.getScore() % 5 != 0) 
				{
    					System.out.println("Good job! You got it right.");
    					System.out.println("Your current score is "+score.getScore()+" on level "+score.getLevel()+"!");
    				} 
				else 
				{
    					if(score.getLevel() > 3)
    					{
    						System.out.println("Congrats, you've won!");
    						System.out.println("Would you like to play again? Enter n for no, or anything else for yes.");
        					String keepPlaying = in.next();
        					if(keepPlaying.equals("n"))
						{
        						isPlaying = false;
						}
        					score.resetGame();
    					}
    					else
    						System.out.println("Congrats, you've advanced to the next level!");
    				}
    			}
    		}
       }
       
    }
    
    /**
     * Returns the user's answer
     * @return answer
     */
    public int getAnswer()
    {
        return answer;
    }
    
}

public class Tester 
{

	public static void main(String[] args) 
	{
		UserInteraction player = new UserInteraction();
		player.runGame();

	}

}


