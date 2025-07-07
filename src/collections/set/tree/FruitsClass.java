package collections.set.tree;

public class FruitsClass implements Comparable<FruitsClass>  {

	String name;
	
	public FruitsClass() {
		
	}

	public FruitsClass(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(FruitsClass o) {
		return o.name.compareTo(this.name);
	}

	@Override
	public String toString() {
		return "FruitsClass [name=" + name + "]";
	}


	
	

	

	

}
