package pack;
import java.util.Random;

public class driver {

	public static void main(String[] args) {
		HashTable_Chaining hash = new HashTable_Chaining(10);
		makeChains(hash, 20);
		System.out.println(hash);
		HashTable_LinearProbe prob = new HashTable_LinearProbe(10);
		makeProbes(prob, 10);
		System.out.println(prob);

		
	}
	
	public static void makeChains(HashTable_Chaining hash, int num) {
		Random random = new Random();
		for(int i = 0; i < num; i++) {
			int x = random.nextInt(100);
			hash.HashInsert(x, x);
			
		}
		
	}
	
	public static void makeProbes(HashTable_LinearProbe prob, int num) {
		Random random = new Random();
		for(int i = 0; i < num; i++) {
			int x = random.nextInt(100);
			prob.HashInsert(x, x);
			
		}
	}

}
