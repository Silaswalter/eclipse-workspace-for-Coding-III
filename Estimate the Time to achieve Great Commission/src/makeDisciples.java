
public class makeDisciples {

	public static void main(String[] args) {
	
	//Answer to question 1
	convertPopulation();
	
	//Answer to question 2
	howManyToTrainWithTimeGiven(50);
		

	}
	public static int convertPopulation()
	{
		long population = 7700000000l;
		long disciples = 13;
		int trainable = 2;
		int yearTakes = 3;
		int timePassed = 0;
		while(disciples < population)
		{
			disciples = disciples + (disciples * trainable);
			timePassed = timePassed + yearTakes;
		}
		System.out.println(timePassed + " Years to convert the World");
		return timePassed;
	}
	
	public static int howManyToTrainWithTimeGiven(int years)
	{
		long population = 7700000000l;
		long disciples = 13;
		int yearTakes = 3;
		int timePassed = 51;
		int trainable;
		for(trainable = 1; years <= timePassed ; trainable++)
		{
			timePassed = 0;
			disciples = 13;
			while(disciples < population)
			{
				disciples = disciples + (disciples * trainable);
				timePassed = timePassed + yearTakes;
			}
			
		}
		//the for loop makes there be 1 more disciple then there should be, which is why I subtract one
		trainable = trainable - 1;
		System.out.println("To make everyone Christian within " + years + " years, " + trainable + " disciples would need to be trained at a time");
		return trainable;
	}
}
