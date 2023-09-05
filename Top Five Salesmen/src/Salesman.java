public class Salesman {
	String name;
	float sales;
	boolean inTopFive = false;
	
	Salesman(String name, float sales){
		this.name = name;
		this.sales = sales;
	}
	/*for(int j = 0; j < topFive.length; j++ )
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
		
		System.out.println(topFive[j].name);
		
	}*/
}
