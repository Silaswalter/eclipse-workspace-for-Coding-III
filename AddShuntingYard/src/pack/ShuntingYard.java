package pack;

public class ShuntingYard {
    public LinkedList Tokens;
    public OutputQueue ReversePolish;
    
    public ShuntingYard() {
    	this.Tokens = new LinkedList();
    	this.ReversePolish = new OutputQueue();
    }
    
    public void parse(String input) {
    	String numbers = "0123456789";
    	String temp = "";
    	for(int i = 0; i < input.length(); i++) {
    		if(numbers.indexOf(input.charAt(i)) >= 0){
    			temp += input.charAt(i);
    		}else {
    			if(temp.length() > 0) {
    				this.Tokens.append(temp);
    			}
    			temp = "";
    			this.Tokens.append(Character.toString(input.charAt(i)));
    		}
    	}
    	if(temp != null && temp.length() > 0) {
    		this.Tokens.append(temp);
    	}
    }
    
    public void process() {
    	OpStack operatorStack = new OpStack();
    	Node token = this.Tokens.Head;
    	while(token != null) {
    		if(operatorStack.IsLeftParenthesis(token.Data)) {
    			operatorStack.push(token.Data);
    		}else if(operatorStack.IsRightParenthesis(token.Data)) {
    			while(!operatorStack.isEmpty() && !operatorStack.IsLeftParenthesis(operatorStack.peek().Data)) {
    				ReversePolish.enqueue(operatorStack.pop().Data);
    			}
    			if(!operatorStack.isEmpty() && operatorStack.IsLeftParenthesis(operatorStack.peek().Data)){
    				operatorStack.pop();
    			}
    		}else if(operatorStack.IsOperator(token.Data)) {
    			if(token.Data.charAt(0) == '+' || token.Data.charAt(0) == '-') {
    				while(!operatorStack.isEmpty() && (operatorStack.peek().Data.charAt(0) == '*' || operatorStack.peek().Data.charAt(0) == '/')) {
    					this.ReversePolish.enqueue(operatorStack.pop().Data);
    				}
    			}
    			operatorStack.push(token.Data);
    		}else {
    			this.ReversePolish.enqueue(token.Data);
    		}
    		token = token.NextNode;
    	}
    	while(!operatorStack.isEmpty()) {
    		ReversePolish.enqueue(operatorStack.pop().Data);
    	}
    }
    
    public int run() {
    	OpStack tempstack = new OpStack();
    	while(!ReversePolish.isEmpty()) {
    		String temp = ReversePolish.dequeue().Data;
    		if(tempstack.IsOperator(temp)) {
    			int x = Integer.parseInt(tempstack.pop().Data);
    			int y = Integer.parseInt(tempstack.pop().Data);
    			switch(temp.charAt(0)) {
    				case '*':
    					x = y * x;
    					break;
    				case '/':
    					x = y / x;
    					break;
    				case '+':
    					x = y + x;
    					break;
    				case '-':
    					x = y - x;
    					break;
    				default:
    					break;
    			}
    			tempstack.push(Integer.toString(x));
    		}else {
    			tempstack.push(temp);
    		}
    	}
    	return Integer.parseInt(tempstack.pop().Data);
    }
}