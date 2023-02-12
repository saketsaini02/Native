/**
 * 
 */
package corejava;

public class Prime {

	public static void main(String[] args) {
		{
			int inputNumber=10, range=inputNumber/2;
			boolean flag=false;
			//		for(int i=2;i<=range;i++)
			//		{
			//			if(inputNumber/2%i==0)
			//			{
			//				System.out.println(inputNumber+" is Prime");
			//				break;
			//			}
			//			else
			//				System.out.println(inputNumber+" is not Prime");
			//			break;
			//		} With this approach we get "Dead code" as in both cases we are breaking the loop, so in first instance only the loop will break
			// & the code i++ becomes dead/unused.
			//Instead if we use flag concept it will help.

			//Using for loop		
			for(int i=2;i<=range;i++)
			{System.out.println(i);
			if(inputNumber%i==0)
			{
				flag=true;break;
			}
			}
			if(flag)System.out.println(inputNumber+" is not Prime");
			else System.out.println(inputNumber+ " is Prime");



			//Using while loop
			int i=2;
			while(i<=range)
			{ 
				System.out.println(range);
				if(inputNumber%i==0)
				{
					flag=true;break;
				}
				else {
					i++;
				}
			}if(flag)System.out.println(inputNumber+" is not Prime");
			else System.out.println(inputNumber+" is Prime");

		}
	}
}
// A simple Java code to test the performance of the following looping methods : In Java, just compare the endTime and startTime
// to get the elapsed time of a function. A Java code to loop a List which containing 1, 5, 10 and 15 million records. The iterator
//loop is the slowest, and the difference between for loop and while loop isn’t that significant.

