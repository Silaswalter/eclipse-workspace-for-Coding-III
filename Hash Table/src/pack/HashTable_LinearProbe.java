package pack;

public class HashTable_LinearProbe extends HashTable {
	public OpenAdress[] Table;
	public int Size;

	public HashTable_LinearProbe(int Size) {
		this.Size = Size;
		this.Table = new OpenAdress[Size];
	}
	
	public int Hashing(int key) {
		int result = key % this.Size;
		return result;
	}
	
	@Override
	public void HashInsert(int key, int value) {
		int index = Hashing(key);
		if(this.Table[index] == null) {
			this.Table[index] = new OpenAdress(key, value);
		}else {
			int probed = 0;
			while(probed < this.Size) {
				index = (index + 1) % this.Size;
				if(this.Table[index] == null) {
					this.Table[index] = new OpenAdress(key, value);
					break;
				}
				probed++;
			}
		}
		
		
	}

	@Override
	public boolean HashSearch(int key) {
		int index = Hashing(key);
		if(this.Table[index].Key == key) {
			return true;
		}else {
			int probed = 0;
			while(probed < this.Size) {
				index = (index + 1) % this.Size;
				if(this.Table[index].Key == key) {
					return true;
				}
				probed++;
			}
		}
		return false;
	}

	@Override
	public void HashDelete(int key) {
		int index = Hashing(key);
		if(this.Table[index].Key == key) {
			this.Table[index] = null;
		}else {
			int probed = 0;
			while(probed < this.Size) {
				index = (index + 1) % this.Size;
				if(this.Table[index].Key == key) {
					this.Table[index] = null;
					break;
				}
				probed++;
			}
		}
		
	}
	
	@Override
	public String toString() {
		String output = "";
		for(int i = 0; i < this.Size; i++) {
			if(this.Table[i] != null) {
			output += "[" + i + "]: " + this.Table[i].toString() + "\n";
			}else{
				output += "[" + i + "]: " + "\n";
			}
		}
		return output;
	}

}
