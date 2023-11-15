package pack;

public class Driver {

	public static void main(String[] args) {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<Integer>();
		HugeInteger bigint = new HugeInteger("20", '+');
		HugeInteger bigint2 = new HugeInteger("91", '+');
		HugeInteger bigint3 = new HugeInteger("5", '+');
		HugeInteger lista = new HugeInteger();
		//LinkedList<Integer> lista = new LinkedList();
		//HugeInteger result = new HugeInteger();
		/*list.Append(1);
		list.Append(2);
		list.InsertAfter(list.Search(1),3);
		list.RemoveAfter(list.Search(1));
		System.out.println(list.Search(1).Data);*/
		System.out.println(bigint.compare(bigint2));
		HugeInteger result = bigint.multiply(bigint2);
		result.Print();
		HugeInteger result1 = bigint.plus(bigint2);
		result1.Print();
		list.Append(bigint);
		list.Append(bigint2);
		list.Append(bigint3);
		list.HugeIntSort();
		
		
	}
	
}