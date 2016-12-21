import java.util.Scanner;

/**
 * Contains methods that take user input and interact with other classes
 * @author lisa.yoo
 * @version 12.16.16
 */
public class UserInteraction 
{
	private int answer;
	
	public UserInteraction()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("The answer is: ");

	}
	
	/*
	 * Returns the user's answer
	 * @return answer
	 */
	public int getAnswer()
	{
		return answer;
	}
}


