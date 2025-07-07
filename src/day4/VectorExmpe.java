package day4;
import java.util.Vector;

public class VectorExmpe {

	public static void main(String[] args) {
		//default size i.e, 10 size vector
		Vector<Integer> vector = new Vector<Integer>();
//vector initialized with size 15 & each time incremented by 3 i.e 18,21
//		Vector<Integer> vector = new Vector<Integer>(15,3);
		for (int i = 0; i < 14; i++) {
			vector.addElement(i);
		}
		System.out.println(vector);
		vector.removeElement(10);
		System.out.println("capacity" + vector.capacity());
		System.out.println();

	}

}
