package pack;

public class MyNode {
	public String Data;
	public MyNode NextNode;
	
	public MyNode()
	{
		this.Data = "";
		this.NextNode = null;
	}
	
	public boolean IsNull()
	{
		
		int s = this.charToNumb(this.Data.charAt(1));
		return s < 0;
	}
	
	public int charToNumb(char a) {
		char x = Character.toLowerCase(a);
		char array[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
				't', 'u', 'v', 'w', 'x', 'y', 'z'};
		for(int i = 0; i < array.length; i++)
		{
			if(x == array[i]) {
				return i;
			}
		}
		return -1;
	}

}
