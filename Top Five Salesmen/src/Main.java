
public class Main {


	public static void main(String[] args) {
		
		Salesman s1 = new Salesman("Jim", 123);
		Salesman s2 = new Salesman("Sam", 846);
		Salesman s3 = new Salesman("Bob", 343);
		Salesman s4 = new Salesman("John", 754);
		Salesman s5 = new Salesman("Steve", 261);
		Salesman s6 = new Salesman("Joseph", 403);
		Salesman s7 = new Salesman("Jack", 674);
		Salesman s8 = new Salesman("Paul", 538);
		Salesman[] dudes = {s1, s2, s3, s4, s5, s6, s7, s8};

		
		Salesman[] five = topFiveDudes(dudes);		
		
		for(int i = 0; i < five.length; i++)
		{
			System.out.println(five[i].name);
		}						
	}
	
	
	public static Salesman[] topFiveDudes(Salesman dudes[]) {
		float first = 0;
		Salesman topFive[] = new Salesman[5];
		
		for(int j = 0; j < topFive.length; j++ )
		{
			for(int i = 0; i < dudes.length; i++) 
			{
				if(dudes[i].inTopFive == false)
				{
					if(first < dudes[i].sales) 
					{
						first = dudes[i].sales;
						topFive[j] = dudes[i];
					}
				}	
			}
			for(int k = 0; k < dudes.length; k++)
			{
				if(first == dudes[k].sales)
				{
					dudes[k].inTopFive = true;
					first = 0;
				}
			}
		}				
		return topFive;
	}
}
