
public class BubbleSort {

	public static void main(String[] args) {
		int numbers[] = { 4,5,3,1,2};
		//System.out.println(num);
		numbers = bubbleSort(numbers);
		for(int i = 0; i < numbers.length; i++)
		{
			System.out.println(numbers[i]);
		}
		
	
	}

	
	public static int[] bubbleSort(int num[])
	{
		int temp;
		for(int j = 0; j < num.length -1; j++)
		{
			for(int i = 0; i < num.length - 1; i++)
			{
				if(num[i+1] < num[i])
				{
					temp = num[i];
					num[i] = num[i+1];
					num[i+1] = temp;
				}
			}
		}
		
		return num;
	}
}
