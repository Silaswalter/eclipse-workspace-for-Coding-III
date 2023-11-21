package pack;

import java.lang.Character;

public class HugeInteger extends MyDoublyLinkedList<Integer> {
	public char Sign;
	
	public HugeInteger() {
		super();
		this.Sign = '+';
	}
	
	public HugeInteger(String input, char sign) {
		this.Sign = sign;
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			this.Append(Character.getNumericValue(c));
		}
	}
	
	@Override
	public String toString() {
		String output = "";
		output += this.Sign;
		MyDoubleNode<Integer> node = this.Head;
		while(node != null) {
			output += node.Data;
			node = node.NextNode;
		}
		return output;
	}
	
	public HugeInteger ReverseSign() {
		String value = this.toString().substring(1);
		return new HugeInteger(value, this.Sign == '+' ? '-' : '+');
	}
	
	public int compare(HugeInteger hi) {
		if (this.Sign == hi.Sign && this.Sign == '+') {
			//1 compare length
			if (this.Size > hi.Size) {
				return 1;
			} else if (this.Sign < hi.Size){
				return -1;
			} else {
			//2 compare from head to tail one by one
				MyDoubleNode<Integer> thisNode = this.Head;
				MyDoubleNode<Integer> hiNode = hi.Head;
				while (thisNode != null) {
					if (thisNode.Data > hiNode.Data) {
						return 1;
					} else if (thisNode.Data < hiNode.Data){
						return -1;
					} else {
						thisNode = thisNode.NextNode;
						hiNode = hiNode.NextNode;
					}
				}
				return 0;
			}
		} else if (this.Sign == hi.Sign && this.Sign == '-') {
			HugeInteger thisReverse = this.ReverseSign();
			HugeInteger hiReverse = hi.ReverseSign();
			return thisReverse.compare(hiReverse);
		} else {
			if (this.Sign == '+') {
				return 1;
			} else {
				return -1;
			}
		}
	}
	
	public HugeInteger plus(HugeInteger hi) {
		HugeInteger result = new HugeInteger();
		int carrier = 0;
		int count = this.Size >= hi.Size ? this.Size : hi.Size;
		MyDoubleNode<Integer> thisNode = this.Tail;
		MyDoubleNode<Integer> hiNode = hi.Tail;
		int a = 0;
		int b = 0;
		int thisSize = this.Size;
		int hiSize = hi.Size;
		while (count > 0) {
			count--;
			if (thisSize > 0) {
				System.out.println(thisNode.Data);
				a = thisNode.Data;
				thisNode = thisNode.PreviousNode;
				thisSize--;
			} else {
				a = 0;
				thisSize--;
			}
			if (hiSize > 0) {
				b = hiNode.Data;
				hiNode = hiNode.PreviousNode;
				hiSize--;
			} else {
				b = 0;
				hiSize--;
			}
			int c = a + b + carrier;
			if (c >= 10) {
				result.Prepend(c - 10);
				carrier = 1;
			} else {
				result.Prepend(c);
				carrier = 0;
			}
			
		}
		if (carrier == 1) {
			result.Prepend(carrier);
		}
		return result;
	}
	
	public HugeInteger multiply(HugeInteger hi) {
		HugeInteger result = new HugeInteger();
		result.Append(0);
		MyDoubleNode<Integer> thisNode = hi.Tail;
		int count = this.Size >= hi.Size ? this.Size : hi.Size;
		int zeros = 0;
		while(count > 0) {
			HugeInteger tmpResult = this.multiplySingleDigit(thisNode.Data, zeros);
			result = result.plus(tmpResult);
			zeros++;
			thisNode = thisNode.PreviousNode;
			count--;
		}
		return result;
	}
	
	//every steps of multiply
	public HugeInteger multiplySingleDigit(int i, int zeros) {
		int carrier = 0;
		int tmpResult = 0;
		HugeInteger result = new HugeInteger();
		MyDoubleNode<Integer> thisNode = this.Tail;
	
		int count = this.Size;
		while(count > 0) {
			tmpResult = carrier + thisNode.Data * i;
			result.Prepend(tmpResult % 10);
			carrier = tmpResult / 10;
			thisNode = thisNode.PreviousNode;
			count--;
		}
		if(carrier > 0) {
			result.Prepend(carrier);
		}
		for(int k = 0; k < zeros; k++) {
			result.Append(0);
		}
		return result;
	}
	
	public void Print() {
		String list = "";
		//gets the starting node
		MyDoubleNode<Integer> currNode = this.Tail;
		//moves through the list and adds them to the list String
		int third = 0;
		boolean canUseComma = false;
		for(int i = 0; i < this.Size; i++) {
			list = currNode.Data + list;
			third++;
			//System.out.println(third);
			if(currNode != this.Head) {
			if(canUseComma == true) {
			if(third % 3 == 0){
				list = "," + list;
					}
				}
			}
			if(canUseComma == false) {
				canUseComma = true;
			}
			currNode = currNode.PreviousNode;
		}
		if(this.Sign == '-') {
			list = this.Sign + list;
		}
		//prints the string of nodes as it was added
		System.out.println(list);

	}
	
	/*public void HugeIntSort() {
		MyDoubleNode<Integer> currNode = this.Head;
		MyDoubleNode<Integer> tempNode = new MyDoubleNode<Integer>();
		for(int i = 1; i < this.Size; i++){
			currNode = this.Head;
			for(int j = 0+1; j < this.Size; j++){
				int k = currNode.Data.compare(currNode.NextNode.Data);
				if(k < 0) {
					tempNode.Data = currNode.Data;
					currNode.Data = currNode.NextNode.Data;
					currNode.NextNode.Data = tempNode.Data;
				}
				currNode = currNode.NextNode;
			}
		}
	}*/
}
