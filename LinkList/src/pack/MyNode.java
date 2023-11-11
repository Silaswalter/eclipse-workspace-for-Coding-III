package pack;

public class MyNode {
	public int Data;
	public MyNode NextNode;
	
	public MyNode()
	{
		this.Data = -1;
		this.NextNode = null;
	}
	
	public boolean IsNull()
	{
		return this.Data < 0;
	}

}
