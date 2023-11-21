package pack;

public class Driver {

	public static void main(String[] args) {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<Integer>();
		/*HugeInteger bigint = new HugeInteger("20", '+');
		HugeInteger bigint2 = new HugeInteger("91", '+');
		HugeInteger bigint3 = new HugeInteger("5", '+');
		HugeInteger lista = new HugeInteger();
		LinkedList<Integer> lista = new LinkedList();
		HugeInteger result = new HugeInteger();
		list.Append(1);
		list.Append(2);
		list.InsertAfter(list.Search(1),3);
		list.RemoveAfter(list.Search(1));
		System.out.println(list.Search(1).Data);
		System.out.println(bigint.compare(bigint2));
		HugeInteger result = bigint.multiply(bigint2);
		result.Print();
		HugeInteger result1 = bigint.plus(bigint2);
		result1.Print();*/
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(6);
		stack.push(4);
		System.out.println(stack.isEmpty());
		System.out.println(stack.getLength());
		stack.pop();
		System.out.println(stack.isEmpty());
		System.out.println(stack.getLength());
		System.out.println(stack.peek());
		
		/*Queue<Integer> queue = new Queue<Integer>();
		queue.Enqueue(8);
		queue.Enqueue(2);
		queue.Dequeue();
		System.out.println(queue.getLength());
		System.out.println(queue.peek());*/
		
		
		
		
		
		
	}
	
}