import java.util.Random;

public class isbBenchmarkCheck {

	public static void main(String[] args) {
		
		
		int array1[] = randomizeArray(20);
		int array2[] = array1;
		int array3[] = array1;
		insertSort(array1);
		selectionSort(array2);
		bubbleSort(array3);
		
		printArray(array1);

	}

	public static int[] insertSort(int array[]){
		long start = System.nanoTime();
		for(int i = 1; i < array.length; i++){
			int curr = i;
			for(int j = i-1; 0 <= j; j--){
				if(array[curr] >= array[j]){
					break;
				}
				else{
					int temp = array[j];
					array[j] = array[curr];
					array[curr] = temp;
					curr = j;
				}
			}
		}
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("Sorting a random array size of " + array.length + " took Insert Sort " + timeElapsed + "ns to complete.");
		return array;
	}
	
	public static int[] selectionSort(int array[])
	{
		long start = System.nanoTime();
		int temp;
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i + 1; j < array.length; j++)
			{
				if(array[i] < array[j])
				{
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("Sorting a random array size of " + array.length + " took Selection Sort " + timeElapsed + "ns to complete.");
		return array;
	}
	
	public static int[] bubbleSort(int array[])
	{
		long start = System.nanoTime();
		int temp;
		for(int j = 0; j < array.length -1; j++)
		{
			for(int i = 0; i < array.length - 1; i++)
			{
				if(array[i+1] < array[i])
				{
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
		
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("Sorting a random array size of " + array.length + " took Bubble Sort " + timeElapsed + "ns to complete.");
		return array;
	}
	
	public static int[] randomizeArray(int size)
	{
		Random random = new Random(); 
		int array[] = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			array[i] = random.nextInt(51);
		}
		return array;
	}
	
	public static int[] printArray(int array[])
	{
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
		return array;
	}
}
