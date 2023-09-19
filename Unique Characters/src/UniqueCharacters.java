
public class UniqueCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String unique = "plates";
		
		boolean answer = IsAllUnique(unique);
		System.out.println(answer);
	}
	
	
	
	public static boolean IsAllUnique(String unique)
	{
	String map = "abcdefghijklmnopqrstuvwxyz";
	boolean[] check = new boolean[25];		
	for(int i = 0; i < check.length; i++)
	{
		check[i] = false;
	}
		for(int i = 0; i < unique.length(); i++)
		{
			for(int j = 0; j < map.length(); j ++)
			{
				if(unique.charAt(i) == map.charAt(j))
				{
					if(check[j] == false)
					{
						check[j] = true;
					}
					else
					{
						return false;
					}
				}
			}
		}
		return true;
	}

}
