import java.util.Random;
import java.lang.Math;


public class quickVSshell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int array1[] = RandomArrayGenerator(1000);
		int[] array2 = array1.clone();

		displayArray(array1);
		long start = System.nanoTime();
		ShellSort(array1);
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("Sorting a random array size of " + array1.length + " took Shell Sort " + timeElapsed + "ns to complete.");
		displayArray(array1);
		
		System.out.println(" ");
		
		displayArray(array2);
		long start2 = System.nanoTime();
		quicksort(array2, 0, array2.length-1);
		long finish2 = System.nanoTime();
		long timeElapsed2 = finish2 - start2;
		System.out.println("Sorting a random array size of " + array1.length + " took Quick Sort " + timeElapsed2 + "ns to complete.");
		displayArray(array2);
	}
	
	public static void ShellSort(int[] arr)
	{
		int length = arr.length;
		int n = (int)Math.floor(Math.log(length + 1));
		for(int i = n; i > 0; i--)
		{
			int interval = (int)Math.pow(2, i) -1;
			for(int start = 0; start < interval; start++)
			{
				ShellSortPartition(arr, start, interval);
			}
		}
	}
	
	public static void ShellSortPartition(int[] arr, int startIndex, int interval)
	{
		for(int i = startIndex; i < arr.length; i = i + interval)
		{
			int pos = i;
			while(pos - interval >= startIndex && arr[pos - interval] > arr[pos])
			{
				int temp = arr[pos];
				arr[pos] = arr[pos - interval];
				arr[pos - interval] = temp;
				pos = pos - interval;
			}
		}
	}
	
	private static int partition(int[] numbers, int startIndex, int endIndex)
	{
	      int midpoint = startIndex + (endIndex - startIndex) / 2;
	      int pivot = numbers[midpoint];
	      int low = startIndex;
	      int high = endIndex;
	   
	      boolean done = false;
	      while (!done)
	      {
	         while (numbers[low] < pivot)
	         {
	            low = low + 1;
	         }
	      

	         while (pivot < numbers[high])
	         {
	            high = high - 1;
	         }
	      
	     
	         if (low >= high)
	         {
	            done = true;
	         }
	         else
	         {
	            int temp = numbers[low];
	            numbers[low] = numbers[high];
	            numbers[high] = temp;
	            low++;
	            high--;
	         }
	      }
	      return high;
	   }
	   
	   private static void quicksort(int[] numbers, int startIndex, int endIndex)
	   {
	      if (endIndex <= startIndex)
	      {
	         return;
	      }   
	      int high = partition(numbers, startIndex, endIndex);
	      quicksort(numbers, startIndex, high);
	      quicksort(numbers, high + 1, endIndex);
	   }
			
	
	public static int[] RandomArrayGenerator(int size)
	{
		int[] result = new int[size];
		Random r = new Random();
		for(int i = 0; i < size; i++)
		{
			result[i] = i;
		}
		for(int i = 0; i < size; i++)
		{
			int pos = r.nextInt(size);
			int temp = result[i];
			result[i] = result[pos];
			result[pos] = temp;
		}
		return result;
	}
	
	public static void displayArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + ", ");
		}
		System.out.println(" ");
	}
	
	
	/*public static void QuickSort(int[] arr, int low, int high)
	{
		if(low >= high)
		{
			return;
		}
		else
		{
			int mid = Partition(arr, low, high);
			
			QuickSort(arr, low, mid);
			QuickSort(arr, mid + 1, high);
		}
	}
	
	public static int Partition(int[] arr, int lowIndex, int highIndex)
	{
		int low = lowIndex;
		int high = highIndex;
		
		int pivot = arr[(low + high)/2];
		
		boolean done = false;
		while(!done)
		{
			while(arr[low] < pivot && low <= highIndex)
			{
				low = low + 1;
			}
			
			while(arr[high] >= pivot && high > lowIndex)
			{
				high = high - 1;
			}
			
			if(high > low)
			{
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
			else
			{
				done = true;
			}
		}
		return high;
	}*/
}
