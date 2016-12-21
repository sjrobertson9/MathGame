/**
 * Generates problems of various levels
 * @author lisa.yoo
 * @version 12.10.16
 */
public class ProblemGenerator 
{
	private int a; // the first number in the problem
	private int b; // the second number in the problem
	
	/*
	 * Creates a problem generator object
	 */
	public ProblemGenerator()
	{
		a = 0;
		b = 0;
	}
	
	/*
	 * Returns a
	 * @return The first number in the generated problem
	 */
	public int getA()
	{
		return a;
	}
	
	/*
	 * Returns b
	 * @return The second number in the generated problem
	 */
	public int getB()
	{
		return b;
	}
	
	/*
	 * Generates and returns a level one problem
	 * Problems only involve addition of numbers less than 10 whose sum is less than 10
	 * @return The problem in the format a + b = ?
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
		
		return a + " + " + b + " = ?";
	}
	
	/*
	 * Generates and returns a level two problem
	 * Problems only involve addition of one-digit numbers
	 * @return The problem in the format a + b = ?
	 */
	public String levelTwo()
	{
		a = (int) (Math.random() * 9 + 1);
		b = (int) (Math.random() * 9 + 1);
		return a + " + " + b + " = ?";
	}
	
	/*
	 * Generates and returns a level three problem
	 * Problems involve subtraction of one-digit numbers with a non-negative difference
	 * @return The problem in the format a + b = ?
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
		
		return a + " - " + b + " = ?";
	}
}


