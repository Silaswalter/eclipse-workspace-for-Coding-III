package pack;

public class OpenAdress {
	public int Key;
	public int Value;
	
	public OpenAdress(int Key, int Value) {
		this.Key = Key;
		this.Value = Value;
	}
	
	@Override
	public String toString() {
		return "{" + this.Key + ":" + this.Value + "}";
	}

}
