
public class FibonacciSequence {

	public static void main(String[] args) {
		
		getSequence(9);
		

	}

	public static int getSequence(int length)
	{
		//initializing the variables
		int first = 0;
		int second = 1;
		int temp = 0;
		//goes through the number of times imputed by the user
		for(int i = 0; i < length; i++)
		{
			//temp holds the original first variable so that the
			//second variable can become the first after they are added
			temp = first;
			
			//addition of the two numbers to calculate the Fibonacci number
			first = first + second;
			
			//when second becomes temp's value, essential what first was before
			//the addition, so that whenever first and second are added it doesn't
			//just add 1 + 1
			second = temp;
			
		}
		System.out.println("Fibonacci number generated " + first);
		System.out.print("times to get the value "+ length);
		return first;
	}
	
	
	
}
