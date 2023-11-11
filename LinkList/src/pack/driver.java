package pack;

public class driver {

	public static void main(String[] args) {
		
		MySinglyLinkedListList list = new MySinglyLinkedListList();
		//System.out.println(list.IsEmpty());
		//list.SearchNode(5);
		//System.out.println(list.SearchNode(5).Data);
		//System.out.println(list.SearchNode(6).Data);
		//list.PrintReverse();
		list.Prepend(5);
		list.Append(6);
		list.Append(7);
		list.Append(8);
		list.Print();
		//list.Remove(list.SearchNode(6).Data);
		list.Sort();
		list.Print();
		//list.Remove(list.SearchNode(8).Data);
		list.Print();
		list.Append(9);
		list.Prepend(10);
		list.Print();
		//System.out.println(list.IsEmpty());

		

	}
	
}
