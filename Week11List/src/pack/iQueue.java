package pack;

public interface iQueue<T> {
		
		void Enqueue(T data);
		//pop
		T Dequeue();
		//peek
		T peek();
		//isempty
		public boolean isEmpty();
		//getlength
		public int getLength();

}
