package pack;

public class driver {

	public static void main(String[] args) {
		
		MySinglyLinkedListList list = new MySinglyLinkedListList();
		//System.out.println(list.IsEmpty());
		//list.SearchNode(5);
		//System.out.println(list.SearchNode(5).Data);
		//System.out.println(list.SearchNode(6).Data);
		//list.Remove(list.SearchNode(6).Data);
		//list.Remove(list.SearchNode(8).Data);
		//System.out.println(list.IsEmpty());
		/*char z = 'Z';
		System.out.println(z);
		System.out.println(charToNum(z));*/
		//list.PrintReverse();
		list.Prepend("Peter");
		list.Append("Andrew");
		list.Append("James");
		list.Append("John");
		list.Prepend("Philip");
		list.Append("Bartholomew");
		list.Append("Thomas");
		list.Append("Matthew");
		list.Append("James");
		list.Append("Thaddaeus");
		list.Append("Simon");
		list.Prepend("Judas");
		
		
		list.Remove(list.SearchNode("Judas").Data);
		list.Sort();
		list.PrintReverse();


	}
	
	
}
