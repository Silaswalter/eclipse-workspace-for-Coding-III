
public class HelloWorld {

	public static void main(String[] args) {
		
		String[] salesMen = {"Jim", "Bob", "Sam", "Steve", "John"};
		float[] sales = {1, 2, 3, 5, 4};
		System.out.println("Hello World");
		//System.out.println(salesMen[1]);
		String[] topFive = new String[5];
		float first = 0;
		//String bestSeller = "";
		
		for(int j = 0; j < topFive.length; j++)
		{
			for(int i = 0; i < salesMen.length; i++)
			{
				if(first < sales[i])
				{
					first = sales[i];
					topFive[j] = salesMen[i];
					//System.out.println(topFive[j]);
				}			
			}
			for(int k = 0; k < salesMen.length; k++)
			{
				if(first == sales[k])
				{
					sales[k] = 0;
					//System.out.println(sales[k]);
					first = 0;
				}
			}
			
			System.out.println(topFive[j]);
		}
		System.out.println(topFive);
		
		
	}

}
