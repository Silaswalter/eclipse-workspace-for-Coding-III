package pack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
public class driver {
//0.195
	public static void main(String[] args) {
		//System.out.println("Hello");
		ArrayList<HumanGroup> disciples = new ArrayList<HumanGroup>();
		HumanGroup firstDisciples = new HumanGroup();
		long totalPopulation = 150000000L;
		
		firstDisciples.Age = 30;
		firstDisciples.Population = 13;
		firstDisciples.IsDisciple = true;
		disciples.add(firstDisciples);

		long christianPopulation = 13L;
		
		ArrayList<HumanGroup> nonBelievers = new ArrayList<HumanGroup>();
		HumanGroup otherHuman = new HumanGroup();
		otherHuman.Age = 18;
		otherHuman.Population = totalPopulation - christianPopulation;
		nonBelievers.add(otherHuman);
		
		ArrayList<HumanGroup> apprentices = new ArrayList<HumanGroup>();
		
		//long totalPopulation = getPopulation(disciples, nonBelievers, apprentices);
		//long christianPopulation = getPopulation(disciples);
		
		long totalNewApprentice;
		
		int year = 0;
		
		boolean canTeach = true;
		boolean fallAway = false;

		while(christianPopulation < totalPopulation && !nonBelievers.isEmpty() && !disciples.isEmpty())
		{
			//check who is going to die. remove them
			
			Iterator<HumanGroup> discipleIt = disciples.iterator();
			while(discipleIt.hasNext())
			{
				HumanGroup curr = discipleIt.next();
				if(curr.Age >= Human.MaxAge)
				{
					discipleIt.remove();
				}
			}
			
			
			Iterator<HumanGroup> apprenticeIt = apprentices.iterator();
			while(apprenticeIt.hasNext())
			{
				HumanGroup curr = apprenticeIt.next();
				if(curr.Age >= Human.MaxAge)
				{
					apprenticeIt.remove();
				}
			}
			
			
			Iterator<HumanGroup> nonBelieverIt = nonBelievers.iterator();
			while(apprenticeIt.hasNext())
			{
				HumanGroup curr = nonBelieverIt.next();
				if(curr.Age >= Human.MaxAge)
				{
					nonBelieverIt.remove();
				}
			}
			//System.out.println(nonBelieverRemoved);
			
			//check if there is new baby, all baby is 0 years old at this moment
			long totalBaby = 0;
			for(HumanGroup g: disciples)
			{
				if(g.Age == Human.AgeOfGivingBirth && year > 0)
				{
					totalBaby += 2*(g.Population);
				}
			}
			for(HumanGroup g: apprentices)
			{
				if(g.Age == Human.AgeOfGivingBirth)
				{
					totalBaby += 2*(g.Population);
				}
			}
			for(HumanGroup g: nonBelievers)
			{
				if(g.Age == Human.AgeOfGivingBirth)
				{
					totalBaby += 2*(g.Population);
				}
			}
			
			if(totalBaby > 0)
			{
				HumanGroup baby = new HumanGroup();
				baby.Population = totalBaby;
				nonBelievers.add(baby);
				System.out.println(totalBaby);
			}
			
			//check if non-believer can be apprentice, check number of disciples
			totalNewApprentice = 0;
			//training disciples is hard, so people sometimes need break
			if(canTeach == true) {
				for(HumanGroup g: disciples)
				{
					if(g.YearsInTeaching == 0)
					{
						totalNewApprentice += g.Population * Human.CapOfApprentice;
					}
				}
				canTeach = false;
			}else {
				canTeach = true;
			}
			//convert nonbeliever to apprentice from younger to older
			Collections.sort(nonBelievers, HumanGroup.ageAscComparator);
			//loop through all nonbelievers, and convert all groups until totalqualified disciple = 0
			//check number of qualified non-believers
			nonBelieverIt = nonBelievers.iterator();
			//woke stuff hinders the spreading of the Gospel

			while(nonBelieverIt.hasNext() && totalNewApprentice > 0)
			{
				HumanGroup curr = nonBelieverIt.next();
				if(curr.Age >= Human.AgeAsApprentice)
				{
					HumanGroup newApprentice = curr.Clone();
					newApprentice.IsApprentice = true;
					if(curr.Population <= totalNewApprentice)
					{
						nonBelieverIt.remove();
						totalNewApprentice -= curr.Population;
					}
					else
					{
						curr.Population -= totalNewApprentice;
						newApprentice.Population = totalNewApprentice;
						totalNewApprentice = 0;
					}
					
					//sometimes Christians can fall away from the faith
					if(fallAway == true) {
						fallAway = false;
					}else {
					apprentices.add(newApprentice);
					fallAway = true;
					}
					
				}
				
			}
			
			

			for(HumanGroup hg: disciples)
			{
				hg.Aging();
				if(hg.YearsInTeaching >= Human.YearToBeDisciple)
				{
					hg.YearsInTeaching = 0;
				}
			}
			
			apprenticeIt = apprentices.iterator();
			while(apprenticeIt.hasNext())
			{
				HumanGroup curr = apprenticeIt.next();
				curr.Aging();
				if(curr.YearsAsApprentice == Human.YearToBeDisciple)
				{
					curr.YearsAsApprentice = 0;
					curr.IsApprentice = false;
					curr.IsDisciple = true;
					apprenticeIt.remove();
					disciples.add(curr);
				}
			}
			
			for(HumanGroup hg: nonBelievers)
			{
				hg.Aging();
			}
			totalPopulation = getPopulation(disciples, nonBelievers, apprentices);
			christianPopulation = getPopulation(disciples);
			year++;
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
			System.out.println("Year " + (1 + year) + ": Christian population is: " + christianPopulation + ", and total population is " + totalPopulation + ". Christians account for " + String.format("%.2f",(((float)christianPopulation / totalPopulation)*100)) + "%.");
			
			
		}
		
		System.out.println(year);
		
	}
	
	public static long getPopulation(ArrayList<HumanGroup> dis, ArrayList<HumanGroup> non, ArrayList<HumanGroup> app)
	{
		long total = 0;
		for(HumanGroup h: dis)
		{
			total += h.Population;
		}
		for(HumanGroup h: non)
		{
			total += h.Population;
		}
		for(HumanGroup h: app)
		{
			total += h.Population;
		}
		return total;
	}
	
	public static long getPopulation(ArrayList<HumanGroup> dis)
	{
		long total = 0;
		for(HumanGroup h: dis)
		{
			total += h.Population;
		}
		return total;
	}
	

}
