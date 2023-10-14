
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int Partition(int[] arr, int lowIndex, int highIndex)
	{
		int low = lowIndex;
		int high = highIndex;
		
		int pivot = arr[(low + high)/2];
		
		boolean done = false;
		while(!done) {
			//check the item at the low index, and stop when this item is larger
			//or equal to the pivot
			while(arr[low] < pivot && low <= highIndex) {
				low++;
			}
			//check the item at the high index, and stop when item is smaller
			//than the pivot
			while(arr[high] >= pivot && high >= lowIndex) {
				high = high - 1;
			}
			
			if(high >= low) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			} else {
				done = true;
			}
		}
		return high;
	}
	
	public static int Partition2(int[] arr, int low, int high) {
		int start = low;
		int end = high;
		int pivot = arr[(low + high) / 2];
		int current = low;
		//compare current with pivot
		int currentValue = arr[current];
		if (currentValue < pivot) {//case 1: current item is smaller than pivot
			arr[current] = arr[start];
			arr[start] = currentValue;
			start++;
			current++;
			
		} else if(currentValue == pivot) {//case 2L current item is equal to pivot
			current++;
			
		} else {//case 3: current item is larger than pivot
			arr[current] = arr[end];
			arr[end] = currentValue;
			end--;
		}
		return end;
	}
	
	public static void QuickSort(int[] arr, int low, int high)	{
		//when quicksort stop?
		//when there is only one item past into the quicksort method
		//when low == high
		if(low == high) {
			return;
		} else {
			//partition
			int mid = Partition(arr, low, high);
			//recursively call quicksort
			QuickSort(arr, low, mid);
			QuickSort(arr, mid + 1, high);
		}
	}
	
	public static void MergeSort(int[] arr, int start, int end) {
		//terminate step
		if(start ==end) {
			return;
			int mid = (start + end) /2;
			MergeSort(arr, start, mid);
			MergeSort(arr, mid + 1, end);
			Merging(arr, start, mid, end);
		}
	}
	public static void Mergin(int[] arr, int start, int mid, int end) {
		//origin = 3, 6, 8, 2, 4, 5
		//leftArray = 3, 6,8
		//rightArray = 2, 4, 5
		//result array = 2, 3, 4, 5, 6, 9
		int leftStart = start;
		int leftEnd = mid;
		int rightStart = mid + 1;
		int rightEnd = end;
		int[] tempAr = new int[end-start + 1];
		int counter = 0;
		while(leftStart <= leftEnd || rightStart <= rightEnd) {
			if(arr[leftStart] < arr[rightStart]) {
				tempArr[counter] = arr[leftStart];
				counter++;
				leftStart++;
				//look back a recording 10/13/23
			}
		}
	}
	
}
