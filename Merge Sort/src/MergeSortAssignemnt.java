import java.util.Random;

public class MergeSortAssignemnt {

	public static void main(String[] args) {
		int array[] = RandomArrayGenerator(100);

		displayArray(array);

		mergeSort(array, 0, array.length -1);
		
		displayArray(array);
		
	}

	
	public static void mergeSort(int[] numbers, int i, int k)
	{
		int j = 0;
		
		if(i < k)
		{
			j = (i + k) / 2;
			
			mergeSort(numbers, i, j);
			mergeSort(numbers, j + 1, k);
			
			merge(numbers, i, j, k);
		}
	}
	
	public static void merge(int[] numbers, int i, int j, int k)
	{
               
	      int temp;                                          
	      int leftPos = i;
	      int rightPos = j + 1;
	      
	      //sorts numbers
	      while (leftPos <= j && rightPos <= k)
	      {
	    	  if(numbers[leftPos] <= numbers[rightPos])
	    	  {
	    		  leftPos++;
	    	  }
	    	  else
	    	  {
	    		  temp = numbers[leftPos];
	    		  numbers[leftPos] = numbers[rightPos];
	    		  numbers[rightPos] = temp;
	    		  rightPos++;
	    	  }
	      }
	      
	      //sorts any left over numbers
	      while(leftPos < j)
	      {
	    	  if(numbers[leftPos] > numbers[leftPos + 1])
	    	  {
	    		  temp = numbers[leftPos];
	    		  numbers[leftPos] = numbers[leftPos + 1];
	    		  numbers[leftPos + 1] = temp;
	    	  }
	    	  leftPos++;
	      }
	      
	      //sorts any left over numbers
	      while (rightPos < k)
	      {
		        if(numbers[rightPos] > numbers[rightPos + 1])
		        {
		        	temp = numbers[rightPos];
		        	numbers[rightPos] = numbers[rightPos + 1];
		        	numbers[rightPos + 1] = temp;
		        }
				rightPos++;
	      }
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
}
