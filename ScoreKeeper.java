/**
 * Keeps score of the game
 * @author lisa.yoo
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
	 * Creates a scorekeeper object
	 */
	public ScoreKeeper()
	{
		score = 0;
		level = 1;
		numTrials = 0;
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
	
	/*
	 * Checks the answer of the user and returns a boolean
	 * @return isCorrect A boolean
	 */
	public boolean checkAnswer()
	{
		if (probGen.getA() + probGen.getB() == user.getAnswer())
		{
			score++;
			numTrials = 0;
			return true;
		}
		else
		{
			numTrials = 1;
			return false;
		}
	}
	
	/*
	 * Based on the number of points, changes the level
	 */
	public void changeLevel()
	{
		if(level==1 && score == 5)
		{
			level++;
			score = 0;
		}
		else if(level == 2 && score == 5)
		{
			level++;
			score = 0;
		}
	}
}
