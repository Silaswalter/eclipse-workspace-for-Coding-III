package pack;

public interface iStack<T> {
		//push
		void push(T data);
		//pop
		T pop();
		//peek
		T peek();
		//isempty
		public boolean isEmpty();
		//getlength
		public int getLength();

}
