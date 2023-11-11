package pack;

public class MySinglyLinkedListList implements MyList {
	MyNode Head;
	MyNode Tail;
	int Size;
	
	public MySinglyLinkedListList() {
		this.Head = null;
		this.Tail = null;
		this.Size = 0;
	}
	
	@Override
	public boolean InsertAfter(String n, String o) {
		//searches for node
		MyNode currNode = this.SearchNode(n);
		//makes sure the node isn't null
		if(currNode == null) {
			return false;
		} else {
			//makes new node
			MyNode newNode = new MyNode();
			newNode.Data = o;
			//adjusts the pointers of nodes to fit the new node in
			MyNode nextNode = currNode.NextNode;
			currNode.NextNode = newNode;
			newNode.NextNode = nextNode;
			this.Size++;
			return true;
		}
	}
	
	public boolean RemoveAfter(String n) {
		//searches for node
		MyNode currNode = this.SearchNode(n);
		//makes sure the node isn't null
		if(currNode == null) {
			return false;
		}else {
			
			MyNode nextNode = currNode.NextNode;
			//if the next node is null, nothing would be removed
			if(nextNode == null) {
				return true;
			}
			//removes the node after the target and adjusts its point to the one after the one being removed
			MyNode nextNextNode = nextNode.NextNode;
			currNode.NextNode = nextNextNode;
			nextNode.NextNode = null;
			this.Size--;
			return true;
	}
}
	
	public MyNode SearchNode(String n) {
		//starts at head
		MyNode currNode = this.Head;
		//moves through the list until it finds the target node
		while(currNode != null) {
			if (currNode.Data == n) {
				return currNode;
			}else {
				currNode = currNode.NextNode;
			}			
		}
		return null;
	}
	@Override
	public void Append(String x) {
		MyNode newNode = new MyNode();
		newNode.Data = x;
		//if there is no head, it makes a new one
		if(this.Head == null) {
			this.Head = newNode;
			this.Tail = newNode;
		}
		//makes the new node the tail and makes the previous tail point to the new one
		this.Tail.NextNode = newNode;
		this.Tail = newNode;
		this.Size++;
		

	}

	@Override
	public void Prepend(String x) {
		MyNode newNode = new MyNode();
		newNode.Data = x;
		//if there is no head, it makes a new one
		if(this.Head == null) {
			this.Head = newNode;
			this.Tail = newNode;
		}
		//makes the new node the head and makes it point to the previous head
		newNode.NextNode = this.Head;
		this.Head = newNode;
		this.Size++;

	}

	@Override
	public boolean Remove(String x) {
		//searches for node
		MyNode tarNode = this.SearchNode(x);
		//if the head is the target, it is removed
		if(tarNode == this.Head) {
			this.Head = tarNode.NextNode;
			tarNode = null;
			Size--;
			return true;
		}
		//make extra variables to set up getting the node before the target
		MyNode prevNode = this.Head;
		MyNode currNode = prevNode.NextNode;
		//gets to the target node and previous node
		while(currNode != tarNode) {
			currNode = currNode.NextNode;
			prevNode = prevNode.NextNode;
		}
		//removes the target node and adjust the previous nodes pointer
		prevNode.NextNode = currNode.NextNode;
		currNode = null;
		Size--;
		return true;
	}

	@Override
	public int Search(String x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Print() {
		String list = "";
		//gets the starting node
		MyNode currNode = this.Head;
		//moves through the list and adds them to the list String
		for(int i = 0; i < this.Size; i++) {
			list = list + currNode.Data;
			if(i != Size -1){
				list = list + ", ";
			}
			currNode = currNode.NextNode;
		}
		//prints the string of nodes as it was added
		System.out.println(list);

	}

	@Override
	public void PrintReverse() {
		String list = "";
		//gets the starting node
		MyNode currNode = this.Head;
		//moves through the list and adds them to the list String in reverse
		for(int i = 0; i < this.Size; i++) {
			list = currNode.Data + list;
			if(i != Size -1){
				list = ", " + list;
			}
			currNode = currNode.NextNode;
		}
		//prints the string of nodes as it was added in reverse
		System.out.println(list);

	}

	@Override
	public void Sort() {
		MyNode currNode = this.Head;
		MyNode tempNode = new MyNode();
		//Use bubble sort to sort the list
		for(int i = 1; i < this.Size; i++){
			currNode = this.Head;
			for(int j = 0+1; j < this.Size; j++){
				//get the first letter of there name and convert it to a number
				int s = this.charToNum(currNode.Data.charAt(0));
				int q = this.charToNum(currNode.NextNode.Data.charAt(0));
				//bubble sort swap occurs here
				if(s > q) {
					tempNode.Data = currNode.Data;
					currNode.Data = currNode.NextNode.Data;
					currNode.NextNode.Data = tempNode.Data;
				}
				currNode = currNode.NextNode;
			}
		}
	}
	public int charToNum(char a) {
		char x = Character.toLowerCase(a);
		char array[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
				't', 'u', 'v', 'w', 'x', 'y', 'z'};
		//take a char and compare it to an array of chars and return the 
		//position of the char that matches to make it a number instead
		for(int i = 0; i < array.length; i++)
		{
			if(x == array[i]) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean IsEmpty() {
		//if head is null that means that list is empty
		if(this.Head == null) {
			return true;
		}else {
			return false;
			}
	}

	@Override
	public int GetLength() {
		return Size;
	}

}
