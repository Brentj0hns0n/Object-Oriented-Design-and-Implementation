package assign5;

public interface Iterator {
	
	public boolean hasNext(); //Returns true if the iteration has more elems
	public Student next(); //Returns the next element in the iteration
	public void remove(); 
}
