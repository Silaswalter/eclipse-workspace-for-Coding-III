package pack;

public class MySinglyLinkedList {
	MyNode Header;
	int Size;
	
	public MySinglyLinkedList(){
		this.Header = null;
		this.Size = 0;
	}
	
	/*
	public boolean InsertAfter(int n, int o) {
		MyNode currNode = this.Search(n);
		if (currNode == null) {
			return false;
		} else {
			MyNode newNode = new MyNode();
			newNode.Data = o;
			MyNode nextNode = currNode.NextNode;
			currNode.NextNode = newNode;
			newNode.NextNode = nextNode;
			this.Size++;
			return true;
		}
	}
	
	public boolean RemoveAfter(int n) {
		MyNode currNode = this.Search(n);
		if (currNode == null) {
			return false;
		} else {
			MyNode nextNode = currNode.NextNode;
			if (nextNode == null) {
				return true;
			}
			MyNode nextNextNode = nextNode.NextNode;
			currNode.NextNode = nextNextNode;
			nextNode.NextNode = null;
			this.Size--;
			return true;
		}
	}
	
	//return the first node whose payload match the value we are searching
	//return null, when no node match the value
	public MyNode Search(int n) {
		MyNode currNode = this.Header;
		while (currNode != null) {
			if (currNode.Data == n) {
				return currNode;
			} else {
				currNode = currNode.NextNode;
			}
		}
		return null;
	}*/

}