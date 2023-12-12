package pack;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		Random r = new Random();
		int size = 10;
		
		makeTree(tree, size);
		tree.printTree();

		tree.Remove(r.nextInt(size));
		tree.Remove(r.nextInt(size));
		tree.Remove(r.nextInt(size));
		tree.printTree();
		
		System.out.println(r.nextInt(size));
		System.out.println(r.nextInt(size));
		System.out.println(r.nextInt(size));
		tree.printTree();

	}
	
	public static void makeTree(BinarySearchTree tree, int size) {
		int[] result = new int[size];
		Random r = new Random();
		for(int i = 0; i < size; i++)
		{
			result[i] = i;
		}
		for(int i = 0; i < size; i++)
		{
			int pos = r.nextInt(size);
			int temp = result[i];
			result[i] = result[pos];
			result[pos] = temp;
		}
		for(int i = 0; i < size; i++) {
			int temp = result[i];
			System.out.println(temp);
			tree.Insert(temp);
		}
	}
	
}
