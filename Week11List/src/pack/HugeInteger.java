package pack;

import java.lang.Character;

public class HugeInteger extends MyDoublyLinkedList<Integer> {
	public char Sign;
	private String numbers = "0123456789";
	
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
		output += Sign;
		MyDoubleNode<Integer> node = this.Head;
		while(node != null) {
			output += node.Data;
			node = node.NextNode;
		}
		return output;
	}
	
	public HugeInteger ReverseSign() {
		if(this.Sign == '+') {
			String value = this.toString();
			value = '-' + value.substring(1);			
		}else if(this.Sign = '-') {
			value = '+' + value.substring(1);
		}
		return new HugeInteger(value, this.Sign == '+' ? '-': '+');
	}
	
	public int compare(HugeInteger hi) {
		if(this.Sign == hi.Sign && this.Sign == '+') {
			//1 compare length
			if(this.Size > hi.Size) {
				return 1;
			}else if(this.Sign < hi.Size){
				return -1;
			}else {
			//2 compare from head to tail one by one
				MyDoubleNode<Integer> thisNode = this.Head;
				MyDoubleNode<Integer> hiNode = hi.Head;
				while(thisNode != null) {
					if(thisNode.Data > hiNode.Data) {
						return 1;
					}else if(thisNode.Data < hiNode.Data) {
						return -1;
					}else {
						thisNode = thisNode.NextNode;
						hiNode = hiNode.NextNode;
					}
				}
				return 0;
			}
		}else if(this.Sign == hi.Sign && this.Sign == '-') {
			HugeInteger thisReverse = this.ReverseSign();
			HugeInteger hiReverse = hi.ReverseSign();
			return thisReverse.compare(hiReverse);			
		}else {
			if(this.Sign == '+') {
				
			}
		}
	}
	
	public HugeInteger plus(HugeInteger hi) {
		HugeInteger result = new HugeInteger();
		int carrier = 0;
		int count = this.Size > 
		int a = 0;
		int b = 0;
		while(count > 0) {
			if(thisNode != null)
		
	}
	}
	
	public HugeInteger multiply()

}
