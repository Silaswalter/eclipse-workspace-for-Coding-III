package pack;

public class Queue <T> extends MyDoublyLinkedList<T> implements iQueue<T> {
	
	@Override
	public void Enqueue(T data) {
		this.Append(data);
	}

	@Override
	public T Dequeue() {
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
