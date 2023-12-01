package pack;

public class HashTable_Chaining extends HashTable {
	public Chain[] Table;
	
	public int Size;
	
	public HashTable_Chaining(int Size) {
		this.Size = Size;
		this.Table = new Chain[Size];
		for(int i = 0; i <)
	}
	
	//hashing is the process to translate a key into a value for indexing/searching
	public int Hashing(int key) {
		//use modulo for the hashing
		int result = key % this.Size;
		return result;
	}
	
	@Override
	public void HashInsert(int key, int value) {
		//1 look for the index based on the key
		int index = Hashing(key);
		Chain target = Table[index];
		//2 look on the chain to find the node with the key
		Node targetNode = target.SearchNodeByKey(key);
		if(targetNode != null) {
			targetNode.Value = value;
		} else {
			target
		}

	}

	@Override
	public boolean HashSearch(int key) {
		//1 look for the index based on the key
		int index = Hashing(key);
		Chain target = Table[index];
		//2 look on the chain/linked list search for the key
		return target.SearchByKey(key);
	}

	@Override
	public void HashDelete(int key) {
		// TODO Auto-generated method stub

	}

}
