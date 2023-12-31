package pack;

public class Stack <T> extends MyDoublyLinkedList<T> implements iStack<T> {


	@Override
	public void push(T data) {
		this.Prepend(data);
	}

	@Override
	public T pop() {
		if(this.Head.NextNode == this.Head) {
			this.Head = null;
			this.Tail = null;
			this.Size--;
			System.out.println("Hi");
		}
		this.Head = this.Head.NextNode;
		this.Head.PreviousNode = null;
		this.Size--;
		return null;
	}

	@Override
	public T peek() {
		if(this.Head != null) {
			return this.Head.Data;
		}else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		if(this.Head==null) {
			return true;
		}
		return false;
	}

	@Override
	public int getLength() {
		return this.Size;
	}

}
