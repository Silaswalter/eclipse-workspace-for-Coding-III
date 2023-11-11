package pack;

public class Driver {

	public static void main(String[] args) {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<Integer>();
		list.Append(1);
		list.Append(2);
		list.InsertAfter(list.Search(1),3);
		list.RemoveAfter(list.Search(1));
		System.out.println(list.Search(3).Data);
		
	}
}