
public class MatrixSearch {

	public static void main(String[] args) {
		
		int matrix [][] = {	{0,1,2,3},
							{4,5,6,7},
							{8,9,10,11}
							};
		
		String location = search(matrix, 2);
		System.out.println(location);
	}
	
	public static String search(int[][] matrix, int key)
	{
	//used to get the highest array in the array of arrays
	int colMax = matrix.length -1;
	int rowMax = matrix[colMax].length -1;
	int high = matrix[colMax][rowMax];
	
	//used to get the lowest array in the array of arrays
	int low = matrix[0][0];
	
	//used to initialize these variable since they are out of the loop
	int col = 0;
	int row = 0;
	
	//loops until key is found
	boolean running = true;
	while(running == true)
	{
		int medium = (high+low)/2;
		
		//used to get the location of the middle variable in the matrix
		col = (medium)/4;
		row = (medium)%4;
		
		//used to change the high range or low range depending on whether the key is greater or less then them
		if(medium < key)
		{
			low = medium;
			
			//used to make sure that when it goes to the next array it doesn't go out of bounds. If it were, it would instead go to the next array
			if(row+1 < rowMax)
			{
				row = row +1;

			}
			else
			{
				col = col +1;
			}
		}
		else
		{
			high = medium;
		}

		//when the key is found the loop will end and return the location of the key
		if(matrix[col][row] == key)
		{
			running = false;
		}
	}
	//returns the found key with it's location
	String h = "(" + col +"," + row + ")";
	return h;
}
	
	
}
