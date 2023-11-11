package pack;

public interface MyList {
	public void Append(String x);
	
	public void Prepend(String x);
	
	public boolean InsertAfter(String w, String x);
	
	public boolean Remove(String x);
	
	public int Search(String x);
	
	public void Print();
	
	public void PrintReverse();
	
	public void Sort();
	
	public boolean IsEmpty();
	
	public int GetLength();
	
}
