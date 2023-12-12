package pack;

public class BinarySearchTree {
	public Node Root;
	
	public BinarySearchTree() {
		Root = null;
	}
	
	public Node Search(int value) {
		Node currentNode = Root;
		while(currentNode != null) {
			if(currentNode.Data == value) {
				return currentNode;
			}else if(value < currentNode.Data) {
				currentNode = currentNode.leftNode;
			}else {
				currentNode = currentNode.rightNode;
			}
		}
		return null;
	}
	
	/*public Node Search(int value) {
		//Go to root node
		Node node = this.Root;
		while(node != null) {
		//compare the value of the node
			//matches, return the node
			if(node.Data == value) {
				return node;
			} else if(value <= node.Data) {
				node = node.leftNode;
			} else if(value > node.Data) {
				node = node.rightNode;
			}
		}
		return null;
	}*/
	
	public void Insert(int value) {
		Node newNode = new Node(value);
		if(Root == null) {
			Root = newNode;
		}else {
			Node currentNode = Root;
			while(currentNode != null) {
				if(newNode.Data < currentNode.Data) {
					if(currentNode.leftNode == null) {
						currentNode.leftNode = newNode;
						currentNode = null;
					}else {
						currentNode = currentNode.leftNode;
					}
				}else {
					if(currentNode.rightNode == null) {
						currentNode.rightNode = newNode;
						currentNode = null;
					}else {
						currentNode = currentNode.rightNode;
					}
				}
			}
		}
	}
	
	/*public void insert(int value) {
		Node newNode = new Node(value);
		Node node = this.Root;
		if(this.Root == null) {
			this.Root = newNode;
		}
		while(node != null) {
			if(node.Data == value) {
				if(node.leftNode == null) {
					node.leftNode = newNode;
					//newNode.parentNode = node;
					return;
				}else if(node.rightNode == null) {
					node.rightNode = newNode;
					return;
				}else {
					node = node.leftNode;
				}
			}else if(value < node.Data) {
				if(node.leftNode == null) {
					node.leftNode = newNode;
					return;
				}
				node = node.leftNode;
			}else {
				if(node.rightNode == null) {
					node.leftNode = newNode;
					return;
				}
			}
			if(node == null) {
				this.Root = newNode;
			}
		}
	}*/
	
	/*public Boolean Remove(int data) {
		Node node = this.Search(data);
		if(node == null) {
			return false;
		}else {
			if(node.leftNode == null && node.rightNode == null) {
				Node parent = node.parentNode;
				if(parent.leftNode == node) {
					parent.leftNode = null;
				} else if(parent.rightNode == node) {
					parent.rightNode = null;
				}
				node.parentNode = null;
			}
		}
	}*/
	
	public boolean Remove(int value) {
		Node parent = null;
		Node currentNode = Root;
		while(currentNode != null) {
			if(currentNode.Data == value) {
				if(currentNode.leftNode == null && currentNode.rightNode == null) {
					if(parent == null) {
						Root = null;
					}else if(parent.leftNode == currentNode) {
						parent.leftNode = null;
					}else {
						parent.rightNode = null;
					}
					return true;
				}else if(currentNode.leftNode != null && currentNode.rightNode == null) {
					if(parent == null) {
						Root = currentNode.leftNode;
					}else if(parent.leftNode == currentNode) {
						parent.leftNode = currentNode.leftNode;
					}else {
						parent.rightNode = currentNode.leftNode;
					}
					return true;
				}else if(currentNode.leftNode == null && currentNode.rightNode != null) {
					if(parent == null) {
						Root = currentNode.rightNode;
					}else if(parent.leftNode == currentNode) {
						parent.leftNode = currentNode.rightNode;
					}else {
						parent.rightNode = currentNode.rightNode;
					}
					return true;
				}else {
					Node successor = currentNode.rightNode;
					while(successor.leftNode != null) {
						successor = successor.leftNode;
					}
					currentNode.Data = successor.Data;
					parent = currentNode;
					currentNode = currentNode.rightNode;
					value = successor.Data;
				}
			}else if(currentNode.Data < value) {
				parent = currentNode;
				currentNode = currentNode.rightNode;
			}else {
				parent = currentNode;
				currentNode = currentNode.rightNode;
			}
		}
		return false;
	}
	public void printTree() {
		BinarySearchTree dupTree = this;
		Node root = dupTree.Root;
		String list = "";
		list = root.Data + " " + list;
		Node current = root;
			while(root.leftNode != null) {
				current = root;
				if(current.leftNode == null && current.rightNode == null) {
					list = current.Data + ", " + list;
					current = null;
				}
				while(current != null) {
					if(current.leftNode != null) {
						current = current.leftNode;
					}else {
						current = current.rightNode;
					}
					if(current.leftNode == null && current.rightNode == null) {
						list = current.Data + ", " + list;
						current = null;
					}
				}

			}
			while(root.rightNode != null) {
				current = root;
				if(current.leftNode == null && current.rightNode == null) {
					list = current.Data + ", " + list;
					current = null;
				}
				while(current != null) {
					if(current.leftNode != null) {
						current = current.leftNode;
					}else {
						current = current.rightNode;
					}
					if(current.leftNode == null && current.rightNode == null) {
						list = current.Data + ", " + list;
						current = null;
					}
				}

			}
		System.out.println(list);
	}
	
}
